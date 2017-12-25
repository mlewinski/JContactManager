-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 25 Gru 2017, 21:17
-- Wersja serwera: 10.1.26-MariaDB-1
-- Wersja PHP: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `nproject`
--
CREATE DATABASE IF NOT EXISTS `nproject` DEFAULT CHARACTER SET utf16 COLLATE utf16_unicode_ci;
USE `nproject`;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `Communicators`
--

DROP TABLE IF EXISTS `Communicators`;
CREATE TABLE IF NOT EXISTS `Communicators` (
  `ID` int(11) NOT NULL,
  `OwnerID` int(11) NOT NULL,
  `Label` text COLLATE utf16_unicode_ci NOT NULL,
  `Note` text COLLATE utf16_unicode_ci NOT NULL,
  `Category` text COLLATE utf16_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf16 COLLATE=utf16_unicode_ci;

--
-- Tabela Truncate przed wstawieniem `Communicators`
--

TRUNCATE TABLE `Communicators`;
-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ContactInformations`
--

DROP TABLE IF EXISTS `ContactInformations`;
CREATE TABLE IF NOT EXISTS `ContactInformations` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `OwnerID` int(11) NOT NULL,
  `Name` text COLLATE utf16_unicode_ci NOT NULL,
  `Address` text COLLATE utf16_unicode_ci NOT NULL,
  `City` text COLLATE utf16_unicode_ci NOT NULL,
  `Country` text COLLATE utf16_unicode_ci NOT NULL,
  `Note` text COLLATE utf16_unicode_ci NOT NULL,
  `Website` text COLLATE utf16_unicode_ci NOT NULL,
  `Nickname` text COLLATE utf16_unicode_ci NOT NULL,
  `Gender` text COLLATE utf16_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf16 COLLATE=utf16_unicode_ci;

--
-- Tabela Truncate przed wstawieniem `ContactInformations`
--

TRUNCATE TABLE `ContactInformations`;
--
-- Zrzut danych tabeli `ContactInformations`
--

INSERT INTO `ContactInformations` (`ID`, `OwnerID`, `Name`, `Address`, `City`, `Country`, `Note`, `Website`, `Nickname`, `Gender`) VALUES
(1, 0, 'Stefan HelloWorld', 'Programistów 4', 'Kraków', 'Polska', 'Jakiś dziwny typ', 'www.geeksforgeeks.org', 'Koder', 'M');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `Contacts`
--

DROP TABLE IF EXISTS `Contacts`;
CREATE TABLE IF NOT EXISTS `Contacts` (
  `ID` int(11) NOT NULL,
  `OwnerID` int(11) NOT NULL COMMENT 'For future use',
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf16 COLLATE=utf16_unicode_ci;

--
-- Tabela Truncate przed wstawieniem `Contacts`
--

TRUNCATE TABLE `Contacts`;
--
-- Zrzut danych tabeli `Contacts`
--

INSERT INTO `Contacts` (`ID`, `OwnerID`) VALUES
(0, 0);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `Emails`
--

DROP TABLE IF EXISTS `Emails`;
CREATE TABLE IF NOT EXISTS `Emails` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EmailAddress` text COLLATE utf16_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf16 COLLATE=utf16_unicode_ci;

--
-- Tabela Truncate przed wstawieniem `Emails`
--

TRUNCATE TABLE `Emails`;
-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `GenericComms`
--

DROP TABLE IF EXISTS `GenericComms`;
CREATE TABLE IF NOT EXISTS `GenericComms` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Address` text COLLATE utf16_unicode_ci NOT NULL,
  `Protocol` text COLLATE utf16_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf16 COLLATE=utf16_unicode_ci;

--
-- Tabela Truncate przed wstawieniem `GenericComms`
--

TRUNCATE TABLE `GenericComms`;
-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `PhoneNumbers`
--

DROP TABLE IF EXISTS `PhoneNumbers`;
CREATE TABLE IF NOT EXISTS `PhoneNumbers` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Number` text COLLATE utf16_unicode_ci NOT NULL,
  `Network` text COLLATE utf16_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf16 COLLATE=utf16_unicode_ci;

--
-- Tabela Truncate przed wstawieniem `PhoneNumbers`
--

TRUNCATE TABLE `PhoneNumbers`;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
