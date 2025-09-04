CREATE TABLE IF NOT EXISTS users (
  id SERIAL PRIMARY KEY,
  firstName TEXT NOT NULL,
  lastName TEXT NOT NULL,
  email TEXT NOT NULL,
  role  TEXT NOT NULL
);

INSERT INTO users (firstName, lastName, email, role) VALUES
('Michael','Jackson','Jackson@example.com','Admin'),
('Keanu','Reeves','Reeves@example.com','User'),
('Will','Smit','Smit@example.com','User'),
('Frank','Sinatra','Sinatra@example.com','User'),
('Barry','Allen','Allen@example.com','User'),
('Lewis','Hamilton','Hamilton@example.com','User'),
('Bobby','Fisher','Fisher@example.com','User'),
('Chris','Hemsworth','Hemsworth@example.com','User'),
('Tony','Stark','Stark@example.com','User'),
('Fred','Scooby','Scooby@example.com','User')
