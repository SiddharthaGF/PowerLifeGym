-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 20-12-2022 a las 06:06:36
-- Versión del servidor: 8.0.30
-- Versión de PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `powerlifegymdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cellphone_numbers`
--

CREATE TABLE `cellphone_numbers` (
  `id` int NOT NULL,
  `id_person` int NOT NULL,
  `number` char(10) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clients`
--

CREATE TABLE `clients` (
  `id` int NOT NULL,
  `id_person` int DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clothes`
--

CREATE TABLE `clothes` (
  `id` int NOT NULL,
  `id_product` int NOT NULL,
  `id_gender` int NOT NULL,
  `size` varchar(5) NOT NULL,
  `color` varchar(50) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `emails`
--

CREATE TABLE `emails` (
  `id` int NOT NULL,
  `id_person` int NOT NULL,
  `email` varchar(150) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genders`
--

CREATE TABLE `genders` (
  `id` int NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `groups`
--

CREATE TABLE `groups` (
  `id` int NOT NULL,
  `id_instructor` int NOT NULL,
  `name` varchar(150) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscriptions`
--

CREATE TABLE `inscriptions` (
  `id` int NOT NULL,
  `id_client` int NOT NULL,
  `id_subscription` int NOT NULL,
  `id_group` int NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `instructors`
--

CREATE TABLE `instructors` (
  `id` int NOT NULL,
  `id_person` int DEFAULT NULL,
  `id_specialization` int DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `people`
--

CREATE TABLE `people` (
  `id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `dni` char(10) UNIQUE NOT NULL,
  `id_gender` int NOT NULL,
  `birthdate` date NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `physical_monitoring`
--

CREATE TABLE `physical_monitoring` (
  `id` int NOT NULL,
  `id_client` int NOT NULL,
  `height` int DEFAULT NULL,
  `weight` int DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `presence_clients`
--

CREATE TABLE `presence_clients` (
  `id` int NOT NULL,
  `id_client` int NOT NULL,
  `date` date NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `presentations`
--

CREATE TABLE `presentations` (
  `id` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

CREATE TABLE `products` (
  `id` int NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `quantity` int DEFAULT '0',
  `brand` varchar(100) DEFAULT 'generic',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `promotions`
--

CREATE TABLE `promotions` (
  `id` int NOT NULL,
  `id_product` int NOT NULL,
  `discount` int NOT NULL,
  `effective_date` date DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `specializations`
--

CREATE TABLE `specializations` (
  `id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(150) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subscriptions`
--

CREATE TABLE `subscriptions` (
  `id` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `supplements`
--

CREATE TABLE `supplements` (
  `id` int NOT NULL,
  `id_product` int NOT NULL,
  `id_presentation` int NOT NULL,
  `content` int NOT NULL,
  `units` varchar(0) NOT NULL,
  `expiration_date` date DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int NOT NULL,
  `nick` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `email` varchar(150) NOT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cellphone_numbers`
--
ALTER TABLE `cellphone_numbers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `number` (`number`),
  ADD KEY `id_person` (`id_person`);

--
-- Indices de la tabla `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_person` (`id_person`);

--
-- Indices de la tabla `clothes`
--
ALTER TABLE `clothes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_product` (`id_product`),
  ADD KEY `id_gender` (`id_gender`);

--
-- Indices de la tabla `emails`
--
ALTER TABLE `emails`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `id_person` (`id_person`);

--
-- Indices de la tabla `genders`
--
ALTER TABLE `genders`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_instructor` (`id_instructor`);

--
-- Indices de la tabla `inscriptions`
--
ALTER TABLE `inscriptions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_client` (`id_client`),
  ADD KEY `id_subscription` (`id_subscription`),
  ADD KEY `id_group` (`id_group`);

--
-- Indices de la tabla `instructors`
--
ALTER TABLE `instructors`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_person` (`id_person`),
  ADD KEY `id_specialization` (`id_specialization`);

--
-- Indices de la tabla `people`
--
ALTER TABLE `people`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_gender` (`id_gender`);

--
-- Indices de la tabla `physical_monitoring`
--
ALTER TABLE `physical_monitoring`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_client` (`id_client`);

--
-- Indices de la tabla `presence_clients`
--
ALTER TABLE `presence_clients`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_client` (`id_client`);

--
-- Indices de la tabla `presentations`
--
ALTER TABLE `presentations`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `promotions`
--
ALTER TABLE `promotions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_product` (`id_product`);

--
-- Indices de la tabla `specializations`
--
ALTER TABLE `specializations`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `subscriptions`
--
ALTER TABLE `subscriptions`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `supplements`
--
ALTER TABLE `supplements`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_product` (`id_product`),
  ADD KEY `id_presentation` (`id_presentation`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cellphone_numbers`
--
ALTER TABLE `cellphone_numbers`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `clients`
--
ALTER TABLE `clients`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `clothes`
--
ALTER TABLE `clothes`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `emails`
--
ALTER TABLE `emails`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `genders`
--
ALTER TABLE `genders`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `groups`
--
ALTER TABLE `groups`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `inscriptions`
--
ALTER TABLE `inscriptions`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `instructors`
--
ALTER TABLE `instructors`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `people`
--
ALTER TABLE `people`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `physical_monitoring`
--
ALTER TABLE `physical_monitoring`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `presence_clients`
--
ALTER TABLE `presence_clients`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `presentations`
--
ALTER TABLE `presentations`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `products`
--
ALTER TABLE `products`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `promotions`
--
ALTER TABLE `promotions`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `specializations`
--
ALTER TABLE `specializations`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `subscriptions`
--
ALTER TABLE `subscriptions`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `supplements`
--
ALTER TABLE `supplements`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cellphone_numbers`
--
ALTER TABLE `cellphone_numbers`
  ADD CONSTRAINT `cellphone_numbers_ibfk_1` FOREIGN KEY (`id_person`) REFERENCES `people` (`id`);

--
-- Filtros para la tabla `clients`
--
ALTER TABLE `clients`
  ADD CONSTRAINT `clients_ibfk_1` FOREIGN KEY (`id_person`) REFERENCES `people` (`id`);

--
-- Filtros para la tabla `clothes`
--
ALTER TABLE `clothes`
  ADD CONSTRAINT `clothes_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `clothes_ibfk_2` FOREIGN KEY (`id_gender`) REFERENCES `genders` (`id`);

--
-- Filtros para la tabla `emails`
--
ALTER TABLE `emails`
  ADD CONSTRAINT `emails_ibfk_1` FOREIGN KEY (`id_person`) REFERENCES `people` (`id`);

--
-- Filtros para la tabla `groups`
--
ALTER TABLE `groups`
  ADD CONSTRAINT `groups_ibfk_1` FOREIGN KEY (`id_instructor`) REFERENCES `instructors` (`id`);

--
-- Filtros para la tabla `inscriptions`
--
ALTER TABLE `inscriptions`
  ADD CONSTRAINT `inscriptions_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id`),
  ADD CONSTRAINT `inscriptions_ibfk_2` FOREIGN KEY (`id_subscription`) REFERENCES `subscriptions` (`id`),
  ADD CONSTRAINT `inscriptions_ibfk_3` FOREIGN KEY (`id_group`) REFERENCES `groups` (`id`);

--
-- Filtros para la tabla `instructors`
--
ALTER TABLE `instructors`
  ADD CONSTRAINT `instructors_ibfk_1` FOREIGN KEY (`id_person`) REFERENCES `people` (`id`),
  ADD CONSTRAINT `instructors_ibfk_2` FOREIGN KEY (`id_specialization`) REFERENCES `specializations` (`id`);

--
-- Filtros para la tabla `people`
--
ALTER TABLE `people`
  ADD CONSTRAINT `people_ibfk_1` FOREIGN KEY (`id_gender`) REFERENCES `genders` (`id`);

--
-- Filtros para la tabla `physical_monitoring`
--
ALTER TABLE `physical_monitoring`
  ADD CONSTRAINT `physical_monitoring_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id`);

--
-- Filtros para la tabla `presence_clients`
--
ALTER TABLE `presence_clients`
  ADD CONSTRAINT `presence_clients_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id`);

--
-- Filtros para la tabla `promotions`
--
ALTER TABLE `promotions`
  ADD CONSTRAINT `promotions_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `products` (`id`);

--
-- Filtros para la tabla `supplements`
--
ALTER TABLE `supplements`
  ADD CONSTRAINT `supplements_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `supplements_ibfk_2` FOREIGN KEY (`id_presentation`) REFERENCES `presentations` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
