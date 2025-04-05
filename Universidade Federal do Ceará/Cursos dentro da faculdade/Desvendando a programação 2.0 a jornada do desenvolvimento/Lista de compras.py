'''

                            Online Python Compiler.
                Code, Compile, Run and Debug python program online.
Write your code in this editor and press "Run" button to execute it.

'''
import os


#Descrição do Desafio 3 - Difícil: Lista de Compras

#Neste desafio, o objetivo é desenvolver um sistema de lista de compras em Python, permitindo ao usuário adicionar itens com nome e valor, listar todos os itens registrados e sair do sistema. Este exercício vai além dos desafios anteriores ao envolver o uso de listas para armazenar dados complexos e operações de interação mais sofisticadas com o usuário.

#O programa deverá oferecer as seguintes opções no menu:

#[1] Adicionar Item: O usuário pode inserir um nome e valor para o item, que será adicionado à lista de compras.
#[2] Listar Itens: O sistema exibe todos os itens adicionados à lista, incluindo seus respectivos nomes e valores. Caso a lista esteja vazia, o sistema deve informar isso ao usuário.
#[0] Sair do Sistema: Permite que o usuário saia do sistema de lista de compras.

#Requisitos:
#Armazenamento dos Itens: Cada item da lista será representado por um nome e um valor, armazenados em listas dentro de uma lista principal (itens).
#Contagem de Itens: O sistema mantém um contador de quantos itens foram inseridos para facilitar a listagem.
#Estrutura de Dados: O sistema utiliza listas para armazenar informações de cada item, sendo necessário utilizar operações como append e for para manipular e exibir os dados.

lista_de_compras = []
total_lista = 0

while True:
    print("=================================================================")
    print("[1] Cadastrar um produto")
    print("[2] Listar produtos cadastrados")
    print("[0] Sair")
    print("=================================================================")
    menu = input("O que deseja fazer? ")

    if menu not in ["1", "2", "0"]:
        print("Você não digitou um número do menu :(")
    elif (menu == "1"):
        print("=================================================================")
        print("[Confirmação]")
        print("SIM [0] I NÃO [1]")
        confirmar = input("Deseja mesmo cadastrar? ")
        if confirmar == "0":
            print("=================================================================")
            print("[1] Cadastrar um produto")
            itens = input("Qual produto deseja adicionar? ")
            valor = input("Qual o valor do produto? ")
            if valor.isalpha():
                print("=================================================================")
                print("ERROR - Produto não cadastrado")
                print("O valor deve ser um número!!!")
                print("Voltando ao menu...")
            else:
                lista_de_compras.append([itens, valor])
                total_lista = total_lista + 1
                print("=================================================================")
                print("Produto cadastrado com sucesso!!!")
                print("=================================================================")
                menu = input("O que deseja fazer agora?\n[0] Voltar ao menu.\n")
        elif confirmar == "1":
            print("=================================================================")
            print("Voltando ao menu...")
            menu = ""
        else:
            print("=================================================================")
            print("Você não digitou o número correto. Voltando ao menu...")
    elif (menu == "2"):
        print("=================================================================")
        print("[2] Lista de produtos cadastrados:")
        if lista_de_compras == []:
            print("Sua lista está vazia :(")
            print("=================================================================")
        else:
            print("Aqui está sua lista de produtos:")
            print(lista_de_compras)
            print(f"Você tem {total_lista} produtos cadastrados!")
            print("=================================================================")
        menu = input("O que deseja fazer?\n[0] Voltar ao menu.\n")
    elif(menu == "0"):
        print("=================================================================")
        print("Deseja mesmo sair? Toda lista será perdida...")
        print("SIM [0] I NÃO [1]")
        sair = input("Você deseja mesmo sair? ")
        if sair == "0":
            break
        elif sair == "1":
            print("=================================================================")
            print("Voltando ao menu...")
            menu = ""
        else:
            print("=================================================================")
            print("Você não digitou o número correto. Voltando ao menu...")




