const frm = document.querySelector("form")
const resp = document.querySelector("h3")


frm.addEventListener("submit", (e) => {
    e.preventDefault() //Evita o envio do form

    const nome = frm.inNome.value //Obtem os valores do form de acordo com o id
    const masculino = frm.inMasculino.checked
    const altura = Number(frm.inAltura.value)

    let peso

    if(masculino == true) {
        peso = 22 * Math.pow(altura, 2)
    } else{
      peso = 21 * Math.pow(altura, 2)  
    }


    resp.innerText = `${nome} Seu peso ideal e ${peso.toFixed(2)}kg`
})



frm.addEventListener("reset", () =>{
    resp.innerText = ""
})