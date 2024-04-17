-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2024. Ápr 17. 06:15
-- Kiszolgáló verziója: 10.4.32-MariaDB
-- PHP verzió: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `asztalfoglalo`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `asztal`
--

CREATE TABLE `asztal` (
  `asztal_id` tinyint(3) UNSIGNED NOT NULL,
  `tipus_id` tinyint(3) UNSIGNED NOT NULL,
  `asztal_szam` tinyint(3) UNSIGNED NOT NULL,
  `etterem_id` tinyint(3) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `asztal`
--

INSERT INTO `asztal` (`asztal_id`, `tipus_id`, `asztal_szam`, `etterem_id`) VALUES
(3, 1, 1, 1),
(4, 2, 2, 1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `etterem`
--

CREATE TABLE `etterem` (
  `etterem_id` tinyint(3) UNSIGNED NOT NULL,
  `etterem_nev` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_swedish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `etterem`
--

INSERT INTO `etterem` (`etterem_id`, `etterem_nev`) VALUES
(1, 'Krusty Crab'),
(9, 'teszt'),
(8, 'TesztBS');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `foglalas`
--

CREATE TABLE `foglalas` (
  `foglalas_id` smallint(5) UNSIGNED NOT NULL,
  `foglalas_nev` varchar(40) NOT NULL,
  `foglalas_telszam` varchar(13) NOT NULL,
  `foglalas_csoport_meret` tinyint(2) UNSIGNED NOT NULL,
  `asztal_id` tinyint(3) UNSIGNED NOT NULL,
  `foglalas_idopont_kezd` datetime NOT NULL,
  `foglalas_idopont_veg` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `foglalas`
--

INSERT INTO `foglalas` (`foglalas_id`, `foglalas_nev`, `foglalas_telszam`, `foglalas_csoport_meret`, `asztal_id`, `foglalas_idopont_kezd`, `foglalas_idopont_veg`) VALUES
(9, 'bs', 'bs', 12, 3, '2024-11-03 10:00:00', '2024-11-03 11:00:00'),
(10, 'bs', 'bs', 12, 3, '2024-11-03 11:00:00', '2024-11-03 12:00:00'),
(11, 'bs', 'bs', 12, 3, '2024-11-03 13:00:00', '2024-11-03 14:00:00'),
(12, 'sad', 'sad', 12, 3, '2024-11-30 09:00:00', '2024-11-30 10:00:00'),
(13, 'sad', 'sad', 12, 3, '2024-12-01 09:00:00', '2024-12-01 10:00:00'),
(14, 'asd', 'asd', 12, 3, '2024-12-12 09:00:00', '2024-12-12 10:00:00'),
(16, 'baz', '+36705260034', 3, 4, '2024-11-09 13:00:00', '2024-11-09 13:59:00'),
(17, 'asd', '+367052600344', 10, 3, '2024-12-08 23:00:00', '2024-12-08 23:50:00'),
(18, 'sdf', '06705260034', 10, 3, '2024-12-09 23:00:00', '2024-12-09 23:50:00');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `nyitvatartas`
--

CREATE TABLE `nyitvatartas` (
  `nyitvatartas_id` tinyint(3) UNSIGNED NOT NULL,
  `etterem_id` tinyint(3) UNSIGNED NOT NULL,
  `nyitvatartas_nap` tinyint(3) UNSIGNED NOT NULL,
  `nyitvatartas_nyitas` time NOT NULL,
  `nyitvatartas_zaras` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `nyitvatartas`
--

INSERT INTO `nyitvatartas` (`nyitvatartas_id`, `etterem_id`, `nyitvatartas_nap`, `nyitvatartas_nyitas`, `nyitvatartas_zaras`) VALUES
(1, 1, 1, '08:00:00', '22:00:00'),
(2, 1, 2, '08:00:00', '22:00:00'),
(3, 1, 3, '08:00:00', '22:00:00'),
(4, 1, 4, '08:00:00', '22:00:00'),
(5, 1, 5, '08:00:00', '22:00:00'),
(6, 1, 6, '08:00:00', '22:00:00'),
(7, 1, 7, '08:00:00', '20:00:00'),
(43, 8, 0, '00:00:00', '23:59:00'),
(44, 8, 1, '00:00:00', '23:59:00'),
(45, 8, 2, '00:00:00', '23:59:00'),
(46, 8, 3, '00:00:00', '23:59:00'),
(47, 8, 4, '00:00:00', '23:59:00'),
(48, 8, 5, '00:00:00', '23:59:00'),
(49, 8, 6, '00:00:00', '23:59:00'),
(50, 9, 0, '08:00:00', '22:00:00'),
(51, 9, 1, '08:00:00', '22:00:00'),
(52, 9, 2, '08:00:00', '22:00:00'),
(53, 9, 3, '08:00:00', '22:00:00'),
(54, 9, 4, '08:00:00', '22:00:00'),
(55, 9, 5, '08:00:00', '22:00:00'),
(56, 9, 6, '08:00:00', '22:00:00');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `tipus`
--

CREATE TABLE `tipus` (
  `tipus_id` tinyint(3) UNSIGNED NOT NULL,
  `tipus_ferohely` tinyint(3) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `tipus`
--

INSERT INTO `tipus` (`tipus_id`, `tipus_ferohely`) VALUES
(1, 12),
(2, 6),
(3, 8);

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `asztal`
--
ALTER TABLE `asztal`
  ADD PRIMARY KEY (`asztal_id`),
  ADD UNIQUE KEY `asztal_szam` (`asztal_szam`,`etterem_id`),
  ADD KEY `tipus_id` (`tipus_id`),
  ADD KEY `etterem_id` (`etterem_id`);

--
-- A tábla indexei `etterem`
--
ALTER TABLE `etterem`
  ADD PRIMARY KEY (`etterem_id`),
  ADD UNIQUE KEY `etterem_nev` (`etterem_nev`);

--
-- A tábla indexei `foglalas`
--
ALTER TABLE `foglalas`
  ADD PRIMARY KEY (`foglalas_id`),
  ADD KEY `asztal_id` (`asztal_id`);

--
-- A tábla indexei `nyitvatartas`
--
ALTER TABLE `nyitvatartas`
  ADD PRIMARY KEY (`nyitvatartas_id`),
  ADD KEY `etterem_id` (`etterem_id`);

--
-- A tábla indexei `tipus`
--
ALTER TABLE `tipus`
  ADD PRIMARY KEY (`tipus_id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `asztal`
--
ALTER TABLE `asztal`
  MODIFY `asztal_id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT a táblához `etterem`
--
ALTER TABLE `etterem`
  MODIFY `etterem_id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT a táblához `foglalas`
--
ALTER TABLE `foglalas`
  MODIFY `foglalas_id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT a táblához `nyitvatartas`
--
ALTER TABLE `nyitvatartas`
  MODIFY `nyitvatartas_id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT a táblához `tipus`
--
ALTER TABLE `tipus`
  MODIFY `tipus_id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `asztal`
--
ALTER TABLE `asztal`
  ADD CONSTRAINT `asztal_ibfk_1` FOREIGN KEY (`etterem_id`) REFERENCES `etterem` (`etterem_id`),
  ADD CONSTRAINT `asztal_ibfk_2` FOREIGN KEY (`tipus_id`) REFERENCES `tipus` (`tipus_id`);

--
-- Megkötések a táblához `foglalas`
--
ALTER TABLE `foglalas`
  ADD CONSTRAINT `foglalas_ibfk_1` FOREIGN KEY (`asztal_id`) REFERENCES `asztal` (`asztal_id`);

--
-- Megkötések a táblához `nyitvatartas`
--
ALTER TABLE `nyitvatartas`
  ADD CONSTRAINT `nyitvatartas_ibfk_1` FOREIGN KEY (`etterem_id`) REFERENCES `etterem` (`etterem_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
