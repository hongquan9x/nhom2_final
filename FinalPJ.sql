DROP DATABASE cinemamanagement;

CREATE DATABASE cinemamanagement character set UTF8 collate utf8_vietnamese_ci;

USE cinemamanagement;

CREATE TABLE staff
(
	staffID INT NOT NULL AUTO_INCREMENT,
    staffName VARCHAR(50) NOT NULL,
    yearofbirth DATE NOT NULL,
	address VARCHAR(50),
    role INT NOT NULL,
    staffEmail varchar(30) not null,
    staffPassword varchar(128) not null,
	PRIMARY KEY (staffID)   
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



create table typeofroom
(
	typeOfRoomID int not null auto_increment,
    nameOfTOR varchar(30) not null,
    primary key (typeOfRoomID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE room
(
	roomID INT NOT NULL AUTO_INCREMENT,
    roomName VARCHAR(20) NOT NULL,
    typeOfRoomID INT NOT NULL,
    PRIMARY KEY (roomID),
    foreign key (typeOfRoomID) references typeofroom (typeOfRoomID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE screening
(
	screeningID INT NOT NULL AUTO_INCREMENT,
    timeStart datetime,
    timeEnd datetime,
    PRIMARY KEY(screeningID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;




CREATE TABLE kindofmovie
(
	categoryID INT NOT NULL AUTO_INCREMENT,
    categoryName VARCHAR(50) NOT NULL,
    PRIMARY KEY (categoryID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE movie
(
	movieID INT NOT NULL AUTO_INCREMENT,
    categoryID INT NOT NULL,
    movieName VARCHAR(50) NOT NULL,
    movieDesciption VARCHAR(200),
    movieLength VARCHAR(50) NOT NULL,
    showTime DATETIME,
    PRIMARY KEY (movieID),
    FOREIGN KEY (categoryID) REFERENCES kindofmovie (categoryID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

create table moviedetail
(
	movieID int not null,
    movieImage varchar(50) not null,
    primary key (movieID, movieImage),
    foreign key (movieID) references movie (movieID)
);

CREATE TABLE seat
(
	seatID INT NOT NULL AUTO_INCREMENT,
    seatName VARCHAR(20) NOT NULL,
    roomID INT NOT NULL,
    PRIMARY KEY (seatID),
    FOREIGN KEY (roomID) REFERENCES room (roomID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


CREATE TABLE schedule
(
	scheduleID INT NOT NULL auto_increment,
    screeningID int not null,
	movieID INT NOT NULL,
    roomID int not null,
    showdate datetime NOT NULL,
    PRIMARY KEY(scheduleID),
    FOREIGN key (screeningID) references screening (screeningID),
    foreign key (roomID) references room (roomID),
    foreign key (movieID) references movie (movieID)    
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

create table scheduledetail
(
	seatID int not null,
    scheduleID int not null,    
    seatStatus tinyint not null,
    primary key (seatID, scheduleID),
    foreign key (seatID) references seat (seatID),
    foreign key (scheduleID) references schedule (scheduleID)
);

CREATE TABLE kindoffood
(
	categoryID INT NOT NULL AUTO_INCREMENT,
    categoryName VARCHAR(50) NOT NULL,
    PRIMARY KEY (categoryID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE food
(
	foodID INT NOT NULL AUTO_INCREMENT,
    foodName VARCHAR(30) NOT NULL,
    categoryID INT NOT NULL,
    unit VARCHAR(10) NOT NULL,
    price FLOAT NOT NULL,
    PRIMARY KEY (foodID),
    FOREIGN KEY (categoryID) REFERENCES kindoffood (categoryID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



CREATE TABLE customer
(
	customerID INT NOT NULL AUTO_INCREMENT,
    customerName VARCHAR(50) NOT NULL,
    customerPhoneNumber VARCHAR(12) NOT NULL,
    cumulativePoints FLOAT,
    customerEmail varchar(30) not null,
    customerPassword varchar(128) not null,
    authorProvider varchar (20) not null,
    PRIMARY KEY (customerID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE ticket
(
	ticketID INT NOT NULL AUTO_INCREMENT,
    staffID INT NOT NULL,
    customerID INT NOT NULL,
    roomID int not null,
    seatID INT NOT NULL,
    scheduleID int not null,
    discount FLOAT,
    price int not null,
    PRIMARY KEY (ticketID, staffID, customerID, roomID, seatID, scheduleID),
    FOREIGN KEY (staffID) REFERENCES staff (staffID),
    FOREIGN KEY (customerID) REFERENCES customer (customerID),
    FOREIGN KEY (roomID) REFERENCES room (roomID),
    FOREIGN KEY (seatID) REFERENCES seat (seatID),
    foreign key (scheduleID) references schedule(scheduleID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



create table invoice
(
	invoiceID int not null auto_increment,
    staffID INT NOT NULL,
    customerID INT NOT NULL,
    PRIMARY KEY (invoiceID),
    FOREIGN KEY (staffID) REFERENCES staff (staffID),
    FOREIGN KEY (customerID) REFERENCES customer (customerID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE foodinvoicedetail
(
	invoiceID INT NOT NULL,
    foodID INT NOT NULL,
    amountOfFood INT,
    PRIMARY KEY (invoiceID, foodID),
    FOREIGN KEY (invoiceID) REFERENCES invoice (invoiceID),
    FOREIGN KEY (foodID) REFERENCES food (foodID)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

select count (seatStatus) 
from scheduledetail
where seatStatus = 1;