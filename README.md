# Java_Persistence_API
##Atividade desenvolvida academicamente sobre Java Persistence API.


Atividade prática - Java Persistence API
O objetivo dessa atividade é permitir a aplicação os conceitos sobre JPA, em umcenário prático. Ao final da atividade os seguintes tópicos terão sido trabalhados: </br>
• Mapeamento Objeto Relacional;
• Mapeamento das Entidades;
• Mapeamento dos relacionamentos;
• Contexto de Persistência;
• Gerenciador de Entidades e ciclo de vidas de entidades;
• Linguagem de Consulta em JPA.
O que implementar
Considere o Banco de Dados Universidade (os arquivos DDL e DML estão no moodle). Você implementará
um cenário de persistencia completo, desde o mapeamento de entidades/tabelas até interfaces para
manipulação de dados.
Prof. Dr. Eduardo Pena TSI 34A
Avaliação
Pontos Item Descrição
2.0 Anotações de entidades
Todas as tabelas devem ser mapeadas integralmente
para a aplicação. Na aplicação, utilize os mesmo
nomes de atributos vistos no DDL. Não esqueça de
mapear as chaves primárias compostas.
2.0 Mapeamento de
Relacionamentos • Todos relacionamentos devem ser mapeados no
modo bi-direcional.
• Utilizar as tabelas de junção do MR original
(veja @JoinColumn).
• Utilize coleções.
• Configure os cascateamentos (Cascades).
2.0 Entity Manager
• Manutenção e gerenciamento do Contexto de
Persistência.
• Estabelecer o CRUD de todas as entidades.
Importante: As depêndencias entre objetos
devem ser configuradas.
• Manter a sincronia do CRUD com o banco de
dados.
3.0 JPQL Implementar as consultas da página a diante da seguinte
forma:
• Escolha 2 e utilize dinamic query.
• Escolha 5 e utilize named query.
• Escolha 3 e utilize expressões de construtor
(SELECT NEW).
• Implemente as demais da maneira que achar
mais adequado.
Entregáveis e avaliação
Abaixo a pontuação (máxima) de cada um dos itens a serem entregues.
Página 4 de 5
Prof. Dr. Eduardo Pena TSI 34A
• Fonte, executáveis e readme explicando exatamente como executar o projeto (como compilar,
configurar o bd, etc. Preferência por projeto configurado no Eclipse e Maven. (0.25
pontos)
• Interface para acesso ao sistema (0.75 pontos) : Console, Web, Mobile ou GUI.
• Itens da tabela (9 pontos)
* Será feita uma pequena arguição sobre o projeto. Todos devem ter participado igualmente nas atividades.
Dessa forma, todos apresentam e demonstram o conhecimento adquirido ao longo da atividade.
Equipe
Até 3 alunos;
Consultas
1. Encontre todos os pedidos relacionados a um produto que tenha preço maior que $_____.
2. Mostre-me todos os dados na tabela escritórios (offices).
3. Liste os escritórios com os seus objetivos(targets) e as vendas reais(sales).
4. Listar os nomes, escritórios e datas de contratação de todos os vendedores.
5. Quais são as quotas totais e vendas totais para todos os vendedores?
6. Encontrar vendedores que estão abaixo da quota e com vendas abaixo de $ 300,000.
7. Calcule o preço médio dos produtos do fabricante ACI.
8. Qual a data do pedido mais antigo no banco de dados?
9. Quantos vendedores estão acima da cota?
10. Liste todos os clientes atendidos por Bill Adams.
11. Liste todos os produtos do fabricante ACI onde a quantidade disponível está acima da quantidade
disponível de produto ACI-41004.
12. Liste cada vendedor, cidade e região onde trabalham.
13. Liste os escritórios com um target maior que $ 600000 e as informações do seu gerente.
14. A tabela ORDERS e a tabela Products estão relacionadas por um chave estrangeira composta. Liste
todas os pedidos, mostrando valores e descrições do produto.
15. Liste os pedidos acima de $ 25.000, incluindo o nome do vendedor que tomou o pedido e o nome do o
cliente que fez o pedido.
Página
