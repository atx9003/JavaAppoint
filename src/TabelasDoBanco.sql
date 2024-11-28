tabelas do banco: -- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 22/11/2024 às 10:18
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: javaappointdb
--

-- --------------------------------------------------------

--
-- Estrutura para tabela agendamentos
--

CREATE TABLE agendamentos (
  id int(11) NOT NULL,
  data date NOT NULL,
  hora time NOT NULL,
  cliente_id int(11) NOT NULL,
  funcionario_id int(11) NOT NULL,
  servico_id int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela clientes
--

CREATE TABLE clientes (
  id int(11) NOT NULL,
  nome varchar(255) NOT NULL,
  telefone varchar(15) NOT NULL,
  email varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela funcionarios
--

CREATE TABLE funcionarios (
  id int(11) NOT NULL,
  nome varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela servicos
--

CREATE TABLE servicos (
  id int(11) NOT NULL,
  nome varchar(255) NOT NULL,
  duracao int(11) NOT NULL,
  preco decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela agendamentos
--
ALTER TABLE agendamentos
  ADD PRIMARY KEY (id),
  ADD KEY cliente_id (cliente_id),
  ADD KEY funcionario_id (funcionario_id),
  ADD KEY servico_id (servico_id);

--
-- Índices de tabela clientes
--
ALTER TABLE clientes
  ADD PRIMARY KEY (id);

--
-- Índices de tabela funcionarios
--
ALTER TABLE funcionarios
  ADD PRIMARY KEY (id);

--
-- Índices de tabela servicos
--
ALTER TABLE servicos
  ADD PRIMARY KEY (id);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela agendamentos
--
ALTER TABLE agendamentos
  MODIFY id int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela clientes
--
ALTER TABLE clientes
  MODIFY id int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela funcionarios
--
ALTER TABLE funcionarios
  MODIFY id int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela servicos
--
ALTER TABLE servicos
  MODIFY id int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas agendamentos
--
ALTER TABLE agendamentos
  ADD CONSTRAINT agendamentos_ibfk_1 FOREIGN KEY (cliente_id) REFERENCES clientes (id) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT agendamentos_ibfk_2 FOREIGN KEY (funcionario_id) REFERENCES funcionarios (id) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT agendamentos_ibfk_3 FOREIGN KEY (servico_id) REFERENCES servicos (id) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;