DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY, --(long) (identificador únic, automàtic)
    name VARCHAR(100) NOT NULL, --(string), no pot ser null
    description VARCHAR(500) NOT NULL, -- (string), no pot ser null
    email VARCHAR(100) NOT NULL UNIQUE, --(string), no pot ser null i ha de ser únic
    password VARCHAR(100) NOT NULL, --(string), no pot ser null
    ultimAcces DATETIME, --(timestamp)
    dataCreated DATETIME, -- (timestamp, automàtic) - Treball autònom
    dataUpdated DATETIME --(timestamp, automàtic) - Treball autònom
);