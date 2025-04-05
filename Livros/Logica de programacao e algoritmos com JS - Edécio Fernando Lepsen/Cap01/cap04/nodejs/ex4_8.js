const prompt = require("prompt-sync")()
const valor = Number(prompt("Qual valor da compra?"))

const aux = Math.floor(valor / 20)
const parcelas = aux == 0 ? 1 : aux > 6 ? 6 : aux
const valorParcela = valor / parcelas
console.log (`Valor da compra: R$${valor}. Voce pode pagar em ate ${parcelas} vezes, sendo R$${valorParcela.toFixed(2)} por parcela.`)