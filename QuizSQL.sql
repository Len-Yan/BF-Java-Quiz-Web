use aw;

DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS academics;

CREATE TABLE IF NOT EXISTS Quser (
	id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(20) NOT NULL,
    password VarChar(20) NOT NULL,
    firstname VARCHAR(50) Not Null,
    lastname VARCHAR(50),
    isAdmin bool,
    PRIMARY KEY(id)
);


CREATE TABLE IF NOT EXISTS category(
	id INT NOT NULL AUTO_INCREMENT,
    quizType VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS Question(
	id INT NOT NULL AUTO_INCREMENT,
    content text NOT NULL,
    category_id int NOT NULL,
    PRIMARY KEY(id)
    );
    
CREATE TABLE IF NOT EXISTS Qoption(
	id INT NOT NULL AUTO_INCREMENT,
    content text NOT NULL,
    question_id INT NOT NULL,
    isCorrect bool,
    suspend bool,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS Quiz_question(
	id INT NOT NULL AUTO_INCREMENT,
    quiz_id int,
    question_id int,
    selectedOption int,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS Quiz(
	id INT NOT NULL AUTO_INCREMENT,
    name text,
    category_id int,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS QuizSubmission(
	id INT NOT NULL AUTO_INCREMENT,
    startTime datetime,
    endTime datetime,
    score int,
    userid int,
    quiz_id int,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS feedback(
	id int NOT NULL AUTO_INCREMENT,
    feed text,
    rating int Not null,
    PRIMARY KEY(id)
);

-- ---------------------------------------------------------------

insert into category(quizType) values
("Math"), ("Java"), ("Tech & Sci");

insert into Question(content, category_id) values
("1+1 =? ", 1), ("1-1 =?", 1), ("2*2 = ?", 1),("2/2=?)",1), ("5^2 = ?",1), 
("What is 7% equal to?",1),("What is the remainder of 21 divided by 7?",1),("How many years are there in a decade?",1),
("In a century how many months are there?",1),("What is the square of 15?",1),("What is the value of x if x^2 = 169",1),
("What is 1004 divided by 2?",1),("The number of 3-digit numbers divisible by 6, is",1),
("The simplest form of 1.5 : 2.5 is",1),("How many digits are there in Hindu-Arabic System?",1),
("Among the following which natural number has no predecessor?",1),("Counting numbers are kept under ________ number.",1),
("An integer that is divisible by 2 is called:",1),("In which number system, there is no symbol for zero?",1),
("A system of notation that uses the base 2 instead of base 10 is called:",1);

insert into qoption(content, question_id, isCorrect) values
("0",1,false),("1",1,false),("2",1,true),("3",1,false), ("0",2,true),("1",2,false),("2",2,false),("3",2,false),
("1",3,false),("2",3,false),("3",3,false),("4",3,true), ("0",4,false),("1",4,true),("2",4,false),("3",4,false), 
("0",5,false),("5",5,false),("10",5,false),("25",5,true),

("0.007",6,false),("0.07",6,true),("0.7",6,false),("7",6,false),
("21",7,false),("7",7,false),("1",7,false),("0",7,true),
("5",8,false),("10",8,true),("15",8,false),("20",8,false),
("12",9,false),("120",9,false),("1200",9,true),("12000",9,false),
("15",10,false),("30",10,false),("252",10,false),("225",10,true),
("1",11,false),("13",11,true),("169",11,false),("338",11,false),

("52",12,false),("502",12,true),("520",12,false),("5002",12,false),
("149",13,false),("166",13,false),("150",13,true),("151",13,false),
("6 : 10",14,false),("15 : 25",14,false),("0.75 : 1.25",14,false),("3 : 5",14,true),
("10",15,true),("20",15,false),("30",15,false),("40",15,false),
("100",16,false),("200",16,false),("1",16,true),("0",16,false),
("Natural",17,true),("Whole",17,false),("Rational",17,false),("Odd",17,false),
("Even number",18,true),("Natural number",18,false),("Odd number",18,false),("Whole number",18,false),
("Hindu Arabic system",19,false),("Roman",19,true),("Egyptian",19,false),("Mesopotamia",19,false),
("Binary",20,true),("Ternary",20,false),("Hex",20,false),("Hexagonal",20,false);







