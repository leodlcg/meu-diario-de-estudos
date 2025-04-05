const prompt = require("prompt-sync")()
const carro = Number(prompt("Qual o modelo do carro?"))
const valor = Number(prompt("Qual o valor do carro?"))
const entrada = valor / 2
const parcela = entrada / 12
console.log(`Carro: ${carro} entrada: ${entrada} 12x ${parcela.toFixed(2)}`)