create database controle_de_estoque2;
use controle_de_estoque2;
-- drop database controle_de_estoque2;
--
-- Estrutura para tabela `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nome` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `categoria`
--

INSERT INTO `categoria` (`id`, `nome`) VALUES
(11, 'Informatica'),
(12, 'Roupas'),
(13, 'Calcados'),
(14, 'Outros');

-- --------------------------------------------------------

--
-- Estrutura para tabela `produto`
--

CREATE TABLE `produto` (
  `id` int(11) NOT NULL,
  `nome` text NOT NULL,
  `quantidade` int(11) NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  `id_categoria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `produto`
--

INSERT INTO `produto` (`id`, `nome`, `quantidade`, `preco`, `id_categoria`) VALUES
(633, 'CPU', 1, 1.00, 11),
(634, 'Teclado', 1, 1.00, 11),
(635, 'Mouse', 1, 1.00, 11),
(636, 'Camisa', 1, 1.00, 12),
(638, 'Nike', 1, 1.00, 13),
(1144, 'Python Test', 123, 123.99, NULL),
(1145, 'Teste aula', 123, 111.99, NULL);

-- --------------------------------------------------------

--
-- Estrutura stand-in para view `testerelatorio`
-- (Veja abaixo para a visão atual)
--
CREATE TABLE `testerelatorio` (
`contIDcat` bigint(21)
,`categoria` text
);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_categoria` (`id_categoria`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1150;

-- --------------------------------------------------------

--
-- Estrutura para view `testerelatorio`
--
DROP TABLE IF EXISTS `testerelatorio`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `testerelatorio`  AS SELECT count(`c`.`id`) AS `contIDcat`, `c`.`nome` AS `categoria` FROM (`produto` `p` join `categoria` `c` on(`p`.`id_categoria` = `c`.`id`)) GROUP BY `c`.`id` ORDER BY count(`c`.`id`) DESC ;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `fk_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`);
COMMIT;
