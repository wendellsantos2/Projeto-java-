-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 13-Fev-2022 às 00:24
-- Versão do servidor: 10.4.21-MariaDB
-- versão do PHP: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projetocadastrojava`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aparelho`
--

CREATE TABLE `aparelho` (
  `idAparelho` int(11) NOT NULL,
  `nomeAparelho` varchar(100) NOT NULL,
  `marca` varchar(100) NOT NULL,
  `descricao` varchar(200) NOT NULL,
  `valor` double NOT NULL,
  `idCliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `aparelho`
--

INSERT INTO `aparelho` (`idAparelho`, `nomeAparelho`, `marca`, `descricao`, `valor`, `idCliente`) VALUES
(1, 'Celular', 'Samsung', 'Quebrou a tela	', 124.36, 1),
(2, 'TV 32\'', 'LG', 'Trocar tudo', 2548.36, 2),
(3, 'Celular', 'MotoG', 'Não liga', 254.36, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `nomeCliente` varchar(100) NOT NULL,
  `sobrenome` varchar(100) NOT NULL,
  `cpfCliente` varchar(15) NOT NULL,
  `telefone` varchar(15) NOT NULL,
  `emailCliente` varchar(100) NOT NULL,
  `logradouro` varchar(100) NOT NULL,
  `rua` int(11) NOT NULL,
  `complemento` varchar(100) NOT NULL,
  `bairro` varchar(100) NOT NULL,
  `cidade` varchar(100) NOT NULL,
  `uf` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nomeCliente`, `sobrenome`, `cpfCliente`, `telefone`, `emailCliente`, `logradouro`, `rua`, `complemento`, `bairro`, `cidade`, `uf`) VALUES
(1, 'Clayton', 'Oliveira', '123.456.789-10', '(21)99999-9999', 'clay@gmail.com', 'Rua dos Santos', 1, 'Zona Pobre', 'Engenho NOvo', 'Cidade ', 'RJ'),
(2, 'João', 'MAria', '123.456.789-11', '(21)88888-8888', 'joao@gmail.com', 'Rua dos Touros', 5, 'zona Rica', 'Sapo Pemba', 'Santos', 'SP'),
(3, 'Maria', 'João', '123.456.789-12', '(21)97777-7777', 'maria@gmail.com', 'Rua das Vacas', 2, 'Zona mais ou menos', 'Esticadinho', 'Vitória', 'ES');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estado`
--

CREATE TABLE `estado` (
  `idEstado` int(11) NOT NULL,
  `uf` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `estado`
--

INSERT INTO `estado` (`idEstado`, `uf`) VALUES
(1, 'AM'),
(2, 'AC'),
(3, 'AL'),
(4, 'AP'),
(5, 'BA'),
(6, 'CE'),
(7, 'DF'),
(8, 'ES'),
(9, 'GO'),
(10, 'MA'),
(11, 'MG'),
(12, 'MS'),
(13, 'MT'),
(14, 'PA'),
(15, 'PB'),
(16, 'PE'),
(17, 'PI'),
(18, 'PR'),
(19, 'SC'),
(20, 'SE'),
(21, 'SP'),
(22, 'RJ'),
(23, 'RN'),
(24, 'RO'),
(25, 'RR'),
(26, 'RS'),
(27, 'TO');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nomeUsuario` varchar(100) NOT NULL,
  `usuario` varchar(20) NOT NULL,
  `senha` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aparelho`
--
ALTER TABLE `aparelho`
  ADD PRIMARY KEY (`idAparelho`),
  ADD KEY `idCliente` (`idCliente`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`),
  ADD UNIQUE KEY `cpfCliente` (`cpfCliente`),
  ADD UNIQUE KEY `emailCliente` (`emailCliente`);

--
-- Índices para tabela `estado`
--
ALTER TABLE `estado`
  ADD PRIMARY KEY (`idEstado`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD UNIQUE KEY `usuario` (`usuario`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aparelho`
--
ALTER TABLE `aparelho`
  MODIFY `idAparelho` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `estado`
--
ALTER TABLE `estado`
  MODIFY `idEstado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `aparelho`
--
ALTER TABLE `aparelho`
  ADD CONSTRAINT `aparelho_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
