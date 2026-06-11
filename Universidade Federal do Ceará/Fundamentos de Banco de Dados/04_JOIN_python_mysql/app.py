import mysql.connector

mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  password="1234",
  database="controle_de_estoque"
)

mycursor = mydb.cursor()
mycursor.execute("select count(c.id) as contIDcat, c.nome from produto as p join categoria as c on p.id_categoria = c.id group by c.id order by contIDcat desc limit 3;")
myresult = mycursor.fetchall()

for x in myresult:
    print(x)