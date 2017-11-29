CREATE DATABASE `retailinWebAppDB`;
Use retailinWebAppDB

DROP TABLE IF EXISTS `retailinWebAppDB`
CREATE TABLE IF NOT EXISTS `retailinWebAppDB`.`users` (
  `emp_id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(40) NOT NULL,
  `last_name` VARCHAR(40) NOT NULL,
  `first_name` VARCHAR(40) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `phone_number` VARCHAR(12) NOT NULL,
  `enabled` TINYINT(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`emp_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 20
DEFAULT CHARACTER SET = utf8