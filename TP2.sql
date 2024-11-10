-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : dim. 10 nov. 2024 à 16:27
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `TP2`
--

-- --------------------------------------------------------

--
-- Structure de la table `Adresse`
--

CREATE TABLE `Adresse` (
  `adresse_id` int(11) NOT NULL,
  `country` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `street` varchar(100) NOT NULL,
  `gpsposition` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `Adresse`
--

INSERT INTO `Adresse` (`adresse_id`, `country`, `city`, `street`, `gpsposition`) VALUES
(1, 'USA', 'New York', '5th Avenue', '40.712776, -74.005974'),
(2, 'France', 'Paris', 'Rue de Rivoli', '48.856613, 2.352222'),
(3, 'Germany', 'Berlin', 'Alexanderplatz', '52.520008, 13.404954');

-- --------------------------------------------------------

--
-- Structure de la table `Agency`
--

CREATE TABLE `Agency` (
  `agency_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `Agency`
--

INSERT INTO `Agency` (`agency_id`, `username`, `password`, `name`) VALUES
(1, 'admin', 'admin', 'Tripadvisor'),
(2, 'admin', 'admin', 'Airbnb'),
(3, 'admin', 'admin', 'Booking');

-- --------------------------------------------------------

--
-- Structure de la table `Chambre`
--

CREATE TABLE `Chambre` (
  `idChambre` int(11) NOT NULL,
  `numeroEtage` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `numberOfBed` int(11) NOT NULL,
  `Pic` varchar(25) NOT NULL,
  `hotel_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `Chambre`
--

INSERT INTO `Chambre` (`idChambre`, `numeroEtage`, `price`, `numberOfBed`, `Pic`, `hotel_id`) VALUES
(1, 1, 120, 1, 'pic1.jpg', 1),
(2, 1, 130, 2, 'pic2.jpg', 1),
(3, 1, 150, 1, 'pic3.jpg', 2),
(4, 2, 180, 2, 'pic4.jpg', 2),
(5, 2, 200, 3, 'pic5.jpg', 3),
(6, 2, 220, 2, 'pic6.jpg', 3),
(7, 3, 240, 3, 'pic7.jpg', 1),
(8, 3, 270, 2, 'pic8.jpg', 1),
(9, 3, 300, 3, 'pic9.jpg', 2),
(10, 4, 320, 3, 'pic10.jpg', 2),
(11, 4, 350, 4, 'pic11.jpg', 3);

-- --------------------------------------------------------

--
-- Structure de la table `Client`
--

CREATE TABLE `Client` (
  `client_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `mail` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `Client`
--

INSERT INTO `Client` (`client_id`, `name`, `phone`, `mail`) VALUES
(1, 'Mansour Malik', '0657882408', 'malik210999@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `CreditCard`
--

CREATE TABLE `CreditCard` (
  `card_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `number` varchar(19) NOT NULL,
  `cvv` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `CreditCard`
--

INSERT INTO `CreditCard` (`card_id`, `client_id`, `name`, `number`, `cvv`) VALUES
(1, 1, 'Malik', '0123456789', '757'),


-- --------------------------------------------------------

--
-- Structure de la table `Hotel`
--

CREATE TABLE `Hotel` (
  `hotel_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `stars` int(11) NOT NULL,
  `numberofBeds` int(50) NOT NULL,
  `adresse_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `Hotel`
--

INSERT INTO `Hotel` (`hotel_id`, `name`, `stars`, `numberofBeds`, `adresse_id`) VALUES
(1, 'Marriot', 5, 250, 1),
(2, 'Sheraton', 4, 350, 2),
(3, 'Accor', 3, 180, 3);

-- --------------------------------------------------------

--
-- Structure de la table `Offer`
--

CREATE TABLE `Offer` (
  `id` int(11) NOT NULL,
  `agency_username` varchar(50) NOT NULL,
  `agency_password` varchar(50) NOT NULL,
  `newPrice` int(11) NOT NULL,
  `availabilityStart` date NOT NULL,
  `availabilityEnd` date NOT NULL,
  `numberOfBeds` int(11) NOT NULL,
  `hotel_id` int(11) NOT NULL,
  `chambre_id` int(11) NOT NULL,
  `agency_id` int(11) NOT NULL,
  `pic` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `Offer`
--

INSERT INTO `Offer` (`id`, `agency_username`, `agency_password`, `newPrice`, `availabilityStart`, `availabilityEnd`, `numberOfBeds`, `hotel_id`, `chambre_id`, `agency_id`, `pic`) VALUES
(1, 'admin', 'admin', 80, '2024-11-01', '2024-11-20', 1, 1, 1, 1, 'https://images.pexels.com/photos/271624/pexels-photo-271624.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
(2, 'admin', 'admin', 60, '2024-11-10', '2024-12-10', 1, 2, 1, 2, 'https://images.pexels.com/photos/14917460/pexels-photo-14917460.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
(4, 'admin', 'admin', 200, '2024-11-07', '2024-11-21', 2, 2, 4, 2, 'https://images.pexels.com/photos/19799232/pexels-photo-19799232/free-photo-of-une-matinee-paisible.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1'),
(7, 'admin', 'admin', 50, '2024-11-01', '2024-11-20', 1, 1, 1, 2, 'https://images.pexels.com/photos/271624/pexels-photo-271624.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');

-- --------------------------------------------------------

--
-- Structure de la table `Reservation`
--

CREATE TABLE `Reservation` (
  `reservation_id` int(11) NOT NULL,
  `inDate` date NOT NULL,
  `outDate` date NOT NULL,
  `idChambre` int(11) NOT NULL,
  `offer_id` int(11) NOT NULL,
  `reference` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `Reservation`
--

INSERT INTO `Reservation` (`reservation_id`, `inDate`, `outDate`, `idChambre`, `offer_id`, `reference`) VALUES
(1, '1980-01-01', '1980-01-01', 1, 1, '821364420'),
(7, '1980-01-01', '1980-01-01', 1, 1, '1561233534'),
(8, '1980-01-01', '1980-01-01', 1, 1, '1229612891'),
(9, '1980-01-01', '1980-01-01', 1, 1, '1547727137'),
(10, '1980-01-01', '1980-01-01', 1, 1, '369397955'),
(11, '1980-01-01', '1980-01-01', 1, 1, '71075638'),
(12, '1980-01-01', '1980-01-01', 1, 1, '637490135');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Adresse`
--
ALTER TABLE `Adresse`
  ADD PRIMARY KEY (`adresse_id`);

--
-- Index pour la table `Agency`
--
ALTER TABLE `Agency`
  ADD PRIMARY KEY (`agency_id`);

--
-- Index pour la table `Chambre`
--
ALTER TABLE `Chambre`
  ADD PRIMARY KEY (`idChambre`),
  ADD KEY `hotel_id` (`hotel_id`);

--
-- Index pour la table `Client`
--
ALTER TABLE `Client`
  ADD PRIMARY KEY (`client_id`);

--
-- Index pour la table `CreditCard`
--
ALTER TABLE `CreditCard`
  ADD PRIMARY KEY (`card_id`),
  ADD KEY `ForeignKey` (`client_id`);

--
-- Index pour la table `Hotel`
--
ALTER TABLE `Hotel`
  ADD PRIMARY KEY (`hotel_id`),
  ADD KEY `adresse_id` (`adresse_id`);

--
-- Index pour la table `Offer`
--
ALTER TABLE `Offer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `chambre_id` (`chambre_id`),
  ADD KEY `agency_id` (`agency_id`),
  ADD KEY `hotel_id` (`hotel_id`);

--
-- Index pour la table `Reservation`
--
ALTER TABLE `Reservation`
  ADD PRIMARY KEY (`reservation_id`),
  ADD KEY `idChambre` (`idChambre`),
  ADD KEY `Reservation_ibfk_2` (`offer_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Adresse`
--
ALTER TABLE `Adresse`
  MODIFY `adresse_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `Agency`
--
ALTER TABLE `Agency`
  MODIFY `agency_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `Chambre`
--
ALTER TABLE `Chambre`
  MODIFY `idChambre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT pour la table `Client`
--
ALTER TABLE `Client`
  MODIFY `client_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `CreditCard`
--
ALTER TABLE `CreditCard`
  MODIFY `card_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `Hotel`
--
ALTER TABLE `Hotel`
  MODIFY `hotel_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `Offer`
--
ALTER TABLE `Offer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `Reservation`
--
ALTER TABLE `Reservation`
  MODIFY `reservation_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `Chambre`
--
ALTER TABLE `Chambre`
  ADD CONSTRAINT `Chambre_ibfk_1` FOREIGN KEY (`hotel_id`) REFERENCES `Hotel` (`hotel_id`);

--
-- Contraintes pour la table `CreditCard`
--
ALTER TABLE `CreditCard`
  ADD CONSTRAINT `ForeignKey` FOREIGN KEY (`client_id`) REFERENCES `Client` (`client_id`);

--
-- Contraintes pour la table `Hotel`
--
ALTER TABLE `Hotel`
  ADD CONSTRAINT `Hotel_ibfk_1` FOREIGN KEY (`adresse_id`) REFERENCES `Adresse` (`adresse_id`);

--
-- Contraintes pour la table `Offer`
--
ALTER TABLE `Offer`
  ADD CONSTRAINT `Offer_ibfk_1` FOREIGN KEY (`chambre_id`) REFERENCES `Chambre` (`idChambre`),
  ADD CONSTRAINT `Offer_ibfk_2` FOREIGN KEY (`agency_id`) REFERENCES `Agency` (`agency_id`),
  ADD CONSTRAINT `Offer_ibfk_3` FOREIGN KEY (`hotel_id`) REFERENCES `Hotel` (`hotel_id`);

--
-- Contraintes pour la table `Reservation`
--
ALTER TABLE `Reservation`
  ADD CONSTRAINT `Reservation_ibfk_1` FOREIGN KEY (`idChambre`) REFERENCES `Chambre` (`idChambre`),
  ADD CONSTRAINT `Reservation_ibfk_2` FOREIGN KEY (`offer_id`) REFERENCES `Offer` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
