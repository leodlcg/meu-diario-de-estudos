const prompt = require("prompt-sync")()
const pessoas = Number(prompt("Numero de pessoas?"))
const peixes = Number(prompt("Numero de peixes?"))

let pagar = 0

if (peixes > pessoas){
    pagar = (pessoas * 20) + ((peixes - pessoas) * 12)
}else{
    pagar = pessoas * 20
}

console.log(`Voces devem pagar: R$${pagar}`)
