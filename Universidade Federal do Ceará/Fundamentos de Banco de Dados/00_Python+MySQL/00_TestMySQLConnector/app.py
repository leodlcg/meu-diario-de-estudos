import mysql.connector
from mysql.connector import Error

try:
    # 1. Estabelecer a conexão com o banco
    conexao = mysql.connector.connect(
        host='localhost',       # Endereço do servidor
        database='controle_de_estoque',   # Nome do banco de dados
        user='root',     # Usuário do MySQL
        password='12345'    # Senha do MySQL
    )

    if conexao.is_connected():
        print("Conexão estabelecida com sucesso!")

        # Exibe a comunicação com o banco de dados
        print(conexao)
        
        # 2. Criar um objeto cursor para executar comandos SQL
        cursor = conexao.cursor()
        
        # 3. Executar uma consulta de exemplo
        cursor.execute("SELECT VERSION();")
        versao = cursor.fetchone()
        print(f"Versão do servidor MySQL: {versao[0]}")

        #cursor = conexao.cursor()

        cursor.execute("SHOW DATABASES")

        for x in cursor:
            print(x)

except Error as e:
    print(f"Erro ao conectar ao MySQL: {e}")

finally:
    # 4. Garantir o fechamento das conexões
    if 'conexao' in locals() and conexao.is_connected():
        cursor.close()
        conexao.close()
        print("Conexão ao MySQL encerrada.")
