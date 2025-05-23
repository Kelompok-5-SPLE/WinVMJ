echo SELECT 'CREATE DATABASE restaurantservicesystem_product_basic' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'restaurantservicesystem_product_basic') \gexec | psql "postgresql://postgres:iniKUNCI123@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:iniKUNCI123@localhost/restaurantservicesystem_product_basic"

java -cp restaurantservicesystem.product.basic --module-path restaurantservicesystem.product.basic -m restaurantservicesystem.product.basic