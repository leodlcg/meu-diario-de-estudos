const frm = document.querySelector("form")
const resp = document.querySelector("h3")
const muda = document.querySelector("h1")

frm.addEventListener("submit", (e) => {
    const nome = frm.inNome.value
    muda.innerText = `Teste`
    resp.innerText = `Ola ${nome}`
    e.preventDefault()
})