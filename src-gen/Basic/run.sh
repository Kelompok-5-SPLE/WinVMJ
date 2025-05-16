#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    rm java.log
    exit 1
}

trap cleanup SIGINT

java -cp restaurantservicesystem.product.basic --module-path restaurantservicesystem.product.basic -m restaurantservicesystem.product.basic 2>&1 | tee java.log &
JAVA_PID=$!
TEE_PID=$(pgrep -n tee)
tail -f java.log --pid=$TEE_PID | while read -r LINE; do
    if [[ "$LINE" == *"== CREATING OBJECTS AND BINDING ENDPOINTS =="* ]]; then
        break
    fi
done

echo "SELECT 'CREATE DATABASE restaurantservicesystem_product_basic' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'restaurantservicesystem_product_basic') \gexec" | psql "postgresql://postgres:murifq@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:murifq@localhost/restaurantservicesystem_product_basic"
done

wait