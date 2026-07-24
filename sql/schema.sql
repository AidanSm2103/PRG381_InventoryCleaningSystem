// SQL Schema for creating the database tables

CREATE TABLE users (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

CREATE TABLE materials (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100) NOT NULL,
    quantity INT NOT NULL DEFAULT 0,
    reorder_level INT NOT NULL DEFAULT 0
);

CREATE TABLE suppliers (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100) NOT NULL,
    contact_number VARCHAR(20),
    email VARCHAR(100)
);

CREATE TABLE cleaners (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100)
);

CREATE TABLE issuances (
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    material_id INT NOT NULL,
    cleaner_id INT NOT NULL,
    quantity INT NOT NULL,
    date_issued DATE NOT NULL,
    FOREIGN KEY (material_id) REFERENCES materials(id),
    FOREIGN KEY (cleaner_id) REFERENCES cleaners(id)
);

