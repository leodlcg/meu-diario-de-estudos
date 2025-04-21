const prompt = require("prompt-sync")()
console.log(`Programa anos de copa do mundo. Digite 0 para sair`)
console.log(`--------------------------------------------------`)

do {
    const ano = Number(prompt("Ano: "))
    if (ano == 0) {
        break
    } else if (ano == 1942 || ano == 1946){
        console.log(`Nao houve copa em ${ano} (Segunda Guerra Mundial)`)
    } else if (ano >= 1930 && ano % 4 == 2) {
        console.log(`Sim! ${ano} e ano de Copa do Mundo!`)
    } else {
        console.log(`Nao... ${ano} nao e ano de Copa do Mundo`)
    }
} while(true)
