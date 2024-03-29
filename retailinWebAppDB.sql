DROP DATABASE IF EXISTS retailinWebAppDB;
CREATE DATABASE IF NOT EXISTS retailinWebAppDB;
USE retailinWebAppDB;

-- Table for departments
-- Details: OneToMany Departments -> Users 
-- One user work_in exaclty one department
DROP TABLE IF EXISTS departments;
CREATE TABLE departments(
	department_id int(4) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    department_name varchar(32) NOT NULL,
    additional varchar(64) DEFAULT 'None',
    KEY(department_id)
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- Table for Employees=Users
-- Main table to hold employee's infomation
-- MUST be called 'users' due to Spring security specification
-- In the App: username is referred as empID
DROP TABLE IF EXISTS users;
CREATE TABLE users (
	username int(8) ZEROFILL NOT NULL AUTO_INCREMENT PRIMARY KEY,
	last_name varchar(32) NOT NULL,
	first_name varchar(32) NOT NULL,
	password varchar(128) NOT NULL,
	email varchar(64) NOT NULL,
	phone_number varchar(12) NOT NULL,
	enabled int(1) DEFAULT '1',
	authority varchar(45) NOT NULL,
	department_id int(4) NOT NULL,
    CONSTRAINT FOREIGN KEY(department_id) REFERENCES departments(department_id) ON DELETE CASCADE ON UPDATE CASCADE
) AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- INSERT DEFAULT DATA
LOCK TABLES departments WRITE;
	INSERT INTO departments(department_name) values("Admin");
UNLOCK TABLES;

LOCK TABLES users WRITE;
	INSERT INTO users(last_name, first_name, password, email, phone_number, authority, department_id) 
	VALUES("admin","admin","admin","admin@retailin.com","0000000000","ROLE_ADMIN", "1");
UNLOCK TABLES;

-- Table for Authorities/Roles for each account
-- MUST be called 'authorities' due to Spring Security specification
DROP TABLE IF EXISTS authorities;
CREATE TABLE authorities (
	role_id int(4) AUTO_INCREMENT PRIMARY KEY,
	username int(8) ZEROFILL NOT NULL,
	authority varchar(45) NOT NULL,
	CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username)
) DEFAULT CHARSET=utf8;

LOCK TABLES authorities WRITE;
	INSERT INTO authorities(username, authority)
	VALUES("00000001","ROLE_ADMIN");
UNLOCK TABLES;
-- 
-- Table for Payrolls
-- Details: ManyToOne Payrolls -> Users
-- One user have many payrolls
DROP TABLE IF EXISTS payrolls;
CREATE TABLE payrolls(
	payroll_id int(5) AUTO_INCREMENT PRIMARY KEY,
    pay_period varchar(10) NOT NULL,
    hourly_rate int(5) NOT NULL,
    worked_hours int(5) NOT NULL,
    emp_id int(8) ZEROFILL NOT NULL,
    CONSTRAINT fk_payrolls_users FOREIGN KEY(emp_id) REFERENCES users(username)
) DEFAULT CHARSET=utf8;


-- Table for Bank Account 
-- Details: ManyToOne Bank_account -> Users
-- One user have many bank accounts
DROP TABLE IF EXISTS bank_accounts;
CREATE TABLE bank_accounts (
	acct_id int(8) AUTO_INCREMENT PRIMARY KEY,
	acct_no int(20) NOT NULL,
    routing_no int(20) NOT NULL,
    acct_type varchar(16) NOT NULL,
    bank_name varchar(55) NOT NULL,
    bank_addr varchar(55) NOT NULL,
    bank_city varchar(55) NOT NULL,
    bank_state varchar(55) NOT NULL,
    zip_code int(6) NOT NULL,
    emp_id int(8) ZEROFILL NOT NULL,
    CONSTRAINT fk_bankAccounts_users FOREIGN KEY(emp_id) REFERENCES users(username)
) DEFAULT CHARSET=utf8;

-- Table for Customers 
-- Details: ManyToOne Receipts -> Customers
-- Many receipts are issued by one user
DROP TABLE IF EXISTS customers;
CREATE TABLE customers (
	customer_id int(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	phone_number int(12) NOT NULL,
    first_name varchar(32) NOT NULL,
	last_name varchar(32) NOT NULL,
	email varchar(54) NOT NULL,
    zip_code int(6) NOT NULL
) DEFAULT CHARSET=utf8;

-- Table for Receipts 
-- Details: ManyToOne Receipts -> Users
-- Many receipts are issued by one user
DROP TABLE IF EXISTS receipts;
CREATE TABLE receipts (
	transaction_no int(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    total int(20) NOT NULL,
    receipt_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    emp_id int(8) ZEROFILL NOT NULL,
    customer_id int(5) NOT NULL,
    CONSTRAINT fk_receipts_users FOREIGN KEY(emp_id) REFERENCES users(username),
    CONSTRAINT fk_receipts_customers FOREIGN KEY(customer_id) REFERENCES customers(customer_id)
) DEFAULT CHARSET=utf8;

-- Table for Categories
-- Details: ManyToOne Items -> Categorites
-- Many items belong to exactly one category
DROP TABLE IF EXISTS categories;
CREATE TABLE categories (
	category_id int(5) AUTO_INCREMENT PRIMARY KEY,
	category_name varchar(32) NOT NULL,
    category_description varchar(64) NOT NULL
) DEFAULT CHARSET=utf8;
-- 
-- Table for Items
-- Details: ManyToMany
-- Many receipts are in many items
DROP TABLE IF EXISTS items;
CREATE TABLE items (
	item_id int(5) AUTO_INCREMENT PRIMARY KEY,
    item_name varchar(32) NOT NULL,
    description varchar(64) NOT NULL,
	price decimal(8,2) NOT NULL,
    discount int(3) NOT NULL,
    quantity int(5) NOT NULL,
    category_id int(5) NOT NULL,
	vendor_id int(8) NOT NULL,
    CONSTRAINT fk_items_categories FOREIGN KEY(category_id) REFERENCES categories(category_id),
    CONSTRAINT fk_items_vendors FOREIGN KEY(vendor_id) REFERENCES vendors(vendor_id)
) DEFAULT CHARSET=utf8;

-- Table for ManyToMany
-- Details: ManyToMany
-- Many receipts are in many items
DROP TABLE IF EXISTS is_in;
CREATE TABLE is_in (
	transaction_no int(5) NOT NULL,
	item_id int(5) NOT NULL,
	quantity int(5) NOT NULL,
	PRIMARY KEY(transaction_no, item_id),
	CONSTRAINT fk_isIn_receipts FOREIGN KEY(transaction_no) REFERENCES receipts(transaction_no),
	CONSTRAINT fk_isIn_items FOREIGN KEY(item_id) REFERENCES items(item_id)
) DEFAULT CHARSET=utf8;
-- 
-- Table for Vendor
-- Details: ManyToMany
-- Many vendor vend many items
DROP TABLE IF EXISTS vendors;
CREATE TABLE vendors (
	vendor_id int(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	ein varchar(16) NOT NULL,
    name varchar(32) NOT NULL,
	address varchar(32) NOT NULL,
    city varchar(12) NOT NULL,
    state varchar(12) NOT NULL,
    zip_code int(8) NOT NULL
) DEFAULT CHARSET=utf8;