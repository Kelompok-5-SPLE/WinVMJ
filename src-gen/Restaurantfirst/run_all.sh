#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE restaurantservicesystem_product_restaurantfirst' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'restaurantservicesystem_product_restaurantfirst') \gexec" | psql "postgresql://postgres:iniKUNCI123@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:iniKUNCI123@localhost/restaurantservicesystem_product_restaurantfirst"
done

java -cp restaurantservicesystem.product.restaurantfirst --module-path restaurantservicesystem.product.restaurantfirst -m restaurantservicesystem.product.restaurantfirst &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait