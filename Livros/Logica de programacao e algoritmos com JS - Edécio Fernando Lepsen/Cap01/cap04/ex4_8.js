const frm = document.querySelector("form")
const resp = document.querySelector("h3")



frm.addEventListener("submit", (e) => {

    e.preventDefault()

    const velocidadeMax = Number(frm.inVelocidadePermitida.value)
    const velocidadeCondutor = Number(frm.inVelocidadeCondutor.value)
    const velocidadeMax20 = (((velocidadeMax * 20)/ 100) + velocidadeMax)


    if (velocidadeCondutor <= velocidadeMax){
        resp.innerText = ("Sem Multa.")
        return
    }else if (velocidadeCondutor <= velocidadeMax20) {
        resp.innerText = ("Multa leve.")
        return
    }else{
        resp.innerText = ("Multa grave.")
    }
})