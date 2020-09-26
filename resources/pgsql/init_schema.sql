CREATE USER resilience WITH password 'resilience';

CREATE SCHEMA resilience;
ALTER USER resilience SET search_path = 'resilience, public';

GRANT USAGE, CREATE ON SCHEMA resilience TO resilience;
GRANT ALL ON ALL TABLES IN SCHEMA resilience TO resilience;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA resilience TO resilience;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA resilience TO resilience;
GRANT EXECUTE ON ALL FUNCTIONS IN SCHEMA resilience TO resilience;

SET SCHEMA 'resilience';
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
GRANT EXECUTE ON FUNCTION uuid_generate_v4() TO resilience;
