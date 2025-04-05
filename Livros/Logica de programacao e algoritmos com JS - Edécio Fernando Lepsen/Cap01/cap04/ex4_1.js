const frm = document.querySelector("form")
const resp1 = document.querySelector("h3")
const resp2 = document.querySelector("h4")


frm.addEventListener("submit", (e) => {
    e.preventDefault() //Evita o envio do form
    const nome = frm.inNome.value //Obtem os valores do form de acordo com o id
    const nota1 = Number(frm.inNota1.value)
    const nota2 = Number(frm.inNota2.value)
    const media = (nota1 + nota2) / 2

    if(media >= 7) {
        resp2.innerText = `Parabens ${nome}! Voce foi aprovado(a)`
        resp2.style.color = "green"
    } else if (media >= 4){
        resp2.innerText = `${nome} voce esta de recuperacao!`
        resp2.style.color = "black"
    }else {
        resp2.innerText = `Ops ${nome}... Voce foi reprovado(a)`
        resp2.style.color = "red"
    }
})