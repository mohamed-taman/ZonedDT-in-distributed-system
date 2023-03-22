-- Dropping tables
DROP TABLE IF EXISTS trip;
DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS driver;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS branch;
DROP TABLE IF EXISTS company;

-- Start - company table definition
CREATE TABLE IF NOT EXISTS company
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(100) NOT NULL,
    timezone VARCHAR(100) NOT NULL
);
-- End - company table definition

-- Start - branch table definition
CREATE TABLE IF NOT EXISTS branch
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    timezone   VARCHAR(100) NOT NULL,
    company_id INT          NOT NULL,

    CONSTRAINT branch_company_fk
        FOREIGN KEY (company_id)
            REFERENCES company (id)
);
-- End - branch table definition

-- Start - Car table definition
CREATE TABLE IF NOT EXISTS car
(
    id                  INT AUTO_INCREMENT PRIMARY KEY,
    model               VARCHAR(100)        NOT NULL,
    chassis_number      VARCHAR(100) UNIQUE NOT NULL,
    color               VARCHAR(100)        NOT NULL,
    registration_number VARCHAR(100) UNIQUE NOT NULL,
    branch_id           INT                 NOT NULL,

    CONSTRAINT car_branch_fk
        FOREIGN KEY (branch_id)
            REFERENCES branch (id)
);
-- End - Car table definition

-- Start - Driver table definition
CREATE TABLE IF NOT EXISTS driver
(
    id             INT AUTO_INCREMENT PRIMARY KEY,
    name           VARCHAR(100) NOT NULL,
    license_number VARCHAR(255) NOT NULL
);
-- End - Driver table definition

-- Start -  Customer table definition
CREATE TABLE IF NOT EXISTS customer
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    birthdate  DATE NOT NULL
);
-- End -  Customer table definition

-- Start -  Trip table definition
CREATE TABLE IF NOT EXISTS trip
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    timezone    VARCHAR(255),
    start_on    TIMESTAMP,
    end_at      TIMESTAMP,
    distance    DOUBLE,
    status      ENUM ('STARTED','IN_PROGRESS','FINISHED','CANCELED') NOT NULL,
    car_id      INT,
    driver_id   INT,
    customer_id INT,

    CONSTRAINT trip_car_fk
        FOREIGN KEY (car_id)
            REFERENCES car (id),

    CONSTRAINT trip_driver_fk
        FOREIGN KEY (driver_id)
            REFERENCES driver (id),

    CONSTRAINT trip_customer_fk
        FOREIGN KEY (customer_id)
            REFERENCES customer (id)
);
-- End -  Trip table definition