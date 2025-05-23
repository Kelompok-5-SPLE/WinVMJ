#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    rm java.log
    exit 1
}

trap cleanup SIGINT

java -cp restaurantservicesystem.product.restaurantfirst --module-path restaurantservicesystem.product.restaurantfirst -m restaurantservicesystem.product.restaurantfirst 2>&1 | tee java.log &
JAVA_PID=$!
TEE_PID=$(pgrep -n tee)
tail -f java.log --pid=$TEE_PID | while read -r LINE; do
    if [[ "$LINE" == *"== CREATING OBJECTS AND BINDING ENDPOINTS =="* ]]; then
        break
    fi
done

echo "SELECT 'CREATE DATABASE restaurantservicesystem_product_restaurantfirst' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'restaurantservicesystem_product_restaurantfirst') \gexec" | psql "postgresql://postgres:iniKUNCI123@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:iniKUNCI123@localhost/restaurantservicesystem_product_restaurantfirst"
done

wait