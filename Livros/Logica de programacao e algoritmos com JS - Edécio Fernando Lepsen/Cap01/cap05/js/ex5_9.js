const frm = document.querySelector("form")
const resp = document.querySelector("h3")


frm.addEventListener("submit", (e) => {

    e.preventDefault()
    const chinchilas = Number(frm.inChinchilas.value)
    const anos = Number(frm.inAnos.value)
    let previsao = ""
    let numero = 2;
    let triplochinchilas = chinchilas



    for(let i = 1; i < anos; i++){

        triplochinchilas = triplochinchilas * 3
        previsao = previsao + numero + "°" + " Ano: " + triplochinchilas + " Chinchilas" + "\n"
        numero = numero + 1
    }

    previsao = 1 + "°" + " Ano: " + chinchilas + " Chinchilas" +"\n" + previsao
    resp.innerText = previsao
})