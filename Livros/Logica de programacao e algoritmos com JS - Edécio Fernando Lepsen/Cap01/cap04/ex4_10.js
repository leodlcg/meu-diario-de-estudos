const frm = document.querySelector("form")
const resposta = document.querySelector("h3")


frm.addEventListener("submit", (e) => {

    e.preventDefault()

    const LadoA = Number(frm.inLadoA.value)
    const LadoB = Number(frm.inLadoB.value)
    const LadoC = Number(frm.inLadoC.value)

    if((LadoA + LadoB) < LadoC || (LadoA + LadoC < LadoB) || (LadoB + LadoC) < LadoA){
        resposta.innerText = `Nao e possivel formar um triangulo`
        return
    }else if(LadoA ===  LadoB && LadoA == LadoC){
        resposta.innerText = `Pode formar um triangulo Equilatero.`
        return
    }else if(LadoA === LadoB || LadoC === LadoB || LadoC === LadoA) {
        resposta.innerText = `Pode formar um triangulo Isosceles.`
        return
    }else{
        resposta.innerText = `Pode formar um triangulo Escaleno.`
    }

})