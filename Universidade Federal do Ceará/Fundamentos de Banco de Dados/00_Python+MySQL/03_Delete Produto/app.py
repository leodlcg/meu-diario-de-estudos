import mysql.connector

mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  password="1234",
  database="controle_de_estoque"
)

###

mycursor = mydb.cursor()

mycursor.execute("SELECT * FROM produto")

myresult = mycursor.fetchall()

for x in myresult:
    print(x)

###

id = input('Digite um ID para deletar: ')
id = int(id)

mycursor = mydb.cursor()

sql = "DELETE FROM produto WHERE id = %s"
val = (id,)
mycursor.execute(sql, val)

mydb.commit()

print(mycursor.rowcount, "record(s) deleted")
if mycursor.rowcount != 0:
    print("produto id: ", id, "deleted")
else:
    pass