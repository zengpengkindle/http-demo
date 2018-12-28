--
-- Set character set the client will use to send SQL statements to the server
--
SET NAMES 'utf8';

--
-- Set default database
--
USE heima29;

--
-- Create table `tb_user`
--
CREATE TABLE tb_user (
  id int(11) NOT NULL AUTO_INCREMENT,
  userName char(20) DEFAULT NULL,
  password char(20) DEFAULT NULL,
  name varchar(50) DEFAULT NULL,
  sex tinyint(4) DEFAULT NULL,
  age int(11) DEFAULT NULL,
  birthday date DEFAULT NULL,
  created datetime DEFAULT NULL,
  updated date DEFAULT NULL,
  note char(20) DEFAULT NULL,
  PRIMARY KEY (id)
)
ENGINE = INNODB,
AUTO_INCREMENT = 2,
AVG_ROW_LENGTH = 16384,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_general_ci;