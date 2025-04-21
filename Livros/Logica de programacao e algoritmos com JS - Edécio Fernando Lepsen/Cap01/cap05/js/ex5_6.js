const frm = document.querySelector("form")
const resp = document.querySelector("h3")


frm.addEventListener("submit", (e) => {

    e.preventDefault()

    const num = Number(frm.inNumero.value)

    let temDivisor = false //Variavel flag

    for (let i = 2; i <=num / 2; i++){
        if (num % i == 0) {
            temDivisor = true
            break
        }
    }

    if (num > 1 && !temDivisor){
        resp.innerText = `${num} E primo`
    }else {
        resp.innerText = `${num} Nao e primo`
    }

})