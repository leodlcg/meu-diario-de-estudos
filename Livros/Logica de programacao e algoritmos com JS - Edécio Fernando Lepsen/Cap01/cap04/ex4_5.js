const frm = document.querySelector("form")
const resposta = document.querySelector("h3")

frm.addEventListener("submit", (e) => {
    e.preventDefault()
    const numero = Number(frm.inNumero.value)
    const raiz = Math.sqrt(numero)
    if ((raiz % 1) !== 0){
        resposta.innerText = `Seu numero nao tem raiz exata!!!`
    }else{
        resposta.innerText = `A raiz do seu numero e ${raiz}`
    }


})