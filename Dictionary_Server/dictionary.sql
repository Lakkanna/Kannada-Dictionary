-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 31, 2018 at 04:10 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dictionary`
--

-- --------------------------------------------------------

--
-- Table structure for table `details`
--

CREATE TABLE `details` (
  `id` int(255) NOT NULL,
  `word` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `detail` varchar(255) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `details`
--

INSERT INTO `details` (`id`, `word`, `detail`) VALUES
(1, 'Dictionary', 'Dictionary is the word which holds the descripton of words.'),
(2, 'Success', 'The achieving of the results wanted or hoped for'),
(3, 'Failure', 'An economic policy that is doomed to failure'),
(4, 'Adequate', 'Satisfactory or acceptable in quality or quantity.'),
(5, 'Superfluous', 'Unnecessary, especially through being more than enough.'),
(6, 'bit rate', 'The number of bits per second that can be transmitted along a digital network.'),
(7, 'Pearl', 'A hard, lustrous spherical mass, typically white or bluish-grey, formed within the shell of a pearl oyster or other bivalve mollusc and highly prized as a gem'),
(8, 'Supreme', 'Highest in rank or authority.'),
(10, 'à²¬à²²à²¿à²·à³à² ', 'à²¤à³à²‚à²¬ à²¬à²²à²µà²¾à²¦à³à²¦à³'),
(11, 'Test', 'Examining the talent.'),
(12, 'à²¬à²²à³à²®à³†', 'à²¸à²¾à²®à²°à³à²¥à³à²¯');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `details`
--
ALTER TABLE `details`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `word` (`word`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `details`
--
ALTER TABLE `details`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
