import mysql.connector

conexao = mysql.connector.connect(
  host="localhost",
  user="root",
  password="1234",
  database="controle_de_estoque"
)

conexao.autocommit = True  # Salva tudo automaticamente

cursor = conexao.cursor()

# Maneira INSEGURA - Vulnerável a SQL Injection
# sql = f"INSERT INTO produto VALUES ('Python Test', 123.99, 123);"

# Este comando protege contra SQL Injection porque ele utiliza parametrização
# Força o banco de dados a tratar os valores estritamente como dados, e nunca como comandos executáveis.
sql = "INSERT INTO produto (nome, preco, quantidade) VALUES (%s, %s, %s);"
val = ('Teste aula', 111.99, 123)
cursor.execute(sql, val)

conexao.commit()

print(cursor.rowcount, "record inserted.")
print("Last ID:", cursor.lastrowid)
