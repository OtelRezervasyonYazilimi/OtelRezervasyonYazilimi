-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 24 Ara 2015, 11:14:53
-- Sunucu sürümü: 5.6.17
-- PHP Sürümü: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Veritabanı: `otelrezervasyonsistemi`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `gelirgider`
--

CREATE TABLE IF NOT EXISTS `gelirgider` (
  `durum` int(11) NOT NULL,
  `tarih` date NOT NULL,
  `aciklama` varchar(155) NOT NULL,
  `otelNo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin5;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `musteriler`
--

CREATE TABLE IF NOT EXISTS `musteriler` (
  `musteriNo` int(11) NOT NULL AUTO_INCREMENT,
  `isim` text NOT NULL,
  `soyisim` text NOT NULL,
  `rezervasyonNo` int(11) NOT NULL,
  `odaNo` int(11) NOT NULL,
  `ozel` int(11) NOT NULL,
  `kalinanSure` int(11) NOT NULL,
  `otelNo` int(11) NOT NULL,
  PRIMARY KEY (`musteriNo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin5 AUTO_INCREMENT=2 ;

--
-- Tablo döküm verisi `musteriler`
--

INSERT INTO `musteriler` (`musteriNo`, `isim`, `soyisim`, `rezervasyonNo`, `odaNo`, `ozel`, `kalinanSure`, `otelNo`) VALUES
(1, 'mehmet', 'keskin', 1, 1, 0, 3, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `odalar`
--

CREATE TABLE IF NOT EXISTS `odalar` (
  `odaNo` int(11) NOT NULL AUTO_INCREMENT,
  `tip` varchar(100) NOT NULL,
  `kisiSayisi` int(11) NOT NULL,
  `GunlukUcret` int(11) NOT NULL,
  `durum` int(11) NOT NULL,
  `otelNo` int(11) NOT NULL,
  PRIMARY KEY (`odaNo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin5 AUTO_INCREMENT=10 ;

--
-- Tablo döküm verisi `odalar`
--

INSERT INTO `odalar` (`odaNo`, `tip`, `kisiSayisi`, `GunlukUcret`, `durum`, `otelNo`) VALUES
(1, '0', 3, 140, 0, 1),
(3, 'Presidental Suite ', 1, 0, 1, 1),
(4, 'Presidental Suite ', 1, 0, 0, 2),
(5, 'Junior Suite', 3, 0, 0, 3),
(6, 'Junior Suite', 4, 0, 0, 3),
(7, 'Suite Oda', 2, 0, 0, 4),
(8, 'Suite Oda', 2, 0, 0, 2),
(9, 'suite ', 3, 0, 0, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `otel`
--

CREATE TABLE IF NOT EXISTS `otel` (
  `otelNo` int(11) NOT NULL AUTO_INCREMENT,
  `otelAdi` varchar(55) NOT NULL,
  `adres` varchar(55) NOT NULL,
  `telefon` varchar(25) NOT NULL,
  `email` varchar(55) NOT NULL,
  PRIMARY KEY (`otelNo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin5 AUTO_INCREMENT=5 ;

--
-- Tablo döküm verisi `otel`
--

INSERT INTO `otel` (`otelNo`, `otelAdi`, `adres`, `telefon`, `email`) VALUES
(1, 'neferpitou', 'Rüzgarlıbahçe Mahallesi Kavak Sokak No:31 34805 Kavacık', '05786944814', 'neferpitou@gmail.com'),
(2, 'lucilfer', 'Beytem Plaza Büyükdere Cad. 20/B 34394 Şişli / İstanbul', '06879543117', 'lucilfer@gmail.com'),
(3, 'Kalluto Zoldyck', ' K2 Plaza Sarıkanarya Sokak No:14 34742 Kozyatağı / İst', '0536241824', 'KallutoZoldyck@gmail.com'),
(4, 'Alluka Zoldyck', ' Konyaaltı Cad. No:78 Muratpaşa/Antalya', '05683241989', 'AllukaZoldyck@gmail.com');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ozellikler`
--

CREATE TABLE IF NOT EXISTS `ozellikler` (
  `ozellikNo` int(11) NOT NULL AUTO_INCREMENT,
  `otelNo` int(11) NOT NULL,
  `odaNo` int(11) NOT NULL,
  `ozellikAdi` varchar(255) NOT NULL,
  `maliyet` int(11) NOT NULL,
  PRIMARY KEY (`ozellikNo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin5 AUTO_INCREMENT=5 ;

--
-- Tablo döküm verisi `ozellikler`
--

INSERT INTO `ozellikler` (`ozellikNo`, `otelNo`, `odaNo`, `ozellikAdi`, `maliyet`) VALUES
(1, 1, 1, 'tv', 0),
(2, 1, 1, 'minibar', 0),
(3, 1, 2, 'tv', 0),
(4, 2, 1, 'tv', 0);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `personel`
--

CREATE TABLE IF NOT EXISTS `personel` (
  `personelNo` int(11) NOT NULL AUTO_INCREMENT,
  `isim` varchar(155) NOT NULL,
  `soyisim` varchar(155) NOT NULL,
  `gorev` varchar(155) NOT NULL,
  `maas` int(11) NOT NULL,
  `izinBaslangic` date NOT NULL,
  `izinBitis` date NOT NULL,
  `toplamIzin` int(11) NOT NULL,
  `otelNo` int(11) NOT NULL,
  PRIMARY KEY (`personelNo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin5 AUTO_INCREMENT=2 ;

--
-- Tablo döküm verisi `personel`
--

INSERT INTO `personel` (`personelNo`, `isim`, `soyisim`, `gorev`, `maas`, `izinBaslangic`, `izinBitis`, `toplamIzin`, `otelNo`) VALUES
(1, 'mert', 'bag?rany', 'kasiyer', 200, '2015-12-02', '2015-12-04', 30, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `rezervasyonlar`
--

CREATE TABLE IF NOT EXISTS `rezervasyonlar` (
  `rezervasyonNo` int(11) NOT NULL AUTO_INCREMENT,
  `odaNo` int(11) NOT NULL,
  `musteriNo` int(11) NOT NULL,
  `girisTarihi` date NOT NULL,
  `cikisTarihi` date NOT NULL,
  `otelNo` int(11) NOT NULL,
  PRIMARY KEY (`rezervasyonNo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin5 AUTO_INCREMENT=10 ;

--
-- Tablo döküm verisi `rezervasyonlar`
--

INSERT INTO `rezervasyonlar` (`rezervasyonNo`, `odaNo`, `musteriNo`, `girisTarihi`, `cikisTarihi`, `otelNo`) VALUES
(1, 1, 1, '2015-12-02', '2015-12-05', 1),
(2, 2, 1, '2015-12-02', '2015-12-02', 1),
(3, 2, 1, '2015-11-11', '2015-12-12', 0),
(4, 2, 1, '2015-08-08', '2015-08-08', 1),
(5, 2, 1, '2015-07-07', '2015-07-07', 1),
(6, 1, 1, '2015-04-04', '2015-04-04', 0),
(7, 1, 1, '2015-04-04', '2015-04-04', 1),
(8, 1, 1, '2015-03-03', '2015-03-03', 1),
(9, 1, 1, '2015-02-03', '2015-03-03', 0);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `servisler`
--

CREATE TABLE IF NOT EXISTS `servisler` (
  `servisNo` int(11) NOT NULL AUTO_INCREMENT,
  `otelNo` int(11) NOT NULL,
  `odaNo` int(11) NOT NULL,
  `servisAdi` varchar(255) NOT NULL,
  `maliyet` int(11) NOT NULL,
  PRIMARY KEY (`servisNo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin5 AUTO_INCREMENT=5 ;

--
-- Tablo döküm verisi `servisler`
--

INSERT INTO `servisler` (`servisNo`, `otelNo`, `odaNo`, `servisAdi`, `maliyet`) VALUES
(1, 1, 1, 'sabah kahvaltısı', 0),
(2, 1, 1, 'internet servisim', 100),
(3, 2, 1, 'sabah kahvaltısı', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
