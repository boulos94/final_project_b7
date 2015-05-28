CREATE TABLE `course`.`tbl_course` 
(
  `crs_id` INT NOT NULL AUTO_INCREMENT,
  
`crs_code` VARCHAR(6) NOT NULL,
  
`crs_name` VARCHAR(30) NOT NULL,
  
`crs_descriptiom` VARCHAR(250) NULL,
  
`crs_type` VARCHAR(8) NOT NULL,
  
`crs_numberOfCredits` INT NOT NULL,
  
`crs_lab` VARCHAR(3) NOT NULL,
  
PRIMARY KEY (`crs_id`));
