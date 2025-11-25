
//Controle:
let JogoIniciado = false;



    //Define de maneira aletoria a quantidade de inimigos de Nivel Facil!
    const inimigosFacil = [];
    for(i = 0; i < Math.floor(Math.random() * 10) + 1; i++){ //Quantidade sendo min 1 max 10 
        inimigosFacil.push(new InimigoFacil())//TESTAR PARA VER SE CONSTROI SEM PASSAR OS DADOS!
    }


    const HeroiTeste = new Heroi("Bernardinho", 500, 3, 1, 0)
    //CRIAR O CRIAR ALEATORIO DOS OBJETOS INIMIGOS!!!



function ChamarInimigo(InimigosEliminados){
        inimigosFacil[InimigosEliminados].movimentacao;
        inimigosFacil[InimigosEliminados].ataqueBasico;

}




document.addEventListener("keydown", ApertouTecla => {

    if(ApertouTecla.key == "Enter" && JogoIniciado == false){ //Inica o jogo!
            inimigosFacil[0].movimentacao();
            inimigosFacil[0].lancamentoAtaques();
            JogoIniciado = true;
    }

    if(ApertouTecla.key.charCodeAt(0) >= 97 && ApertouTecla.key.charCodeAt(0) <= 90 || ApertouTecla.key.charCodeAt(0) >= 65 && ApertouTecla.key.charCodeAt(0)){ //Verificando se apertou de a - z de acordo com a tabela ASCII! 
    // Metodo charCodeAt() pega a String e verifica de acordo com a numero na ASCII! charCodeAt(0) -> 0 Porque queremos a primeira Letra da String!
        HeroiTeste.ataque(ApertouTecla.key.toLowerCase().charCodeAt(0));
    }
})
















