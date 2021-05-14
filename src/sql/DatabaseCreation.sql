CREATE TABLE USERS (UserID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
FIRSTNAME VARCHAR(50) NOT NULL, LASTNAME VARCHAR(50) NOT NULL, EMAIL VARCHAR(50) NOT NULL, PASSWORD VARCHAR(20) NOT NULL,
PHONENUMBER INTEGER NOT NULL, STREETNUMBER INTEGER NOT NULL, STREETNAME VARCHAR(50) NOT NULL, STREETTYPE VARCHAR(12) NOT NULL,
SUBURB VARCHAR(50) NOT NULL, "STATE" VARCHAR(3) NOT NULL, POSTCODE INTEGER NOT NULL, COUNTRY VARCHAR(50) NOT NULL, PRIMARY KEY (USERID));

CREATE TABLE STAFF (USERID INTEGER, SITEACCESSLEVEL INTEGER, DOB DATE,  FOREIGN KEY(USERID) REFERENCES USERS(USERID));

CREATE TABLE CUSTOMER (USERID INTEGER, LOYALTYPOINTS INTEGER, FOREIGN KEY(USERID) REFERENCES USERS(USERID));

CREATE TABLE ACCLOGS(USERID INT, ACTION VARCHAR(15), Current_Time_Stamp TimeStamp);

CREATE TABLE COURIER (COURIERID INTEGER NOT NULL, COURIERADDRESS VARCHAR(50), PRIMARY KEY (COURIERID));

CREATE TABLE ORDERS (ORDERID INTEGER NOT NULL, USERID INTEGER REFERENCES USERS(USERID), COURIERID INTEGER REFERENCES COURIER(COURIERID),
ORDERDATE DATE, ORDERSTATUS VARCHAR(12), PRIMARY KEY (ORDERID));

CREATE TABLE PROCESSORDER (USERID INTEGER REFERENCES USERS(USERID), ORDERID INTEGER REFERENCES ORDERS(ORDERID));

CREATE TABLE ITEM (ITEMID INTEGER NOT NULL, ITEMSERIALNUMBER INTEGER, ITEMCATEGORY VARCHAR(50), ITEMBRAND VARCHAR(50), ITEMNAME VARCHAR(50),
ITEMIMAGE VARCHAR(250), PRIMARY KEY (ITEMID));

CREATE TABLE ORDERLINE (ITEMID INTEGER REFERENCES ITEM(ITEMID), ORDERID INTEGER REFERENCES ORDERS(ORDERID));

CREATE TABLE SUPPLIER (SUPPLIERID INTEGER NOT NULL, SUPPLIERADDRESS VARCHAR(50), SUPPLIERCONTACT INTEGER, PRIMARY KEY (SUPPLIERID));

CREATE TABLE CATALOGUE (SUPPLIERID INTEGER REFERENCES SUPPLIER(SUPPLIERID), ITEMID INTEGER REFERENCES ITEM(ITEMID), PARTNAME VARCHAR(30),
ITEMQUANTITY INTEGER, ITEMPRICE DECIMAL(15, 2));

CREATE TABLE PAYMENTINFO (PAYMENTINFOID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), USERID INTEGER REFERENCES USERS(USERID),
CARDHOLDERNAME VARCHAR(50), CARDNUMBER VARCHAR(20),
CARDEXPIRYDATE VARCHAR(10), CARDCVC INTEGER, STREETNUMBER INTEGER NOT NULL, STREETNAME VARCHAR(50) NOT NULL, STREETTYPE VARCHAR(12) NOT NULL,
SUBURB VARCHAR(50) NOT NULL, "STATE" VARCHAR(3) NOT NULL, POSTCODE INTEGER NOT NULL, COUNTRY VARCHAR(50), CREDIT DECIMAL(15, 2), ACTIVE VARCHAR(5),
PRIMARY KEY (PAYMENTINFOID));

CREATE TABLE PAYMENT (PAYMENTID INTEGER NOT NULL, PAYMENTINFOID INTEGER REFERENCES PAYMENTINFO(PAYMENTINFOID), PAYMENTDATE DATE,
PAYMENTAMOUNT DECIMAL(15, 2), PRIMARY KEY (PAYMENTID));

CREATE TABLE INVOICE (INVOICEID INTEGER NOT NULL, PAYMENTID INTEGER REFERENCES PAYMENT(PAYMENTID), ISSUEDATE DATE, PRIMARY KEY (INVOICEID));