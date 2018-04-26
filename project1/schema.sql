CREATE TABLE user (
	id INT AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(30) NOT NULL UNIQUE,
	password VARCHAR(30) NOT NULL
);

CREATE TABLE wallet (
	id INT AUTO_INCREMENT PRIMARY KEY,
	credit DECIMAL(20,2) NOT NULL,
	id_user INT NOT NULL,
	FOREIGN KEY (id_user) REFERENCES user(id) ON DELETE CASCADE
);

CREATE TABLE house (
	id INT PRIMARY KEY,
	name VARCHAR(60) NOT NULL,
	address VARCHAR(100) NOT NULL,	
	city VARCHAR(60) NOT NULL,		
	latitude FLOAT(10,6) NOT NULL,
	longitude FLOAT(10,6) NOT NULL,
	type VARCHAR(30) NOT NULL,
	price DECIMAL(20,2) NOT NULL,
	area INT NOT NULL,
	E_class CHAR NOT NULL
);

--update on house --> dependency on marker

CREATE TABLE marker (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(60) NOT NULL,
	address VARCHAR(100) NOT NULL, 
	latitude FLOAT(10,6) NOT NULL,
	longitude FLOAT(10,6) NOT NULL,
	type VARCHAR(30) NOT NULL,
	id_house INT NOT NULL,
	FOREIGN KEY (id_house) REFERENCES house(id) ON DELETE CASCADE
);


INSERT INTO house(id,name,address,city,latitude,longitude,type,price,area,E_class) VALUES (1,'building1', 'Viale Lunigiana, 15', 'Milano', 45.491684, 9.204736, 'Trilocale', 100000.00, 100, 'B');
INSERT INTO house(id,name,address,city,latitude,longitude,type,price,area,E_class) VALUES (2,'building2', 'Via Angelo De Vincenti, 6', 'Milano', 45.477931, 9.141652, 'Bilocale', 120000.00, 120, 'C');
INSERT INTO house(id,name,address,city,latitude,longitude,type,price,area,E_class) VALUES (3,'building3', 'Via Pinamonte da Vimercate, 3', 'Milano', 45.479081, 9.182454, 'Trilocale', 130000.00, 90, 'A');
INSERT INTO house(id,name,address,city,latitude,longitude,type,price,area,E_class) VALUES (4,'building4', 'Corso di Porta Nuova, 34', 'Milano', 45.477285, 9.192178, 'Quadrilocale', 305000.00, 95, 'A');
INSERT INTO house(id,name,address,city,latitude,longitude,type,price,area,E_class) VALUES (5,'building5', 'Via Emilio Cornalia, 12', 'Milano', 45.483139, 9.197228, 'Loft', 180000.00, 110, 'G');
INSERT INTO house(id,name,address,city,latitude,longitude,type,price,area,E_class) VALUES (6,'building6', 'Via Filippo Turati, 29', 'Milano', 45.477429, 9.195515, 'Plurilocale', 350000.00, 105, 'A');


INSERT INTO marker(name,address,latitude,longitude,type, id_house) VALUES ('building1', 'Viale Lunigiana, 15, Milano', 45.491684, 9.204736, 'Trilocale', 1);
INSERT INTO marker(name,address,latitude,longitude,type, id_house) VALUES ('building2', 'Via Angelo De Vincenti, 6, Milano', 45.477931, 9.141652, 'Bilocale', 2);
INSERT INTO marker(name,address,latitude,longitude,type, id_house) VALUES ('building3', 'Via Pinamonte da Vimercate, 3, Milano', 45.479081, 9.182454, 'Trilocale', 3);
INSERT INTO marker(name,address,latitude,longitude,type, id_house) VALUES ('building4', 'Corso di Porta Nuova, 34, Milano', 45.477285, 9.192178, 'Quadrilocale', 4);
INSERT INTO marker(name,address,latitude,longitude,type, id_house) VALUES ('building5', 'Via Emilio Cornalia, 12, Milano', 45.483139, 9.197228, 'Loft', 5);
INSERT INTO marker(name,address,latitude,longitude,type, id_house) VALUES ('building6', 'Via Filippo Turati, 29, Milano', 45.477429, 9.195515, 'Plurilocale', 6);