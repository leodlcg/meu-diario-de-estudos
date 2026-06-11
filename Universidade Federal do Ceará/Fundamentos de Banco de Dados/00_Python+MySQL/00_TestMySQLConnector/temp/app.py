import mysql.connector

mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  password="12345"
)

# Exibe a comunicação com o banco de dados
print(mydb)

mycursor = mydb.cursor()

mycursor.execute("SHOW DATABASES")

for x in mycursor:
    print(x)
