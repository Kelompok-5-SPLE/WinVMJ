echo SELECT 'CREATE DATABASE restaurantservicesystem_product_default' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'restaurantservicesystem_product_default') \gexec | psql "postgresql://postgres:murifq@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:murifq@localhost/restaurantservicesystem_product_default"

java -cp restaurantservicesystem.product.default --module-path restaurantservicesystem.product.default -m restaurantservicesystem.product.default