-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2024. Jan 25. 17:03
-- Kiszolgáló verziója: 10.4.32-MariaDB
-- PHP verzió: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+01:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `zghjbn_asztalfoglalo`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `asztalok`
--

CREATE TABLE `asztalok` (
  `id` int(10) UNSIGNED NOT NULL,
  `tipus` tinyint(3) UNSIGNED NOT NULL,
  `etterem_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `asztal_tipusok`
--

CREATE TABLE `asztal_tipusok` (
  `id` tinyint(3) UNSIGNED NOT NULL,
  `ferohely` tinyint(3) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `ettermek`
--

CREATE TABLE `ettermek` (
  `id` int(10) UNSIGNED NOT NULL,
  `nev` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_swedish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `foglalasok`
--

CREATE TABLE `foglalasok` (
  `id` int(10) UNSIGNED NOT NULL,
  `foglalo_nev` varchar(40) NOT NULL,
  `foglalo_telszam` varchar(12) NOT NULL,
  `csoport_meret` tinyint(4) UNSIGNED NOT NULL,
  `asztal_id` int(10) UNSIGNED NOT NULL,
  `idopont_kezd` datetime NOT NULL,
  `idopont_veg` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `nyitvatartasok`
--

CREATE TABLE `nyitvatartasok` (
  `id` int(10) UNSIGNED NOT NULL,
  `etterem_id` int(10) UNSIGNED NOT NULL,
  `nap` tinyint(3) UNSIGNED NOT NULL,
  `nyitas` time NOT NULL,
  `zaras` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `asztalok`
--
ALTER TABLE `asztalok`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tipus` (`tipus`),
  ADD KEY `etterem` (`etterem_id`);

--
-- A tábla indexei `asztal_tipusok`
--
ALTER TABLE `asztal_tipusok`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `ettermek`
--
ALTER TABLE `ettermek`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `foglalasok`
--
ALTER TABLE `foglalasok`
  ADD PRIMARY KEY (`id`),
  ADD KEY `asztal_id` (`asztal_id`);

--
-- A tábla indexei `nyitvatartasok`
--
ALTER TABLE `nyitvatartasok`
  ADD PRIMARY KEY (`id`),
  ADD KEY `etterem_id` (`etterem_id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `asztalok`
--
ALTER TABLE `asztalok`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `asztal_tipusok`
--
ALTER TABLE `asztal_tipusok`
  MODIFY `id` tinyint(3) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `ettermek`
--
ALTER TABLE `ettermek`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `foglalasok`
--
ALTER TABLE `foglalasok`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `nyitvatartasok`
--
ALTER TABLE `nyitvatartasok`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `asztalok`
--
ALTER TABLE `asztalok`
  ADD CONSTRAINT `asztalok_ibfk_1` FOREIGN KEY (`etterem_id`) REFERENCES `ettermek` (`id`),
  ADD CONSTRAINT `asztalok_ibfk_2` FOREIGN KEY (`tipus`) REFERENCES `asztal_tipusok` (`id`);

--
-- Megkötések a táblához `foglalasok`
--
ALTER TABLE `foglalasok`
  ADD CONSTRAINT `foglalasok_ibfk_1` FOREIGN KEY (`asztal_id`) REFERENCES `asztalok` (`id`);

--
-- Megkötések a táblához `nyitvatartasok`
--
ALTER TABLE `nyitvatartasok`
  ADD CONSTRAINT `nyitvatartasok_ibfk_1` FOREIGN KEY (`etterem_id`) REFERENCES `ettermek` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
