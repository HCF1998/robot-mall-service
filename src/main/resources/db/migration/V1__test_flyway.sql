CREATE TABLE `user`
(
    `id`       int          NOT NULL AUTO_INCREMENT,
    `username` varchar(10)  NOT NULL,
    `password` varchar(200) NOT NULL,
    `role`     varchar(2)   NOT NULL,
    PRIMARY KEY (`id`)
)