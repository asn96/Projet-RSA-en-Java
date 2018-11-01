-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 10 Septembre 2018 à 14:53
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `projet_rsa`
--

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE IF NOT EXISTS `message` (
  `IdM` int(11) NOT NULL AUTO_INCREMENT,
  `ContenuM` text NOT NULL,
  `Signature` text NOT NULL,
  `Cle` text NOT NULL,
  `Id` char(7) NOT NULL,
  `Id_Utilisateur` char(7) NOT NULL,
  PRIMARY KEY (`IdM`),
  KEY `Message_Utilisateur_FK` (`Id`),
  KEY `Message_Utilisateur0_FK` (`Id_Utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `Id` char(7) NOT NULL,
  `Nom` varchar(10) NOT NULL,
  `Prenom` varchar(10) NOT NULL,
  `Pass_word` varchar(10) NOT NULL,
  `n` varchar(20) NOT NULL,
  `e` varchar(20) NOT NULL,
  `d` varchar(20) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`Id`, `Nom`, `Prenom`, `Pass_word`, `n`, `e`, `d`) VALUES
('SERT', 'Ndiaye', 'Soda', '', '', '', '');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `Message_Utilisateur_FK` FOREIGN KEY (`Id`) REFERENCES `utilisateur` (`Id`),
  ADD CONSTRAINT `Message_Utilisateur0_FK` FOREIGN KEY (`Id_Utilisateur`) REFERENCES `utilisateur` (`Id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
