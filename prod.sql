create database produitdb
 
use produitdb
 
CREATE TABLE `produits` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `nom` varchar(45) NOT NULL,
    `quatite` int(45) NOT NULL,
    `prix` float(45) NOT NULL,
    PRIMARY KEY (`id`)
);