SET MODE MySQL;
SET IGNORECASE=TRUE;


CREATE DATABASE IF NOT EXISTS SkillsDB;

USE SkillsDB;
/*
 A <<User>> which e.g JohnDoe
 */
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
CREATE TABLE IF NOT EXISTS TAXONOMY (
    id INT PRIMARY KEY AUTO_INCREMENT,
    parent_id INT NOT NULL,
    child_id INT NOT NULL,
    FOREIGN KEY (parent_id) REFERENCES Skills(id),
    FOREIGN KEY (child_id) REFERENCES Skills(id)
);


