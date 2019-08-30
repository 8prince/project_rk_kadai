CREATE TABLE IF NOT EXISTS tasks(
    number INT PRIMARY KEY,
    title VARCHAR(50),       -- CHAR より VARCHAR の方が良さげ
    description VARCHAR(50)  -- CHAR より VARCHAR の方が良さげ
);