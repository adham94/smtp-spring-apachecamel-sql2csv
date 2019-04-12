CREATE TABLE `email` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email_to` varchar(45) NOT NULL DEFAULT '',
  `email_cc` varchar(45) NOT NULL DEFAULT '0',
  `enabled` varchar(45) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

INSERT INTO `csi_db`.`email`(`id`,`email_to`,`email_cc`,`enabled`)VALUES('1','muhd.adham94@gmail.com','0','1');