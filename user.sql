
CREATE TABLE IF NOT EXISTS `user` (
`id` bigint(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `image_path` varchar(50) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

 INSERT INTO `user` (`id`, `email`, `image_path`, `name`, `password`) VALUES
(1, 'revo', NULL, 'revo', '$2a$10$dF.Bj2oluqLE9RN6dmyq1uDlCfx43vbdKkZVFJE4y13OL4o9KnX22'),
(2, 'ashraf.abdelrasool', NULL, 'Ashraf Revo', '$2a$10$dF.Bj2oluqLE9RN6dmyq1uDlCfx43vbdKkZVFJE4y13OL4o9KnX22'),
(3, 'ashraf.abdelrasool@yahoo.com', NULL, 'Ashraf Revo', '$2a$10$k/sQz/N9uNdpXZAqwoQCtelHmGsnYKyNnGlfTPBitOx9uar6o9lyG'),
(4, 'ashraf1abdelrasool@gmail.com', '1962754_293116334176343_5000047960662943614_n.jpg', 'Ashraf Revo', NULL);

 ALTER TABLE `user`
 ADD PRIMARY KEY (`id`);

ALTER TABLE `user`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
