class Inimigo{

constructor(vida, dano, ArrayAtaqueTecla, velocidadeMovimento, ArrayvelocidadeAtaque){
        if (new.target === Inimigo) { //Protege para que nao seja possivel criar um objeto com a classe Inimigo! Vira uma classe "abstrata"!
            throw new Error("Inimigo é uma classe abstrata e não pode ser instanciada.");
        }
    
    // ?? 0 para poder criar os objetos sem passar parametros!
    this.vida = vida ?? 0;
    this.dano = dano ?? 0;
    this.ArrayAtaqueTecla = ArrayAtaqueTecla ?? [0];
    this.velocidadeMovimento = velocidadeMovimento ?? 0;
    this.ArrayvelocidadeAtaque = ArrayvelocidadeAtaque ?? [0];

    //Customizando nosso inimigo de maneira aleatoria:
    this.vida == 0 ? Math.floor(Math.random() * 3) + 1 : vida;

    this.dano == 0 ? 1 : dano;

    if(this.ArrayAtaqueTecla == 0){
        for(i = 0; i <= Math.floor(Math.random() * 4); i++){
            this.ArrayAtaqueTecla[i] = Math.floor(Math.random() * ((122 - 97 + 1)) + 97); //Armazenando um numero da tecla de ataque de acordo com a ASCII de a-z
            this.ArrayvelocidadeAtaque[i] = Math.floor(Math.random() * 3) + 1; //Armazena a velocidade que cada tecla do Array de cima deve ter!
        }
    
    }else{
       this.ArrayAtaqueTecla = ArrayAtaqueTecla;
    }

    this.velocidadeMovimento == 0 ? Math.floor(Math.random() * 3) + 1 : velocidadeMovimento;
}


movimentacao(){
    
        const timer = setInterval(() => {

            document.getElementById("imgInimigo").classList.add("animacaoInimigoMovendoFacil");
                document.getElementById("imgVidaInimigo01").classList.add("animacaoInimigoVidaFacil");
                document.getElementById("imgVidaInimigo02").classList.add("animacaoInimigoVidaFacil");
                document.getElementById("imgVidaInimigo03").classList.add("animacaoInimigoVidaFacil");


            if (this.colisao(document.getElementById("imgInimigo"), document.getElementById("imgHeroi"))) {
                console.log("Colisão com inimigo!");
                clearInterval(timer);
            }
            
            console.log(document.getElementById("imgInimigo").style.left);

        }, 16); // 16 = Aproximadamente 60 fps
}


lancamentoAtaques(){

//FALTA FAZER UM SISTEMA PARA O INIMIGO E O HEROI TOMAREM DANO E MORREREM!!! Assim podendo vir outros inimigos!!!
//TEMPO ENTRE OS ATAQUES DO INIMIGO:
    let i = 0;
    const timerAtaque = setInterval (() => {
        if(i < this.ArrayAtaqueTecla.length){
            document.getElementById(`imgAtaque0${i + 1}`).style.backgroundImage =`url("../imgs/inimigos/nivel01/Ataques/${this.ArrayAtaqueTecla[i]}.png")`;
            document.getElementById(`imgAtaque0${i + 1}`).classList.add(`animacaoInimigoAtaque0${i + 1}Facil`);
            document.getElementById(`imgAtaque0${i + 1}`).style.animationDuration = `${this.ArrayvelocidadeAtaque[i]}+s`; // MUDANDO A VELOCIDADE DE ATAQUE PARA CADA ATAQUE!!!
        }else{
            clearInterval(timerAtaque);
        }
        i++;
    }, Math.floor(Math.random() * ((3000 - 1000 + 1)) + 1000)) //Timer para tempo minino e maxima entre ataques!!!



    const timerHitBox = setInterval(() => {
        //FOR PARA FAZER A COLISAO ENTRE OS ATAQUES E O HEROI!!!
        for(let i = 0; i < this.ArrayAtaqueTecla.length; i++){
            if(this.colisao(document.getElementById(`imgAtaque0${i + 1}`), document.getElementById("imgHeroi"))){
                //IF PARA PARAR O LOOP DO TIMER QUANDO O ULTIMO ATAQUE DAR HIT!
                if(this.colisao(document.getElementById(`imgAtaque0${this.ArrayAtaqueTecla.length}`), document.getElementById("imgHeroi"))){
                    clearInterval(timerHitBox); 
                   }
                document.getElementById(`imgAtaque0${i + 1}`).style.visibility = "hidden";
                document.getElementById(`imgAtaque0${i + 1}`).classList.remove(`animacaoInimigoAtaque0${i + 1}Facil`);
                console.log("HIT NO HEROII!!!");
            }
        }
    }, 16); // 16 = Aproximadamente 60 fps

}

//METODO PARA FAZER O CALCULO DA COLISAO
colisao(a, b) {

    if(a == null || b == null){
        return false;
    }else{
        const A = a.getBoundingClientRect();
        const B = b.getBoundingClientRect();

        return !(
        A.right < B.left ||
        A.left > B.right ||
        A.bottom < B.top ||
        A.top > B.bottom
    );
    }
}
}