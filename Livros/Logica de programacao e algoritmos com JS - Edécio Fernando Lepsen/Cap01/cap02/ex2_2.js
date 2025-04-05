const frm = document.querySelector("form")
const titulo = document.querySelector("h3")
const horas = document.querySelector("h4")

frm.addEventListener("submit", (e) => {
    const titulo2 = frm.inTitulo.value
    const duracao = Number(frm.inDuracao.value)
    titulo.innerText = `Seu filme e ${titulo2}`

    horasResposta = Math.floor(duracao / 60)
    minutosReposta = horasResposta % 60
    horas.innerText = `Seu filme tera ${horasResposta}h e ${minutosReposta}m`
    e.preventDefault()
})