const frm = document.querySelector("form")
const respostaModelo = document.querySelector("h3")
const respostaValor = document.querySelector("h4")

frm.addEventListener("submit", (e) => {
    const modelo = frm.inModelo.value
    const valor = Number(frm.inValor.value)
    respostaModelo.innerText = `Seu modelo de carro e ${modelo}`
    respostaValor.innerText = `Valor da entrada ${valor/2} com 12 parcelas de ${((valor/2) / 12).toFixed(2)}`
    e.preventDefault()
})