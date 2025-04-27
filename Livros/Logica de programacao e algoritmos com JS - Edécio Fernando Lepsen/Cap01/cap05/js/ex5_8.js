const frm = document.querySelector("form")
const resp = document.querySelector("h3")


frm.addEventListener("submit", (e) => {
    e.preventDefault()
    const fruta = frm.inFruta.value
    const numero = Number(frm.inNumero.value)
    let contagem = ""


    for(let i = 1;i < numero;i++){
        contagem = contagem + fruta + "*"
    }

    contagem = contagem + fruta
    resp.innerText = contagem

})