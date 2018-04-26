-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Creato il: Apr 24, 2018 alle 14:33
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
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `Exam`
--
ALTER TABLE `Exam`
  MODIFY `ExamID` bigint(32) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
