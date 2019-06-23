CREATE TABLE person (
	code BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	placePublic VARCHAR(50),
	addressNumber VARCHAR(50),
	complement VARCHAR(50),
	neighborhood VARCHAR(50),
	zipCode VARCHAR(50),
	city VARCHAR(50),
	state VARCHAR(50),
	active BOOLEAN
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO person (name, placePublic, addressNumber, complement, neighborhood, zipCode, city, state, active) 
VALUES ('Ann J. Stevens', 'Stockert Hollow Road', '2217', 'Sun Valley', 'Bluemont', '98161', 'Seattle', 'Washington', true);

INSERT INTO person (name, placePublic, addressNumber, complement, neighborhood, zipCode, city, state, active) 
VALUES ('Chan R. Drake', 'Shadowmar Drive', '4367', 'Path of the lakes', 'Overlake', '70006', 'Metairie', 'Los Angeles', true);

INSERT INTO person (name, placePublic, addressNumber, complement, neighborhood, zipCode, city, state, active) 
VALUES ('Victoria P. Caruthers', 'Ferguson Street', '4240', 'Coast of Virtue', 'Rose Isle', '02110', 'Boston', 'Massachusetts', true);

INSERT INTO person (name, placePublic, addressNumber, complement, neighborhood, zipCode, city, state, active) 
VALUES ('Carlos E. Goodwin', 'Maryland Avenue', '4321', 'Route de Vendôme', 'Colonial Village', '34622', 'Feather Sound', 'Florida', true);

INSERT INTO person (name, placePublic, addressNumber, complement, neighborhood, zipCode, city, state, active) 
VALUES ('Kenya J. Peltier', 'Traders Alley', '1065', 'Namour Way', 'Southeast Redmond', '64105', 'Kansas City', 'Missouri', true);

INSERT INTO person (name, placePublic, addressNumber, complement, neighborhood, zipCode, city, state, active) 
VALUES ('Mark S. Iverson', 'Philadelphia Avenue', '3259', 'Station Monk', 'Spanishtown', '84058', 'Salt Lake City', 'Utah', true);

INSERT INTO person (name, placePublic, addressNumber, complement, neighborhood, zipCode, city, state, active) 
VALUES ('Susan R. Woodworth', 'Briarhill Lane', '1370', 'Lac aux Castors', 'Vila Marie', '43840', 'Stone Creek', 'Ohio', true);