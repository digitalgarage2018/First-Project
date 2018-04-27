CREATE TABLE markers (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(60) NOT NULL,
	address VARCHAR(100) NOT NULL,
	latitude FLOAT(10,6) NOT NULL,
	longitude FLOAT(10,6) NOT NULL,
	type VARCHAR(30) NOT NULL
);

INSERT INTO markers(name,address,latitude,longitude,type) VALUES ('building1', 'Viale Lunigiana, 15', 45.491684, 9.204736, 'Trilocale');
INSERT INTO markers(name,address,latitude,longitude,type) VALUES ('building2', 'Via Angelo De Vincenti, 6', 45.477931, 9.141652, 'Bilocale');
INSERT INTO markers(name,address,latitude,longitude,type) VALUES ('building3', 'Via Pinamonte da Vimercate, 3', 45.479081, 9.182454, 'Trilocale');
INSERT INTO markers(name,address,latitude,longitude,type) VALUES ('building4', 'Corso di Porta Nuova, 34', 45.477285, 9.192178, 'Quadrilocale');
INSERT INTO markers(name,address,latitude,longitude,type) VALUES ('building5', 'Via Emilio Cornalia, 12', 45.483139, 9.197228, 'Loft');
INSERT INTO markers(name,address,latitude,longitude,type) VALUES ('building6', 'Via Filippo Turati, 29', 45.477429, 9.195515, 'Plurilocale');
