CREATE TABLE anniversary (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             writer VARCHAR(255) NOT NULL,
                             title VARCHAR(255) NOT NULL,
                             withpeople VARCHAR(255) NOT NULL,
                             content TEXT NOT NULL,
                             antime TIMESTAMP NOT NULL,
                             email VARCHAR(255) NOT NULL,

);