-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2024. Ápr 11. 10:50
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
  `asztal_id` int(10) UNSIGNED NOT NULL,
  `tipus_id` tinyint(3) UNSIGNED NOT NULL,
  `asztal_szam` tinyint(3) UNSIGNED NOT NULL,
  `etterem_id` int(10) UNSIGNED NOT NULL
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
  `etterem_id` int(10) UNSIGNED NOT NULL,
  `etterem_nev` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_swedish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `etterem`
--

INSERT INTO `etterem` (`etterem_id`, `etterem_nev`) VALUES
(1, 'Krusty Crab');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `foglalas`
--

CREATE TABLE `foglalas` (
  `foglalas_id` int(10) UNSIGNED NOT NULL,
  `foglalas_nev` varchar(40) NOT NULL,
  `foglalas_telszam` varchar(12) NOT NULL,
  `foglalas_csoport_meret` tinyint(4) UNSIGNED NOT NULL,
  `asztal_id` int(10) UNSIGNED NOT NULL,
  `foglalas_idopont_kezd` datetime NOT NULL,
  `foglalas_idopont_veg` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `foglalas`
--

INSERT INTO `foglalas` (`foglalas_id`, `foglalas_nev`, `foglalas_telszam`, `foglalas_csoport_meret`, `asztal_id`, `foglalas_idopont_kezd`, `foglalas_idopont_veg`) VALUES
(2, 'asd', 'asd', 12, 3, '2024-11-03 11:00:00', '2024-11-03 12:00:00'),
(3, 'asd', 'asd', 6, 3, '2024-11-04 12:00:00', '2024-11-04 13:00:00'),
(4, 'asd', 'asd', 12, 3, '2024-11-02 11:00:00', '2024-11-02 12:00:00'),
(11, 'asd', 'asd', 12, 3, '2024-11-05 08:00:00', '2024-11-05 09:00:00'),
(12, 'asd', 'asd', 12, 3, '2025-03-02 19:00:00', '2025-03-02 19:02:00'),
(13, 'asd', 'asd', 12, 3, '3000-03-02 19:00:00', '3000-03-02 19:02:00'),
(14, 'asd', 'asd', 12, 3, '2033-02-03 19:00:00', '2033-02-03 19:02:00'),
(15, 'asd', 'asd', 12, 3, '2033-02-03 19:05:00', '2033-02-03 19:05:00'),
(16, 'asd', 'asd', 12, 3, '2033-02-03 19:06:00', '2033-02-03 19:06:00');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `nyitvatartas`
--

CREATE TABLE `nyitvatartas` (
  `nyitvatartas_id` int(10) UNSIGNED NOT NULL,
  `etterem_id` int(10) UNSIGNED NOT NULL,
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
(7, 1, 7, '08:00:00', '20:00:00');

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
(2, 6);

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `asztal`
--
ALTER TABLE `asztal`
  ADD PRIMARY KEY (`asztal_id`),
  ADD KEY `tipus_id` (`tipus_id`),
  ADD KEY `etterem_id` (`etterem_id`);

--
-- A tábla indexei `etterem`
--
ALTER TABLE `etterem`
  ADD PRIMARY KEY (`etterem_id`);

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
  MODIFY `asztal_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT a táblához `etterem`
--
ALTER TABLE `etterem`
  MODIFY `etterem_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT a táblához `foglalas`
--
ALTER TABLE `foglalas`
  MODIFY `foglalas_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT a táblához `nyitvatartas`
--
ALTER TABLE `nyitvatartas`
  MODIFY `nyitvatartas_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT a táblához `tipus`
--
ALTER TABLE `tipus`
  MODIFY `tipus_id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
