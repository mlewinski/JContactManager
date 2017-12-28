-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 28 Gru 2017, 12:41
-- Wersja serwera: 10.1.26-MariaDB-1
-- Wersja PHP: 7.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `nproject`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `Communicators`
--

CREATE TABLE `Communicators` (
  `ID` int(11) NOT NULL,
  `OwnerID` int(11) NOT NULL,
  `Label` text COLLATE utf16_unicode_ci NOT NULL,
  `Note` text COLLATE utf16_unicode_ci NOT NULL,
  `Category` text COLLATE utf16_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf16 COLLATE=utf16_unicode_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ContactInformations`
--

CREATE TABLE `ContactInformations` (
  `ID` int(11) NOT NULL,
  `OwnerID` int(11) NOT NULL,
  `Name` text COLLATE utf16_unicode_ci NOT NULL,
  `Address` text COLLATE utf16_unicode_ci NOT NULL,
  `City` text COLLATE utf16_unicode_ci NOT NULL,
  `Country` text COLLATE utf16_unicode_ci NOT NULL,
  `Note` text COLLATE utf16_unicode_ci NOT NULL,
  `Website` text COLLATE utf16_unicode_ci NOT NULL,
  `Nickname` text COLLATE utf16_unicode_ci NOT NULL,
  `Gender` text COLLATE utf16_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf16 COLLATE=utf16_unicode_ci;

--
-- Zrzut danych tabeli `ContactInformations`
--

INSERT INTO `ContactInformations` (`ID`, `OwnerID`, `Name`, `Address`, `City`, `Country`, `Note`, `Website`, `Nickname`, `Gender`) VALUES
(1, 0, 'Stefan HelloWorld', 'Programistów 4', 'Kraków', 'Polska', 'Jakiś dziwny typ', 'www.geeksforgeeks.org', 'Koder', 'M');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `Contacts`
--

CREATE TABLE `Contacts` (
  `ID` int(11) NOT NULL,
  `OwnerID` int(11) NOT NULL COMMENT 'For future use'
) ENGINE=MyISAM DEFAULT CHARSET=utf16 COLLATE=utf16_unicode_ci;

--
-- Zrzut danych tabeli `Contacts`
--

INSERT INTO `Contacts` (`ID`, `OwnerID`) VALUES
(0, 0);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `Emails`
--

CREATE TABLE `Emails` (
  `ID` int(11) NOT NULL,
  `EmailAddress` text COLLATE utf16_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf16 COLLATE=utf16_unicode_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `GenericComms`
--

CREATE TABLE `GenericComms` (
  `ID` int(11) NOT NULL,
  `Address` text COLLATE utf16_unicode_ci NOT NULL,
  `Protocol` text COLLATE utf16_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf16 COLLATE=utf16_unicode_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `PhoneNumbers`
--

CREATE TABLE `PhoneNumbers` (
  `ID` int(11) NOT NULL,
  `Number` text COLLATE utf16_unicode_ci NOT NULL,
  `Network` text COLLATE utf16_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf16 COLLATE=utf16_unicode_ci;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `Communicators`
--
ALTER TABLE `Communicators`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `ContactInformations`
--
ALTER TABLE `ContactInformations`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Contacts`
--
ALTER TABLE `Contacts`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Emails`
--
ALTER TABLE `Emails`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `GenericComms`
--
ALTER TABLE `GenericComms`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `PhoneNumbers`
--
ALTER TABLE `PhoneNumbers`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `ContactInformations`
--
ALTER TABLE `ContactInformations`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT dla tabeli `Emails`
--
ALTER TABLE `Emails`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `GenericComms`
--
ALTER TABLE `GenericComms`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT dla tabeli `PhoneNumbers`
--
ALTER TABLE `PhoneNumbers`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
