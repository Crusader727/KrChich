CREATE TABLE Underground(
  id SERIAL PRIMARY KEY,
  city TEXT,
  branches_amount INTEGER,
  stations_amount INTEGER
);

CREATE TABLE Branch(
  id SERIAL PRIMARY KEY ,
  name TEXT,
  color TEXT,
  underground_id INTEGER REFERENCES Underground(id)
);

CREATE TABLE Branch_stats(
  id SERIAL PRIMARY KEY ,
  branch_id INTEGER REFERENCES Branch(id),
  date TIMESTAMP ,
  entered_amount INTEGER,
  exited_amount INTEGER
);

CREATE TABLE Station(
  id SERIAL PRIMARY KEY ,
  name TEXT,
  branch_id INTEGER REFERENCES Branch(id)
);

CREATE TABLE Station_stats(
  id SERIAL PRIMARY KEY ,
  date TIMESTAMP ,
  station_id INTEGER REFERENCES Station(id),
  entered BOOLEAN
);

CREATE TABLE Train(
  id SERIAL PRIMARY KEY ,
  serialNo INTEGER,
  branch_id INTEGER REFERENCES Branch(id)
);

CREATE TABLE Carriage(
  id SERIAL PRIMARY KEY,
  serialNo INTEGER,
  seats INTEGER,
  train_id INTEGER REFERENCES Train(id)
);