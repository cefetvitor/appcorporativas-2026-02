-- phpMyAdmin SQL Dump
-- version 5.2.3
-- https://www.phpmyadmin.net/
--
-- Host: aula3-mysql:3306
-- Tempo de geração: 18-Set-2026 às 23:36
-- Versão do servidor: 8.4.11
-- versão do PHP: 8.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dados: `aula`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `id` bigint NOT NULL,
  `nome` varchar(255) NOT NULL,
  `dataNascimento` date NOT NULL,
  `quemCadastrou` bigint DEFAULT NULL,
  `quemAlterouAUltimavez` bigint DEFAULT NULL,
  `dataCadastro` date DEFAULT NULL,
  `dataUltimaAlteracao` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id`, `nome`, `dataNascimento`, `quemCadastrou`, `quemAlterouAUltimavez`, `dataCadastro`, `dataUltimaAlteracao`) VALUES
(1, 'Teste', '2026-09-18', NULL, NULL, '2026-09-18', '2026-09-18'),
(2, 'Teste', '2026-09-18', NULL, NULL, '2026-09-18', '2026-09-18'),
(3, 'Teste', '2026-09-18', NULL, NULL, '2026-09-18', '2026-09-18'),
(4, 'Teste2', '2026-09-18', NULL, NULL, '2026-09-18', '2026-09-18');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_pessoa_quemCadastrou` (`quemCadastrou`),
  ADD KEY `fk_pessoa_quemAlterouAUltimavez` (`quemAlterouAUltimavez`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD CONSTRAINT `fk_pessoa_quemAlterouAUltimavez` FOREIGN KEY (`quemAlterouAUltimavez`) REFERENCES `pessoa` (`id`),
  ADD CONSTRAINT `fk_pessoa_quemCadastrou` FOREIGN KEY (`quemCadastrou`) REFERENCES `pessoa` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
