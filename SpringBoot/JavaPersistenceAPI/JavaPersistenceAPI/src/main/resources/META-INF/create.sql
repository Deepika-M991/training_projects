CREATE TABLE bookstore_table (  gen_name VARCHAR(16) NOT NULL,    gen_val INT NOT NULL);

-- Insert values into bookstore_table
INSERT INTO bookstore_table (gen_name, gen_val) VALUES ('book_id', 1);
INSERT INTO bookstore_table (gen_name, gen_val) VALUES ('author_id', 1000);

-- Create the book table
CREATE TABLE book (    id INT NOT NULL PRIMARY KEY,    title VARCHAR(128),    author VARCHAR(64),    price FLOAT);

-- Create the author table
CREATE TABLE author (    id INT PRIMARY KEY,     name VARCHAR(128),    birthDate DATE);