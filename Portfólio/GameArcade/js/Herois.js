class Heroi{

constructor(nome, vida, dano, quantidadeTarget){
    this.nome = nome;
    this.vida = vida;
    this.dano = dano;
    this.quantidadeTarget = quantidadeTarget;
    this.InimigosEliminados = 0;
}

//FALTA FAZER UM SISTEMA PARA O INIMIGO E O HEROI TOMAREM DANO E MORREREM!!! Assim podendo vir outros inimigos!!!
ataque(TeclaApertada){
    const timerHitBox = setInterval(() => {
        //FOR PARA FAZER A COLISAO ENTRE OS ATAQUES E OS TARGETS APERTADOS CORRETAMENTE!!!
        for(let i = 0; i < inimigosFacil[this.InimigosEliminados].ArrayAtaqueTecla.length; i++){
            if(this.colisao(document.getElementById(`imgAtaque0${i + 1}`), document.getElementById(`imgTarGet0${(i + 1) > HeroiTeste.quantidadeTarget ? 1 : (i + 1)}`)) && TeclaApertada == inimigosFacil[this.InimigosEliminados].ArrayAtaqueTecla[i]){
                document.getElementById(`imgAtaque0${i + 1}`).style.visibility = "hidden";
                document.getElementById(`imgAtaque0${i + 1}`).classList.remove(`animacaoInimigoAtaque0${i + 1}Facil`);
                console.log("a")
            }
        clearInterval(timerHitBox);
        }
    }, 16); // 16 = Aproximadamente 60 fps

}

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