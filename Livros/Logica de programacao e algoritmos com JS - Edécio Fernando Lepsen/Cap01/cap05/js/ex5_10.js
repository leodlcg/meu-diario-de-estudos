const frm = document.querySelector("form")
const resp = document.querySelector("h3")


frm.addEventListener("submit", (e) => {

    e.preventDefault()
    const numero = Number(frm.inNumero.value)
    let i = 0
    let resultado = ""
    let soma = 0

    for (i; i < numero;i++){

        if(numero % i == 0){
            resultado = resultado + i
            soma = soma + i
        }
    }

    let chars = resultado.split("")
    let numeros = chars.slice(0, -2).concat(chars.slice(-2).join(""));
    let final;
    if (numeros.length > 1) {
    final = numeros.slice(0, -1).join(", ") + " e " + numeros[numeros.length - 1];
    } else {
    final = numeros[0];
    }

    if(soma == numero){
        resultado = "O número " + numero + " é perfeito pois seus divisores são: \n" + final + ` Soma (${soma})`
    }else(
        resultado = "O número não é perfeito :("
    )

    resp.innerText = resultado

})