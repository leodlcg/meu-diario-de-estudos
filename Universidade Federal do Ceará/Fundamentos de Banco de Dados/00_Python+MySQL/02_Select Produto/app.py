import mysql.connector

mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  password="1234",
  database="controle_de_estoque"
)

mycursor = mydb.cursor()
mycursor.execute("SELECT * FROM produto")
myresult = mycursor.fetchall()

for x in myresult:
    print(x)