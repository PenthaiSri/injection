-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 05 juil. 2022 à 19:51
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `jdbc`
--

-- --------------------------------------------------------

--
-- Structure de la table `t_test`
--

CREATE TABLE `t_test` (
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `t_users`
--

CREATE TABLE `t_users` (
  `usr_id` int(10) NOT NULL COMMENT 'ID de l''utilisateur',
  `usr_password` varchar(128) DEFAULT NULL COMMENT 'mot de passe de l''utilisateur',
  `usr_firstname` varchar(20) DEFAULT NULL COMMENT 'prenom de l''utilisateur',
  `usr_lastname` varchar(20) DEFAULT NULL COMMENT 'nom de l''utilisateur'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `t_users`
--

INSERT INTO `t_users` (`usr_id`, `usr_password`, `usr_firstname`, `usr_lastname`) VALUES
(1, '5f4dcc3b5aa765d61d8327deb882cf99', 'test', 'test'),
(3, '*2470C0C06DEE42FD1618BB99005ADCA2EC9D1E19', NULL, NULL),
(4, '*2470C0C06DEE42FD1618BB99005ADCA2EC9D1E19', 'super', 'toto'),
(5, '*2470C0C06DEE42FD1618BB99005ADCA2EC9D1E19', 'toto', 'test'),
(6, '*2470C0C06DEE42FD1618BB99005ADCA2EC9D1E19', 'Harry', 'test'),
(7, '*2470C0C06DEE42FD1618BB99005ADCA2EC9D1E19', 'Best', 'test'),
(8, '*2470C0C06DEE42FD1618BB99005ADCA2EC9D1E19', 'Hello', 'test'),
(9, '*2470C0C06DEE42FD1618BB99005ADCA2EC9D1E19', 'Hello', 'Bonjour'),
(10, '*23F17D69555C1C44FDFF9E3D1D0E5941D5556FA3', 'Hello', 'Bonjour');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `t_users`
--
ALTER TABLE `t_users`
  ADD PRIMARY KEY (`usr_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `t_users`
--
ALTER TABLE `t_users`
  MODIFY `usr_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'ID de l''utilisateur', AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
