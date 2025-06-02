#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    rm java.log
    exit 1
}

trap cleanup SIGINT

java -cp restaurantservicesystem.product.spicebar --module-path restaurantservicesystem.product.spicebar -m restaurantservicesystem.product.spicebar 2>&1 | tee java.log &
JAVA_PID=$!
TEE_PID=$(pgrep -n tee)
tail -f java.log --pid=$TEE_PID | while read -r LINE; do
    if [[ "$LINE" == *"== CREATING OBJECTS AND BINDING ENDPOINTS =="* ]]; then
        break
    fi
done

echo "SELECT 'CREATE DATABASE restaurantservicesystem_product_spicebar' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'restaurantservicesystem_product_spicebar') \gexec" | psql "postgresql://postgres:postgres@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:postgres@localhost/restaurantservicesystem_product_spicebar"
done

wait