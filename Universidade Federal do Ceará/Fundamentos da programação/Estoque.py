#Variaveis globais:
programaInicido = True
usuarioLogado = False

#Serviços:
#======================================================================
def limparConsole():
    for i in range (9):
        print("\n")
#======================================================================
def cadastrar():
    usuarioArquivo = open("Usuarios.txt", "a")
    limparConsole()
    print("=================CADASTRAR=================")
    loginCadastro = str(input('Crie seu usuário: '))
    senhaCadastro = str(input('Crie sua senha: '))
    usuarioArquivo.write (loginCadastro +";"+ senhaCadastro+"\n")
    usuarioArquivo.close()
    limparConsole()
    print("===========================================")
    print('Cadastro efetuado com sucesso!')
#======================================================================
def logar():

    loginTentativa = str(input('Digite seu usuário: '))
    senhaTentativa = str(input('Digite sua senha: '))
    loginEsenha = loginTentativa + ";" + senhaTentativa+"\n"

    usuarioArquivo = open("Usuarios.txt", "r")

    for linha in usuarioArquivo:
        if linha == loginEsenha:
            usuarioArquivo.close()
            return True

    limparConsole()
    print("============================================")
    print("ERROR:")
    print("Login ou Senha incorretos! Tente novamente!")
    print("============================================")
    return False
#======================================================================
def casdastrarProduto():
    limparConsole()
    produtoArquivo = open("Produtos.txt", "a")
    print("=============CADASTRAR=PRODUTO=============")
    id = obterID() 
    codigoBarra = str(input('Digite o código de barra do produto: '))
    nome = str(input('Digite o nome do produto: ')) 
    marca = str(input('Digite o nome da marca: '))
    quantidade = 0
    produtoCadastro ="ID: " + str(id) + "\n" + "CODIGO DE BARRAS: " + codigoBarra + "\n" + "NOME: "+ nome + " MARCA: " + marca + "\n" + "QUANTIDADE: " + str(quantidade) + "\n"
    produtoArquivo.write (produtoCadastro)
    produtoArquivo.close()
#======================================================================
def obterID():

    produtoArquivo = open("Produtos.txt", "r")
    ids = []

    for linha in produtoArquivo:
        if linha[:3] == "ID:":
            ids.append(int(linha[4:-1]))

    produtoArquivo.close()

    novoId = 1
    while True:
        if novoId not in ids:
            return novoId
        novoId = novoId + 1
#======================================================================
def quantidadeArmazenada(nomeArquivo):

    Arquivo = open(nomeArquivo, "r")

    if(nomeArquivo == "Produtos.txt"): #Para seguir a lógica do armazenamento dos produtos!
            
            ids = []
            for linha in Arquivo:
                if linha[:3] == "ID:":
                    ids.append(int(linha[4:-1]))

            return len(ids)
    else:
        quantidadeLinhasAcumulador = 1
        for linha in Arquivo:
            if linha == "":
                break
            else:
                quantidadeLinhasAcumulador = quantidadeLinhasAcumulador + 1

        return quantidadeLinhasAcumulador
#======================================================================
def quantidadeAtualProduto(LinhaIndex):
    produtoArquivoQuantidade = open("Produtos.txt", "r")
    Linhas = produtoArquivoQuantidade.readlines()
    quantidadeProdutoAtual = Linhas[LinhaIndex] #Pegando a linha
    quantidadeProdutoAtual = int(quantidadeProdutoAtual[12:-1]) #Formatando a linha
    produtoArquivoQuantidade.close()

    return quantidadeProdutoAtual
#======================================================================
def pesquisarProduto():
    limparConsole()
    produtoArquivo = open("Produtos.txt", "r")
    print("Pesquise o produto:")
    pesquisar = str(input("Codigo de barra ou id do produto: "))
    pesquisarID = "ID: " + pesquisar + "\n"
    pesquisarCodigoBarra ="CODIGO DE BARRAS: " + pesquisar + "\n"
    
    quantidadeLinhasAcumulador = 0 #Para ajustar os idex!
    for linha in produtoArquivo:

        if pesquisarID == linha:
            produtoArquivo.close() #TESTE
            return "id", quantidadeLinhasAcumulador

        if pesquisarCodigoBarra == linha:
            produtoArquivo.close() #TESTE
            return "Codigo Barra", quantidadeLinhasAcumulador

        quantidadeLinhasAcumulador = quantidadeLinhasAcumulador + 1

    produtoArquivo.close()
    return False #Produto nao encontrado!
#======================================================================
def imprimirProduto():

    linhasPesquisa = pesquisarProduto()
        
    if(linhasPesquisa == False): #Tratando caso digite errado!
        limparConsole()
        print("=============================================")
        print("Produto nao encontrado!")
        print("ID ou Codigo de Barras incorreto!")
        print("=============================================")
        escolhaUsuario = str(input('Voltar (1): '))
        if(escolhaUsuario == "1"):
            return
        else:
            return 

    produtoArquivo = open("Produtos.txt", "r")
    Linhas = produtoArquivo.readlines()

    if(linhasPesquisa[0] == "id"):
        limparConsole()
        print("=============================================")
        print(Linhas[(linhasPesquisa[1])], end="")
        print(Linhas[(linhasPesquisa[1] + 1)], end="")
        print(Linhas[(linhasPesquisa[1] + 2)], end="")
        print(Linhas[(linhasPesquisa[1] + 3)], end="")
        print("=============================================")
        escolhaUsuario = str(input('Voltar (1): '))
        if(escolhaUsuario == "1"):
            return
        else:
            return

    if(linhasPesquisa[0] == "Codigo Barra"):
        limparConsole()
        print("=============================================")
        print(Linhas[(linhasPesquisa[1] - 1)], end="")
        print(Linhas[(linhasPesquisa[1])], end="")
        print(Linhas[(linhasPesquisa[1] + 1)], end="")
        print(Linhas[(linhasPesquisa[1] + 2)],end="")
        print("=============================================")
        escolhaUsuario = str(input('Voltar (1): '))
        if(escolhaUsuario == "1"):
            return
        else:
            return
#======================================================================
def adicionarProduto():

        #Chama pesquisarProduto e armazena como foi pesquisado e a linha que foi encontrada!
            #linhasPesquisa[0] = "Codigo Barra" ou "id"
            #linhasPesquisa[1] = int Linha que o produto foi encontrado!
        linhasPesquisa = pesquisarProduto()

        if(linhasPesquisa == False): #Tratando caso digite errado!
            limparConsole()
            print("=============================================")
            print("Produto nao encontrado!")
            print("ID ou Codigo de Barras incorreto!")
            print("=============================================")
            escolhaUsuario = str(input('Voltar (1): '))
            if(escolhaUsuario == "1"):
                return
            else:
                return
        
        quantidade = int(input("Quantas unidades você deseja adicionar? "))

        #Ajustando o pulo de linhas com if!
        linhaQuantidade = 0
        if(linhasPesquisa[0] == "id"):
            linhaQuantidade = (linhasPesquisa[1] + 3)
        if(linhasPesquisa[0] == "Codigo Barra"):
            linhaQuantidade = (linhasPesquisa[1] + 2)

        produtoArquivoEditar = open("Produtos.txt", "r")
        Linhas = produtoArquivoEditar.readlines() #Armazena todas as linhas escritas!

        #Chama quantidadeAtualProduto(passando a linha ja ajustada) e soma com a quantidade que deseja adicionar!
        totalQuantidade = quantidadeAtualProduto(linhaQuantidade) + quantidade

        Linhas[linhaQuantidade] = "QUANTIDADE: " + str(totalQuantidade) + "\n" #Reescreve a linha com a nova quantidade!
        ReescreverArquivo = open("Produtos.txt", "w") #Apaga todo conteúdo desatualizado!
        ReescreverArquivo.writelines(Linhas) #Escreve todas as linhas com o conteúdo atualizado!
        produtoArquivoEditar.close()
        ReescreverArquivo.close()
#======================================================================
def removerProduto():

    linhasPesquisa = pesquisarProduto()

    if(linhasPesquisa == False):
        limparConsole()
        print("=============================================")
        print("Produto nao encontrado!")
        print("ID ou Codigo de Barras incorreto!")
        print("=============================================")
        input("Voltar (1): ")
        return

    produtoArquivo = open("Produtos.txt", "r")
    Linhas = produtoArquivo.readlines()
    produtoArquivo.close()

    # Descobrir onde começa o produto
    inicio = 0
    if(linhasPesquisa[0] == "id"):
        inicio = linhasPesquisa[1]
    if(linhasPesquisa[0] == "Codigo Barra"):
        inicio = linhasPesquisa[1] - 1

    fim = inicio + 4  # cada produto tem 4 linhas

    limparConsole()
    print("=============================================")
    print("Produto encontrado:")
    print(Linhas[inicio], end="")
    print(Linhas[inicio+1], end="")
    print(Linhas[inicio+2], end="")
    print(Linhas[inicio+3], end="")
    print("=============================================")

    confirmacao = str(input("Deseja remover este produto? (1 = Sim / 2 = Nao): "))

    if(confirmacao == "1"):
        del Linhas[inicio:fim]

        reescrever = open("Produtos.txt", "w")
        reescrever.writelines(Linhas)
        reescrever.close()

        print("=============================================")
        print("Produto removido com sucesso!")
        print("=============================================")
        input("Voltar (1): ")

    if(confirmacao == "2"):
        return
    else:
        return
#======================================================================
def listarProdutos():

    produtoArquivo = open("Produtos.txt", "r")
    Linhas = produtoArquivo.readlines()
    produtoArquivo.close()

    Acumulador = 0
    while(True):

        if(Acumulador == len(Linhas)):
            print("=============================================")
            print("Total de produtos cadastrados:")
            print(str(quantidadeArmazenada("Produtos.txt")))
            print("=============================================")
            input("Voltar (1): ")
            return
        
        print("=============================================")
        print(Linhas[Acumulador], end="")
        print(Linhas[Acumulador + 1], end="")
        print(Linhas[Acumulador + 2], end="")
        print(Linhas[Acumulador + 3], end="")
        print("=============================================")

        Acumulador = Acumulador + 4
#======================================================================

while programaInicido: #"Sistema" do software

    if(usuarioLogado == False):
        print("============================================")
        print("O que você deseja realizar:")
        print("============================================")
        escolhaUsuario = str(input('Cadastrar (1) Login (2): '))
        if(escolhaUsuario == "1"):
            cadastrar()
        elif(escolhaUsuario == "2"):
            usuarioLogado = logar()
        else:
            limparConsole()
            print("ERROR")
            print("Escolha apenas Cadastrar (1) ou Login (2)")
    elif(usuarioLogado == True):
        limparConsole()
        print("====================MENU====================")
        print("Cadastrar produto   (1)")
        print("Adicionar produto   (2)")
        print("Remover produto     (3)")
        print("Pesquisar produto   (4)")
        print("Listar produtos     (5)")
        print("Deslogar            (6)")
        print("===========================================")
        print("O que você deseja realizar:")
        print("===========================================")
        escolhaUsuario = int(input())
        
        if escolhaUsuario == 1:
            casdastrarProduto()

        if escolhaUsuario == 2:
            adicionarProduto()

        if escolhaUsuario == 3:
            removerProduto()

        if escolhaUsuario == 4:
            imprimirProduto()

        if escolhaUsuario == 5:
            listarProdutos()

        if escolhaUsuario == 6:
            limparConsole()
            usuarioLogado = False

        
            
       
