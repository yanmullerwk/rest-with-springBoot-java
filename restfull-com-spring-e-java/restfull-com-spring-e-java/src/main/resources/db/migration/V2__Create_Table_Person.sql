CREATE TABLE IF NOT EXISTS `person` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `first_name` varchar(100) NOT NULL,
    `last_name` varchar(100) NOT NULL,
    `address` varchar(100) NOT NULL,
    `gender` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
    );


