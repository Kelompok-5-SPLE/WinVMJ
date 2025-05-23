echo SELECT 'CREATE DATABASE restaurantservicesystem_product_restaurantfirst' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'restaurantservicesystem_product_restaurantfirst') \gexec | psql "postgresql://postgres:iniKUNCI123@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:iniKUNCI123@localhost/restaurantservicesystem_product_restaurantfirst"

java -cp restaurantservicesystem.product.restaurantfirst --module-path restaurantservicesystem.product.restaurantfirst -m restaurantservicesystem.product.restaurantfirst