-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Creato il: Apr 24, 2018 alle 18:28
-- Versione del server: 5.7.21-0ubuntu0.16.04.1
-- Versione PHP: 7.0.28-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `UniMarina`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `Exam`
--

CREATE TABLE `Exam` (
  `ExamID` bigint(32) NOT NULL,
  `Name` varchar(32) NOT NULL,
  `Credits` int(3) NOT NULL,
  `Description` text NOT NULL,
  `BadgeNumber` bigint(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Login`
--

CREATE TABLE `Login` (
  `Username` varchar(32) NOT NULL,
  `Password` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Login`
--

INSERT INTO `Login` (`Username`, `Password`) VALUES
('Marina', 'marina');

-- --------------------------------------------------------

--
-- Struttura della tabella `Professor`
--

CREATE TABLE `Professor` (
  `BadgeNumber` bigint(32) NOT NULL,
  `Name` varchar(32) NOT NULL,
  `Surname` varchar(32) NOT NULL,
  `Email` varchar(128) NOT NULL,
  `ExamID` bigint(32) NOT NULL,
  `DateOfBirth` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `Student`
--

CREATE TABLE `Student` (
  `BadgeNumber` bigint(64) NOT NULL,
  `Name` varchar(32) NOT NULL,
  `Surname` varchar(32) NOT NULL,
  `Email` varchar(128) NOT NULL,
  `DataOfBirth` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `StudyPlan`
--

CREATE TABLE `StudyPlan` (
  `BadgeNumber` bigint(32) NOT NULL,
  `ExamID` bigint(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `Exam`
--
ALTER TABLE `Exam`
  ADD PRIMARY KEY (`ExamID`),
  ADD UNIQUE KEY `ExamID` (`ExamID`),
  ADD KEY `ExamID_2` (`ExamID`);

--
-- Indici per le tabelle `Professor`
--
ALTER TABLE `Professor`
  ADD PRIMARY KEY (`BadgeNumber`);

--
-- Indici per le tabelle `Student`
--
ALTER TABLE `Student`
  ADD PRIMARY KEY (`BadgeNumber`),
  ADD UNIQUE KEY `BadgeNumber` (`BadgeNumber`),
  ADD KEY `BadgeNumber_2` (`BadgeNumber`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `Exam`
--
ALTER TABLE `Exam`
  MODIFY `ExamID` bigint(32) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `Professor`
--
ALTER TABLE `Professor`
  MODIFY `BadgeNumber` bigint(32) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT per la tabella `Student`
--
ALTER TABLE `Student`
  MODIFY `BadgeNumber` bigint(64) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
