echo SELECT 'CREATE DATABASE restaurantservicesystem_product_default' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'restaurantservicesystem_product_default') \gexec | psql "postgresql://postgres:murifq@localhost:5432/postgres"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://:@localhost/restaurantservicesystem_product_default"

java -cp "restaurantservicesystem.product.default/*" product.default