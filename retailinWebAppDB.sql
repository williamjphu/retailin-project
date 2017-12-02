CREATE DATABASE  IF NOT EXISTS retailinWebAppDB;
USE retailinWebAppDB;

DROP TABLE IF EXISTS users;
CREATE TABLE users (
  emp_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  first_name varchar(45) DEFAULT NULL,
  password varchar(70) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  phone_number varchar(12) DEFAULT NULL,
  enabled boolean DEFAULT 1,
  PRIMARY KEY (emp_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

LOCK TABLES `customer` WRITE;
INSERT INTO `customer` VALUES 
	(1,'David','Adams','david@luv2code.com'),
	(2,'John','Doe','john@luv2code.com'),
	(3,'Ajay','Rao','ajay@luv2code.com'),
	(4,'Mary','Public','mary@luv2code.com'),
	(5,'Maxwell','Dixon','max@luv2code.com');
UNLOCK TABLES;

DROP TABLE IF EXISTS roles;
CREATE TABLE roles (
	roles_id int(11) NOT NULL,
	username varchar(45) NOT NULL,
	authority varchar(45),
	CONSTRAINT fk_roles_users FOREIGN KEY(roles_id, username) REFERENCES users(emp_id, username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
