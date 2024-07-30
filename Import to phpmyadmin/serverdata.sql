-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 30, 2024 at 10:10 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `portodb`
--

-- --------------------------------------------------------

--
-- Table structure for table `serverdata`
--

CREATE TABLE `serverdata` (
  `C1` int(255) NOT NULL,
  `C2` int(255) NOT NULL,
  `C3` int(255) NOT NULL,
  `dataid` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `serverdata`
--

INSERT INTO `serverdata` (`C1`, `C2`, `C3`, `dataid`) VALUES
(1, 2, 3, 30),
(4, 5, 6, 31),
(7, 8, 9, 32);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `serverdata`
--
ALTER TABLE `serverdata`
  ADD PRIMARY KEY (`dataid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `serverdata`
--
ALTER TABLE `serverdata`
  MODIFY `dataid` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
