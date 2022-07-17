---- Inserting data
------ Add companies
INSERT INTO COMPANY VALUES (1, 'FizzBus', 'Europe/Brussels');

------ Add branches
INSERT INTO BRANCH VALUES (1, 'Moscow Office', 'Europe/Moscow', 1);
INSERT INTO BRANCH VALUES (2, 'Main Office', 'Africa/Cairo', 1);
INSERT INTO BRANCH VALUES (3, 'USA Office', 'America/Los_Angeles', 1);
INSERT INTO BRANCH VALUES (4, 'Europe Office', 'Europe/Sofia', 1);
INSERT INTO BRANCH VALUES (5, 'HQ Office', 'Europe/Brussels', 1);

------ Add a Car
INSERT INTO CAR VALUES (1, 'Toyota', 'C100', 'Green', '131ASDF', 1);
INSERT INTO CAR VALUES (2, 'Honda', 'C110', 'Yellow', '131QWER', 1);

INSERT INTO CAR VALUES (3, 'Toyota', 'C200', 'Red', '131HJKM', 2);
INSERT INTO CAR VALUES (4, 'Honda', 'C210', 'Green', '131GHKA', 2);

INSERT INTO CAR VALUES (5, 'Toyota', 'C300', 'White', '131UBSE', 3);
INSERT INTO CAR VALUES (6, 'Honda', 'C310', 'Black', '131AKXU', 3);

INSERT INTO CAR VALUES (7, 'Toyota', 'C400', 'Magenta', '131QAZX', 4);
INSERT INTO CAR VALUES (8, 'Honda', 'C410', 'Pink', '131MKIO', 4);

INSERT INTO CAR VALUES (9, 'Toyota', 'C500', 'Blue', '131QDPH', 5);
INSERT INTO CAR VALUES (10, 'Honda', 'C510', 'Metallic', '131GTFR', 5);

------ Add a Driver
INSERT INTO DRIVER VALUES (1, 'Osvaldo Walter', 'IO48464');
INSERT INTO DRIVER VALUES (2, 'Mohamed Taman', 'MT48464');
INSERT INTO DRIVER VALUES (3, 'Amelia Wiggins', 'ED48464');
INSERT INTO DRIVER VALUES (4, 'Lillie Herman', 'KM48464');

------ Add a Customer comments
INSERT INTO CUSTOMER VALUES (1, 'Adam Leblanc', '1984-10-15');
INSERT INTO CUSTOMER VALUES (2, 'Malakai Rocha', '1973-05-20');
INSERT INTO CUSTOMER VALUES (3, 'Mitchell Decker', '1992-11-22');
