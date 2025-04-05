const frm = document.querySelector("form")
const resposta = document.querySelector("h3")

frm.addEventListener("submit", (e) => {
    const valorKG = Number(frm.Kg.value)
    const consumoG = Number(frm.Valor.value)
    resposta.innerText = `Voce deve pagar R$${((valorKG/1000)* consumoG).toFixed(1)}`
    e.preventDefault()
})