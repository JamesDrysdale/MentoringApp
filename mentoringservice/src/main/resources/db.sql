CREATE TABLE members (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    bio VARCHAR(1000),
    linkedin VARCHAR(100)
);