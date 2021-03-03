SET MODE MySQL;
SET IGNORECASE=TRUE;

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


--Skills Hierarchy
--Database
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

insert into Users (id, username, password) values (2, 'gflicker1', 'bpSPOJN');
insert into Users (id, username, password) values (1, 'rstickley0', 'RPdkup');
insert into Users (id, username, password) values (3, 'dfaiers2', '6NDv5Rd');
insert into Users (id, username, password) values (5, 'kbreedy4', 'BMmPsLs');
insert into Users (id, username, password) values (4, 'qumpleby3', 'P0hEGgy');
insert into Users (id, username, password) values (6, 'eradborn5', 'vZfpSUT');
insert into Users (id, username, password) values (7, 'jgeockle6', '7tjwiw');
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








