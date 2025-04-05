const prompt = require("prompt-sync")() // adiciona o pacote ao programa
const racao = Number(prompt("Racao em kg: "))
const consumo = Number(prompt("Consumo do gato em gramas por dia: "))
const dias = Math.floor((racao * 1000) / consumo)
const sobra = (((racao * 1000) - (consumo * dias)))
console.log(`Sua racao ira durar ${dias} dias e sobram ${sobra} gramas de racao`)