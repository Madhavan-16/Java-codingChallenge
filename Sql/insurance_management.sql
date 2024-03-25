create database insurance_management;
use insurance_management;
-- Create table for User
CREATE TABLE User (
    userId INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

-- Create table for Client
CREATE TABLE Client (
    clientId INT PRIMARY KEY AUTO_INCREMENT,
    clientName VARCHAR(255) NOT NULL,
    contactInfo VARCHAR(255) NOT NULL
);

-- Create table for Policy
CREATE TABLE Policy (
    policyId INT PRIMARY KEY AUTO_INCREMENT,
    policyName VARCHAR(255) NOT NULL,
    contactInfo VARCHAR(255) NOT NULL
);

-- Create table for Claim
CREATE TABLE Claim (
    claimId INT PRIMARY KEY AUTO_INCREMENT,
    claimNumber VARCHAR(255) NOT NULL,
    dateFiled DATE NOT NULL,
    claimAmount DECIMAL(10, 2) NOT NULL,
    status VARCHAR(50) NOT NULL,
    policyId INT,
    clientId INT,
    FOREIGN KEY (policyId) REFERENCES Policy(policyId),
    FOREIGN KEY (clientId) REFERENCES Client(clientId)
);

-- Create table for ClaimPayment
CREATE TABLE ClaimPayment (
    paymentId INT PRIMARY KEY AUTO_INCREMENT,
    paymentDate DATE NOT NULL,
    paymentAmount DECIMAL(10, 2) NOT NULL,
    clientId INT,
    FOREIGN KEY (clientId) REFERENCES Client(clientId)
);

select * from policy;