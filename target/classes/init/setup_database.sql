-- Create the user if it does not already exist
DO
$$
BEGIN
   IF NOT EXISTS (SELECT FROM pg_catalog.pg_roles WHERE rolname = '123') THEN
      CREATE ROLE "123" WITH LOGIN PASSWORD '123';
   END IF;
END
$$;

-- Ensure the user has privileges on the database
GRANT CONNECT ON DATABASE mydatabase TO "123";

-- Grant usage on all schemas (adjust schema if needed, or use 'public' if default schema)
GRANT USAGE ON SCHEMA public TO "123";

-- Grant privileges on all existing tables in the public schema for the user
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO "123";

-- Grant privileges on all sequences in the public schema
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO "123";

-- Ensure future tables and sequences also have the right permissions
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL PRIVILEGES ON TABLES TO "123";
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL PRIVILEGES ON SEQUENCES TO "123";