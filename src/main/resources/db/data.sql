---- Inserting data
------ Add companies
INSERT INTO COMPANY VALUES (1, 'Effortel', 'Europe/Brussels');

------ Add branches
INSERT INTO BRANCH VALUES (1, 'Sales 1', 'Europe/Moscow', 1);
INSERT INTO BRANCH VALUES (2, 'Main Office', 'Africa/Cairo', 1);
INSERT INTO BRANCH VALUES (3, 'Sales 2', 'America/Los_Angeles', 1);
INSERT INTO BRANCH VALUES (4, 'Engineering Office', 'Europe/Sofia', 1);
INSERT INTO BRANCH VALUES (5, 'HQ', 'Europe/Brussels', 1);

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
INSERT INTO DRIVER VALUES (1, 'Ismael Osama', 'IO48464');
INSERT INTO DRIVER VALUES (2, 'Mohamed Taman', 'MT48464');
INSERT INTO DRIVER VALUES (3, 'Emanuil Donchev', 'ED48464');
INSERT INTO DRIVER VALUES (4, 'Kostadin Mehomiyski', 'KM48464');

------ Add a Customer comments
INSERT INTO CUSTOMER VALUES (1, 'Pavel Ganov');
INSERT INTO CUSTOMER VALUES (2, 'Teodora Stamenova');
INSERT INTO CUSTOMER VALUES (3, 'Petko Tsankov');
