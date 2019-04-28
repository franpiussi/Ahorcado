-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-04-2019 a las 22:24:35
-- Versión del servidor: 10.1.26-MariaDB
-- Versión de PHP: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hanged_game`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `winners`
--

CREATE TABLE `winners` (
  `id_winner` int(11) NOT NULL,
  `winner_name` varchar(50) NOT NULL,
  `word` varchar(50) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `winners`
--

INSERT INTO `winners` (`id_winner`, `winner_name`, `word`, `date`) VALUES
(2, 'Guido', 'palabra', '2019-04-28'),
(3, 'Guido', 'hola', '2019-04-28'),
(4, 'Franco', 'hola', '2019-04-28');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `words`
--

CREATE TABLE `words` (
  `id_word` int(11) NOT NULL,
  `word` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `words`
--

INSERT INTO `words` (`id_word`, `word`) VALUES
(1, 'ezequiel'),
(2, 'hola'),
(3, 'ojota');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `winners`
--
ALTER TABLE `winners`
  ADD PRIMARY KEY (`id_winner`);

--
-- Indices de la tabla `words`
--
ALTER TABLE `words`
  ADD PRIMARY KEY (`id_word`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `winners`
--
ALTER TABLE `winners`
  MODIFY `id_winner` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `words`
--
ALTER TABLE `words`
  MODIFY `id_word` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
