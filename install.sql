CREATE DATABASE IF NOT EXISTS SkillsDB;

USE SkillsDB;
/*
 A <<User>> which e.g JohnDoe
 */
 
 CREATE TABLE IF NOT EXISTS Players (
    id INT PRIMARY KEY AUTO_INCREMENT ,
    name VARCHAR(50) NOT NULL
);

 CREATE TABLE IF NOT EXISTS Matches (
    id INT PRIMARY KEY AUTO_INCREMENT ,
    match_mode VARCHAR(50) NOT NULL,
	match_date DATETIME DEFAULT NOW()
);

 CREATE TABLE IF NOT EXISTS Played (
    id INT PRIMARY KEY AUTO_INCREMENT ,
	player_id INT NOT NULL,
    match_id INT NOT NULL,
    kills INT NOT NULL,
	deaths INT NOT NULL,
	assists INT NOT NULL,
	is_won BOOLEAN,
    player_role VARCHAR(30) NOT NULL,
    player_team VARCHAR(30) NOT NULL,
    FOREIGN KEY (player_id) REFERENCES Players(id),
    FOREIGN KEY (match_id) REFERENCES Matches(id)
);
 
 
CREATE TABLE IF NOT EXISTS Users (
    id INT PRIMARY KEY AUTO_INCREMENT ,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(100) NOT NULL
);

/*
 A <<Team>> which could be Software Engineers
 */
CREATE TABLE IF NOT EXISTS Teams (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    description TEXT
);

/*
 A <<AssoicatedTeam(s)>> is a linking table that links <<User(s)>> to a <<Team(s)>>
*/
CREATE TABLE IF NOT EXISTS AssociatedTeams (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    team_id INT NOT NULL,
    left_team DATETIME,
    joined_team DATETIME DEFAULT NOW(),
    FOREIGN KEY (user_id) REFERENCES Users(id),
    FOREIGN KEY (team_id) REFERENCES Teams(id)
);

/*
 A <<Skill>> for example Python.
 */
CREATE TABLE IF NOT EXISTS Skills (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    description TEXT(500) NOT NULL
);

/*
A <<AssociatedSkill(s)>> is a linking table that links <<User(s)>> to a <<Skill(s)>>
 */
CREATE TABLE IF NOT EXISTS Associated_Skills (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    skill_id INT NOT NULL,
    rating INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES Users(id),
    FOREIGN KEY (skill_id) REFERENCES Skills(id)
);

/*
 A <<Type>> which an <<Advert>> can be (Mentor, Advice, Assist Accelerate)
 */
CREATE TABLE IF NOT EXISTS Types (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

/*
 A <<User>> can create a <<Comment>> for a <<Skill>>
 */
CREATE TABLE IF NOT EXISTS Courses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL ,
    description TEXT NOT NULL ,
    is_free BOOLEAN,
    price DECIMAL,
    posted DATETIME NOT NULL,
    location VARCHAR(50),
    user_creator INT NOT NULL,
    skill_id INT NOT NULL,
    FOREIGN KEY (user_creator) REFERENCES Users(id),
    FOREIGN KEY (skill_id) REFERENCES  Skills(id)
);

/*
 A <<User>> can create an <<Advert>>... with <<Type>>... for a <<Skill>>
*/
CREATE TABLE IF NOT EXISTS Adverts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL ,
    description TEXT NOT NULL ,
    posted DATETIME,
    user_creator INT NOT NULL,
    skill_id INT NOT NULL,
    type_id INT NOT NULL,
    FOREIGN KEY (user_creator) REFERENCES Users(id),
    FOREIGN KEY (skill_id) REFERENCES Skills(id),
    FOREIGN KEY (type_id) REFERENCES Types(id)
);

/*
 A <<User>> can leave a review on a <<Comment>>.
*/
CREATE TABLE IF NOT EXISTS Reviews (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL ,
    descripion TEXT NOT NULL ,
    course_id INT NOT NULL,
    user_creator INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES Courses(id),
    FOREIGN KEY (user_creator) REFERENCES Users(id)
);

/*
 A <<User>> can leave a comment on a <<Advert>>.
*/
CREATE TABLE IF NOT EXISTS Comments (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL ,
    descripion TEXT NOT NULL ,
    advert_id INT NOT NULL,
    user_creator INT NOT NULL,
    FOREIGN KEY (advert_id) REFERENCES Adverts(id),
    FOREIGN KEY (user_creator) REFERENCES Users(id)
);

--  <<User>> can enroll a <<Course>>.

CREATE TABLE IF NOT EXISTS Enrolled_On_Course (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_creator INT NOT NULL,
	course_id INT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES Courses(id),
    FOREIGN KEY (user_creator) REFERENCES Users(id)
);


--  <<Skills>> can link to other <<Skills>>.
CREATE TABLE IF NOT EXISTS Taxonomy (
    id INT PRIMARY KEY AUTO_INCREMENT,
    parent_id INT NOT NULL,
    child_id INT NOT NULL,
    FOREIGN KEY (parent_id) REFERENCES Skills(id),
    FOREIGN KEY (child_id) REFERENCES Skills(id)
);


INSERT INTO Types(id, name) VALUES (1, 'ACCELERATION');
INSERT INTO Types(id, name) VALUES (4, 'ASSISTANCE');
INSERT INTO Types(id, name) VALUES (2, 'TUTORING');
INSERT INTO Types(id, name) VALUES (3, 'ADVICE');


-- Database related skills
INSERT INTO Skills(id, name, description) VALUES (1, 'Database', 'An organised collection of data, generally stored and accessed electronically from a computer system' );
INSERT INTO Skills(id, name, description) VALUES (2, 'SQL', 'Structured Query Language (SQL) is a standard computer language for relational database management.' );
INSERT INTO Skills(id, name, description) VALUES (3, 'NoSQL', 'NoSQL is a class of database management systems (DBMS) that do not follow all of the rules of a relational DBMS and cannot use traditional SQL to query data.' );

-- Java
INSERT INTO Skills(id, name, description) VALUES (4, 'Java', 'A high level object orientated programming language used for many things such as web application.');
INSERT INTO Skills(id, name, description) VALUES (5, 'Spring boot', 'Spring Boot is an open source Java-based framework used to create a micro Service. It is developed by Pivotal Team and is used to build stand-alone and production ready spring applications.' );
INSERT INTO Skills(id, name, description) VALUES (6, 'Grails', 'Grails is an open source web application framework which uses the Groovy programming language. It is intended to be a high-productivity framework by following the "coding by convention" paradigm, providing a stand-alone development environment and hiding much of the configuration detail from the developer.' );
INSERT INTO Skills(id, name, description) VALUES (7, 'Android', 'Android is a mobile operating system developed by Google. It is used by several smartphones and tablets. You can develop mobile applications using android' );
INSERT INTO Skills(id, name, description) VALUES (8, 'Blade', ' Blade is a lightweight Java MVC framework based on the principles of simplicity' );
INSERT INTO Skills(id, name, description) VALUES (9, 'Hibernate', 'Hibernate (framework) Hibernate ORM (or simply Hibernate) is an object-relational mapping tool for the Java programming language. It provides a framework for mapping an object-oriented domain model to a relational database.' );

-- Python
INSERT INTO Skills(id, name, description) VALUES (10, 'Python', 'an interpreted, object-oriented, high-level programming language with dynamic semantics.');
INSERT INTO Skills(id, name, description) VALUES (11, 'Flask', 'Flask (web framework) Flask is a micro web framework written in Python. It is classified as a microframework because it does not require particular tools or libraries. It has no database abstraction layer, form validation, or any other components where pre-existing third-party libraries provide common functions.');
INSERT INTO Skills(id, name, description) VALUES (12, 'Django', 'Django is a high-level Python Web framework that encourages rapid development and clean, pragmatic design.');


-- Skills Hierarchy
-- Database
INSERT INTO Taxonomy(id, parent_id, child_id) VALUES (1, 1, 2);
INSERT INTO Taxonomy(id, parent_id, child_id) VALUES (2, 1, 3);
INSERT INTO Taxonomy(id, parent_id, child_id) VALUES (3, 1, 9);
INSERT INTO Taxonomy(id, parent_id, child_id) VALUES (4, 2, 9);

INSERT INTO Taxonomy(id, parent_id, child_id) VALUES (5, 4, 5);
INSERT INTO Taxonomy(id, parent_id, child_id) VALUES (6, 4, 6);
INSERT INTO Taxonomy(id, parent_id, child_id) VALUES (7, 4, 7);
INSERT INTO Taxonomy(id, parent_id, child_id) VALUES (8, 4, 8);
INSERT INTO Taxonomy(id, parent_id, child_id) VALUES (9, 4, 9);

INSERT INTO Taxonomy(id, parent_id, child_id) VALUES (10, 10, 11);
INSERT INTO Taxonomy(id, parent_id, child_id) VALUES (11, 10, 12);

INSERT INTO Users (id, username, password) values (2, 'gflicker1', 'bpSPOJN');
INSERT INTO Users (id, username, password) values (1, 'rstickley0', 'RPdkup');
INSERT INTO Users (id, username, password) values (3, 'dfaiers2', '6NDv5Rd');
INSERT INTO Users (id, username, password) values (5, 'kbreedy4', 'BMmPsLs');
INSERT INTO Users (id, username, password) values (4, 'qumpleby3', 'P0hEGgy');
INSERT INTO Users (id, username, password) values (6, 'eradborn5', 'vZfpSUT');
INSERT INTO Users (id, username, password) values (7, 'jgeockle6', '7tjwiw');
insert into Users (id, username, password) values (8, 'awoodruffe7', 'HxWUo8AMU');
insert into Users (id, username, password) values (9, 'lmccosker8', 'wOP0ZPQK');
insert into Users (id, username, password) values (10, 'mraselles9', 'Rl9jFm9T');
insert into Users (id, username, password) values (11, 'yscotsona', 'LQloj9cAM');
insert into Users (id, username, password) values (12, 'rmeadenb', 'EzuR5atXg');
insert into Users (id, username, password) values (14, 'atantrumd', 'ArWlFuZt4');
insert into Users (id, username, password) values (13, 'spaddefieldc', 'N25ESc');
insert into Users (id, username, password) values (15, 'gteffreye', 'Jf3luMbu5I5T');
insert into Users (id, username, password) values (17, 'abrilg', '8BxbnL');
insert into Users (id, username, password) values (16, 'karchambaultf', 'xkBiaUopCo');
insert into Users (id, username, password) values (18, 'rmidnerh', 'ppD5GUhMXDQ4');
insert into Users (id, username, password) values (20, 'rgilderoyj', 'K6P0bGf');
insert into Users (id, username, password) values (19, 'djowlingi', 'dCLXK0iGiz2V');
insert into Users (id, username, password) values (22, 'medinburghl', '47qqBATjnTNH');
insert into Users (id, username, password) values (21, 'rdimitrievk', '3oHSn8qA');
insert into Users (id, username, password) values (24, 'emaccostyn', 'YvfK5pMVPO');
insert into Users (id, username, password) values (23, 'aboatm', 'V5QPjBpIz');
insert into Users (id, username, password) values (38, 'rhollingsbee11', '82uYgZ');
insert into Users (id, username, password) values (37, 'brendbaek10', 'Ui14WNbrMnF');
insert into Users (id, username, password) values (36, 'akastingz', 'oSV31wRuNt');
insert into Users (id, username, password) values (35, 'mryally', 'KF657DBHpZD');
insert into Users (id, username, password) values (34, 'rbudikx', 'Rpnyr7RKAM');
insert into Users (id, username, password) values (33, 'llacroixw', 'mG6ICUf');
insert into Users (id, username, password) values (32, 'cbocv', 'rOKZI7P');
insert into Users (id, username, password) values (31, 'bmcmeekinu', 'UMvxGhMpH');
insert into Users (id, username, password) values (30, 'ptomant', 'fqc6ha6JITXX');
insert into Users (id, username, password) values (29, 'apovalls', 'HzjmYwHTie');
insert into Users (id, username, password) values (28, 'jfrangor', 'AIlDME1J5');
insert into Users (id, username, password) values (27, 'msleetq', 's1edGdp');
insert into Users (id, username, password) values (26, 'gkeatp', 'PWEUYqAJF');
insert into Users (id, username, password) values (25, 'cnazairo', '9B4bUm');
insert into Users (id, username, password) values (39, 'Robert', 'password');
insert into Users (id, username, password) values (40, 'Rob', 'password');

insert into Associated_Skills (id, user_id, skill_id, rating) values (1, 2, 2, 1);
insert into Associated_Skills (id, user_id, skill_id, rating) values (2, 2, 1, 3);
insert into Associated_Skills (id, user_id, skill_id, rating) values (3, 1, 3, 1);
insert into Associated_Skills (id, user_id, skill_id, rating) values (4, 8, 1, 4);
insert into Associated_Skills (id, user_id, skill_id, rating) values (5, 5, 2, 3);
insert into Associated_Skills (id, user_id, skill_id, rating) values (6, 3, 2, 1);
insert into Associated_Skills (id, user_id, skill_id, rating) values (7, 3, 1, 4);
insert into Associated_Skills (id, user_id, skill_id, rating) values (8, 8, 3, 4);
insert into Associated_Skills (id, user_id, skill_id, rating) values (9, 1, 2, 5);
insert into Associated_Skills (id, user_id, skill_id, rating) values (10, 3, 2, 3);
insert into Associated_Skills (id, user_id, skill_id, rating) values (11, 8, 4, 4);
insert into Associated_Skills (id, user_id, skill_id, rating) values (12, 1, 4, 5);
insert into Associated_Skills (id, user_id, skill_id, rating) values (13, 3, 4, 5);

insert into Courses (id, name, description, is_free, price, posted, user_creator, skill_id) values (1, 'Java', 'Basics of object oriented programming', false, 3.00, '2008-11-11 13:23:44', 1, 4);
insert into Courses (id, name, description, is_free, price, posted, user_creator, skill_id) values (2, 'Python', 'a very coooooool course', true, 0, '2010-11-11 13:23:44', 1, 3);
insert into Courses (id, name, description, is_free, price, posted, user_creator, skill_id) values (3, 'The Course', 'for fun and a good time', true, 0, '2019-11-11 13:23:44', 1, 1);
insert into Courses (id, name, description, is_free, price, posted, user_creator, skill_id) values (4, 'Free flask', 'a very practical course', true, 0, '2019-11-11 13:23:44', 1, 1);
insert into Courses (id, name, description, is_free, price, posted, user_creator, skill_id) values (5, 'Skill share', 'practical and lots of fun', false, 5, '2020-11-11 13:23:44', 1, 4);
insert into Courses (id, name, description, is_free, price, posted, user_creator, skill_id) values (6, 'Object orientated Java', 'practical and endless of fun', true, 0, '2020-11-11 13:00:00', 1, 4);