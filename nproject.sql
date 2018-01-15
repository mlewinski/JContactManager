-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 14 Sty 2018, 16:06
-- Wersja serwera: 10.1.21-MariaDB
-- Wersja PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `jcontactmanager`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `contacts`
--

CREATE TABLE `contacts` (
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `contacts`
--


-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `contactsinformations`
--

CREATE TABLE `contactsinformations` (
  `Name` varchar(50) NOT NULL,
  `Nickname` varchar(50) NOT NULL,
  `Gender` varchar(50) NOT NULL,
  `Address` varchar(80) NOT NULL,
  `City` varchar(50) NOT NULL,
  `Country` varchar(40) NOT NULL,
  `Note` text NOT NULL,
  `Website` varchar(100) NOT NULL,
  `ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `contactsinformations`
--


-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `emails`
--

CREATE TABLE `emails` (
  `ID` int(11) NOT NULL,
  `PrivateEmailAddress` varchar(50) NOT NULL,
  `WorkEmailAddress` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `emails`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `messengers`
--

CREATE TABLE `messengers` (
  `ID` int(11) NOT NULL,
  `Note` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `messengers`
--
-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `phonenumbers`
--

CREATE TABLE `phonenumbers` (
  `ID` int(11) NOT NULL,
  `PrivateNumber` varchar(30) NOT NULL,
  `WorkNumber` varchar(30) NOT NULL,
  `PrivateNetwork` varchar(30) NOT NULL,
  `WorkNetwork` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `phonenumbers`
--

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `contacts`
--
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `phonenumbers`
-
