-- CREATE USER 'reitailnDB'@'localhost' IDENTIFIED BY 'retailinDB'
-- GRANT ALL ON retailinWebAppDB.* TO 'retailinDB'@'localhost'

-- Use user 'retailinDB'
-- Use pass 'retailinDB'

-- CREATE DATABASE  IF NOT EXISTS retailinWebAppDB;
-- USE retailinWebAppDB;

-- Table for Employees=Users
-- Main table to hold employee's infomation
-- MUST be called 'users' due to Spring security specification
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  emp_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  last_name varchar(45) NOT NULL,
  first_name varchar(45) NOT NULL,
  password varchar(70) NOT NULL,
  email varchar(45) NOT NULL,
  phone_number varchar(12) NOT NULL,
  enabled boolean NOT NULL,
  authority varchar(45) NOT NULL,
  PRIMARY KEY (emp_id, username)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- INSERT DEFAULT DATA
LOCK TABLES users WRITE;
INSERT INTO users VALUES 
	("1","admin","admin","admin","admin","admin@retailin.com","0000000000","1","ROLE_ADMIN");
UNLOCK TABLES;

-- Table for Authorities/Roles for each account
-- MUST be called 'authorities' due to Spring Security specification
DROP TABLE IF EXISTS authorities;
CREATE TABLE authorities (
	roles_id int(11) NOT NULL,
	username varchar(45) NOT NULL,
	authority varchar(45) NOT NULL,
	CONSTRAINT fk_roles_users FOREIGN KEY(roles_id, username) REFERENCES users(emp_id, username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Table for departments
-- Details: OneToMany Departments -> Users 
-- One user work_in exaclty one department
DROP TABLE IF EXISTS departments;
CREATE TABLE departments(
	department_id int(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    department_name varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- Table for Payrools
-- Details: ManyToOne Payrolls -> Users
-- One user have many payrolls
DROP TABLE IF EXISTS payrolls;
CREATE TABLE payrolls(
	payroll_id int(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pay_period varchar(10) NOT NULL,
    hourly_rate int(5) NOT NULL,
    worked_hours int(5) NOT NULL,
    emp_id int(11) NOT NULL,
    CONSTRAINT fk_payrolls_users FOREIGN KEY(emp_id) REFERENCES users(emp_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Table for Bank Account 
-- Details: ManyToOne Bank_account -> Users
-- One user have many bank accounts
DROP TABLE IF EXISTS bank_accounts;
CREATE TABLE bank_accounts (
	acct_no int(20) NOT NULL PRIMARY KEY,
    routing_no int(20) NOT NULL,
    acct_type varchar(10) NOT NULL,
    bank_name varchar(45) NOT NULL,
    bank_addr varchar(55) NOT NULL,
    bank_city varchar(10) NOT NULL,
    bank_state varchar(20) NOT NULL,
    emp_id int(11) NOT NULL,
    CONSTRAINT fk_bankAccounts_users FOREIGN KEY(emp_id) REFERENCES users(emp_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Table for Receipts 
-- Details: ManyToOne Receipts -> Users
-- Many receipts are issued by one user
DROP TABLE IF EXISTS receipts;
CREATE TABLE receipts (
	transaction_no int(5) NOT NULL PRIMARY KEY,
    total int(20) NOT NULL,
    date int(10) NOT NULL,
    emp_id int(11) NOT NULL,
    cust_phone int(12) NOT NULL,
    CONSTRAINT fk_receipts_users FOREIGN KEY(emp_id) REFERENCES users(emp_id),
    CONSTRAINT fk_receipts_customers FOREIGN KEY(cust_phone) REFERENCES customers(phone_number)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Table for Customers 
-- Details: ManyToOne Receipts -> Customers
-- Many receipts are issued by one user
DROP TABLE IF EXISTS customers;
CREATE TABLE customers (
	phone_number int(12) NOT NULL PRIMARY KEY,
    first_name varchar(45) NOT NULL,
	last_name varchar(45) NOT NULL,
	email varchar(45) NOT NULL,
    zip_code int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Table for Categories
-- Details: ManyToOne Items -> Categorites
-- Many items belong to exactly one category
DROP TABLE IF EXISTS categories;
CREATE TABLE categories (
	category_id int(11) NOT NULL PRIMARY KEY,
	category_name varchar(45) NOT NULL,
    category_description varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Table for Items
-- Details: ManyToMany
-- Many receipts are in many items
DROP TABLE IF EXISTS items;
CREATE TABLE items (
	item_id int(11) NOT NULL PRIMARY KEY,
    item_name varchar(45) NOT NULL,
    description varchar(60) NOT NULL,
	price int(5) NOT NULL,
    discount int(3) NOT NULL,
    quantity int(5) NOT NULL,
    category_id int(11) NOT NULL,
    CONSTRAINT fk_items_categories FOREIGN KEY(category_id) REFERENCES categories(category_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Table for ManyToMany
-- Details: ManyToMany
-- Many receipts are in many items
DROP TABLE IF EXISTS is_in;
CREATE TABLE is_in (
	item_id int(11) NOT NULL,
    transaction_no int(5) NOT NULL,
    quantity int(5) DEFAULT NULL,
    PRIMARY KEY(item_id, transaction_no)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Table for Vendor
-- Details: ManyToMany
-- Many vendor vend many items
DROP TABLE IF EXISTS vendor;
CREATE TABLE vendor (
	ein int(11) NOT NULL PRIMARY KEY,
    company_name varchar(45) NOT NULL,
	company_addr varchar(55) NOT NULL,
    company_city varchar(10) NOT NULL,
    company_state varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Table for ManyToMany
-- Details: ManyToMany
DROP TABLE IF EXISTS vend;
CREATE TABLE vend (
	ein int(11) NOT NULL,
    item_id int(11) NOT NULL,
    date int(10) NOT NULL,
    quantity int(5) NULL,
	vendor_price int(5) NOT NULL,
    PRIMARY KEY(ein, item_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

