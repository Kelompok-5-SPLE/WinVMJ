#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE restaurantservicesystem_product_spicebar' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'restaurantservicesystem_product_spicebar') \gexec" | psql "postgresql://postgres:iniKUNCI123@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:iniKUNCI123@localhost/restaurantservicesystem_product_spicebar"
done

java -cp restaurantservicesystem.product.spicebar --module-path restaurantservicesystem.product.spicebar -m restaurantservicesystem.product.spicebar &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait