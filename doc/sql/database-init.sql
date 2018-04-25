create database pethospital;
use pethospital;
CREATE TABLE `tb_user` (
  `user_id` int(11) auto_increment  NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `authority` varchar(255) DEFAULT NULL,
  `label_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `tb_paper` (
  `paper_id` int(10) auto_increment NOT NULL,
  `label_type` varchar(20) DEFAULT NULL,
  `question_id` int(10) NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `duration` date DEFAULT NULL,
  PRIMARY KEY (`paper_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `tb_questions` (
  `question_id` int(10) auto_increment NOT NULL,
  `type` varchar(20) DEFAULT NULL,
  `text` text,
  `answer` text,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `tb_vaccine` (
  `vaccine_id` int(10) auto_increment NOT NULL,
  `vaccine_name` varchar(20) DEFAULT NULL,
  `cost` decimal(38,5) NOT NULL,
  PRIMARY KEY (`vaccine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `tb_labwork` (
  `labwork_id` int(10) auto_increment NOT NULL,
  `labwork_name` varchar(20) DEFAULT NULL,
  `cost` decimal(38,5) NOT NULL,
  PRIMARY KEY (`labwork_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `tb_medicine` (
  `medicine_id` int(10) auto_increment NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `cost` decimal(38,5) NOT NULL,
  PRIMARY KEY (`medicine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `tb_picnvideo` (
  `picnvideo_id` int(10) auto_increment NOT NULL,
  `type` int(10) DEFAULT NULL,
  `path` text,
  PRIMARY KEY (`picnvideo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `tb_office` (
  `office_id` int(10) auto_increment NOT NULL,
  `person_name` varchar(20) DEFAULT NULL,
  `office_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`office_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `tb_case` (
  `case_id` int(10) auto_increment NOT NULL,
  `case_name` varchar(20) DEFAULT NULL,
  `case_type` varchar(20) DEFAULT NULL,
  `check_name` varchar(20) DEFAULT NULL,
  `check_pic` int(10),
  `diagnose_name` varchar(20) DEFAULT NULL,
  `diagnose_pic` int(10),
  `result` varchar(20) DEFAULT NULL,
  `treat_text` text,
  `treat_video` int(10) DEFAULT NULL,
  `medicine_id` int(10) DEFAULT NULL,
  `labwork_id` int(10) DEFAULT NULL,
  `vaccine_id` int(10) DEFAULT NULL,
  `stay_days` int(10) DEFAULT NULL,
  PRIMARY KEY (`case_id`),
  CONSTRAINT `labwork_id` FOREIGN KEY (`labwork_id`) REFERENCES `tb_labwork` (`labwork_id`),
  CONSTRAINT `medicine_id` FOREIGN KEY (`medicine_id`) REFERENCES `tb_medicine` (`medicine_id`),
  CONSTRAINT `vaccine_id` FOREIGN KEY (`vaccine_id`) REFERENCES `tb_vaccine` (`vaccine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;