DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  surname VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL,
  state VARCHAR(250) DEFAULT 'ADDED'
);

INSERT INTO employee (name, surname, email) VALUES
  ('Michael', 'Green', 'm.green@test.com'),
  ('Rachel', 'Red', 'r.red@test.com'),
  ('Ivan', 'Brown', 'i.brown@test.com');