CREATE USER swedbank WITH ENCRYPTED PASSWORD 'changeme';
GRANT ALL ON SCHEMA public TO swedbank;

CREATE DATABASE swedbank_test;
GRANT ALL PRIVILEGES ON DATABASE swedbank_test TO swedbank;
ALTER DATABASE swedbank_test OWNER TO swedbank;