CREATE TABLE releases (
	code BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	description VARCHAR(50) NOT NULL,
	due_date DATE NOT NULL,
	pay_day DATE,
	value DECIMAL(10,2) NOT NULL,
	note VARCHAR(100),
	type VARCHAR(20) NOT NULL,
	code_category BIGINT(20) NOT NULL,
	code_person BIGINT(20) NOT NULL,
	FOREIGN KEY (code_category) REFERENCES category(code),
	FOREIGN KEY (code_person) REFERENCES person(code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO releases (description, due_date, pay_day, value, note, type, code_category, code_person) 
VALUES ('Monthly salary', '2017-06-10', null, 6500.00, 'Distribution of profits', 'REVENUE', 1, 1);

INSERT INTO releases (description, due_date, pay_day, value, note, type, code_category, code_person) 
VALUES ('Bahamas', '2017-02-10', '2017-02-10', 100.32, null, 'EXPENSES', 2, 2);

INSERT INTO releases (description, due_date, pay_day, value, note, type, code_category, code_person) 
VALUES ('Top Club', '2017-06-10', null, 120, null, 'REVENUE', 3, 3);

INSERT INTO releases (description, due_date, pay_day, value, note, type, code_category, code_person) 
VALUES ('CEMIG', '2017-02-10', '2017-02-10', 110.44, 'Generation', 'REVENUE', 3, 4);

INSERT INTO releases (description, due_date, pay_day, value, note, type, code_category, code_person) 
VALUES ('DMAE', '2017-06-10', null, 200.30, null, 'EXPENSES', 4, 5);

INSERT INTO releases (description, due_date, pay_day, value, note, type, code_category, code_person) 
VALUES ('Extra', '2017-03-10', '2017-03-10', 1010.32, null, 'REVENUE', 4, 6);
 
INSERT INTO releases (description, due_date, pay_day, value, note, type, code_category, code_person) 
VALUES ('Bahamas', '2017-06-10', null, 500, null, 'REVENUE', 5, 7);

INSERT INTO releases (description, due_date, pay_day, value, note, type, code_category, code_person) 
VALUES ('Top Club', '2017-03-10', '2017-03-10', 400.32, null, 'EXPENSES', 3, 5);

INSERT INTO releases (description, due_date, pay_day, value, note, type, code_category, code_person) 
VALUES ('Forwarding agent', '2017-06-10', null, 123.64, 'Fines', 'EXPENSES', 2, 2);

INSERT INTO releases (description, due_date, pay_day, value, note, type, code_category, code_person) 
VALUES ('Tires', '2017-04-10', '2017-04-10', 665.33, null, 'REVENUE', 1, 4);

INSERT INTO releases (description, due_date, pay_day, value, note, type, code_category, code_person) 
VALUES ('Coffee', '2017-06-10', null, 8.32, null, 'EXPENSES', 1, 7);

INSERT INTO releases (description, due_date, pay_day, value, note, type, code_category, code_person) 
VALUES ('Eletronics', '2017-04-10', '2017-04-10', 2100.32, null, 'EXPENSES', 5, 6);

INSERT INTO releases (description, due_date, pay_day, value, note, type, code_category, code_person) 
VALUES ('Instruments', '2017-06-10', null, 1040.32, null, 'EXPENSES', 2, 1);

INSERT INTO releases (description, due_date, pay_day, value, note, type, code_category, code_person) 
VALUES ('Coffee', '2017-04-10', '2017-04-10', 4.32, null, 'EXPENSES', 4, 3);

INSERT INTO releases (description, due_date, pay_day, value, note, type, code_category, code_person) 
VALUES ('Snack', '2017-06-10', null, 10.20, null, 'EXPENSES', 4, 2);