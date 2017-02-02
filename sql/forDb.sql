DROP DATABASE IF EXISTS test;


CREATE DATABASE test;


USE test;


CREATE TABLE `user` 
(
	
`id` INT(8) NOT NULL AUTO_INCREMENT,

'name` VARCHAR(25) NOT NULL DEFAULT '0',

`age` INT NOT NULL DEFAULT '0',

`isAdmin` BIT(1) NOT NULL DEFAULT b'0',

`createdDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci';



INSERT INTO `user`
 (`id`,`name`,`age`,`isAdmin`,`createdDate`) VALUES 
(1,"Roma",31,1,"2015-10-11 16:50:27"),
(2,"Kate",44,1,"2016-07-10 01:52:28"),
(3,"Jane",32,0,"2017-01-01 18:04:23"),
(4,"Sveta",36,0,"2015-12-01 19:14:05"),
(5,"Volode",44,1,"2017-02-13 15:07:40"),
(6,"Vlad",48,0,"2016-09-05 23:56:05"),
(7,"SashaGrey",31,1,"2016-07-11 05:26:53"),
(8,"Parturnax",21,0,"2016-09-06 11:11:50"),
(9,"Gendalf",40,0,"2015-11-04 09:42:46"),
(10,"Fili",55,0,"2016-03-26 17:11:09"),
(11,"Kili",34,0,"2015-06-06 13:26:41"),
(12,"Oin",25,1,"2017-04-29 11:16:09"),
(13,"Gloin",34,0,"2015-06-15 00:17:54"),
(14,"Bandit",53,1,"2016-04-29 08:49:40"),
(15,"Balin",28,1,"2016-01-26 08:46:29");