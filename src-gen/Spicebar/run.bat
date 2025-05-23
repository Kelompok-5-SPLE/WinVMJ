echo SELECT 'CREATE DATABASE restaurantservicesystem_product_spicebar' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'restaurantservicesystem_product_spicebar') \gexec | psql "postgresql://postgres:iniKUNCI123@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:iniKUNCI123@localhost/restaurantservicesystem_product_spicebar"

java -cp restaurantservicesystem.product.spicebar --module-path restaurantservicesystem.product.spicebar -m restaurantservicesystem.product.spicebar