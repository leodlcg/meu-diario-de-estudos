const frm = document.querySelector("form")
const tempo = document.querySelector("h3")
const troco = document.querySelector("h4")


frm.addEventListener("submit", (e) => {

    const valor = Number(frm.inValor.value)

    e.preventDefault()

    if(valor < 1){
        tempo.innerText = ("Valor muito baixo!")
        return
    }else if(valor === 1){ 
        tempo.innerText = ("Tempo: 30 min")
        troco.innerText = ("Troco: R$0")
        return
    }else if(valor > 1 && valor < 1.75){
        tempo.innerText = ("Tempo: 30 min")
        troco.innerText = (`Troco: R$${(valor - 1).toFixed(2)}`)
        return
    }else if (valor >= 1.75 && valor < 3){
        tempo.innerText = ("Tempo: 60 min")
        troco.innerText = (`Troco: R$${(valor - 1.75).toFixed(2)}`)
        return
    }else{
        tempo.innerText = ("Tempo: 120 min")
        troco.innerText = (`Troco: R$${(valor - 3).toFixed(2)}`)
    }
})