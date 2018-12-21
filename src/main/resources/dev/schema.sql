CREATE TABLE if not EXISTS city (
    id INT PRIMARY KEY auto_increment,
   name VARCHAR(50),
    state VARCHAR(50),
    country VARCHAR(50)
);


CREATE TABLE if not EXISTS job (
    id INT PRIMARY KEY auto_increment,
    name VARCHAR(50),
    status tinyint,
    version int,
    node varchar(5),
    timestamp date
);

CREATE TABLE if not EXISTS user (
  id INT PRIMARY KEY auto_increment,
  name VARCHAR(50),
  age INT,
  email VARCHAR(50)
);