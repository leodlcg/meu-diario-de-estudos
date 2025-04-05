const frm = document.querySelector("form");
const resp = document.querySelector("h2");
const resp2 = document.querySelector("h3");
const resp3 = document.querySelector("h4");

frm.addEventListener("submit", (e) => {
    e.preventDefault();
    
    let valor = Number(frm.inValor.value);
    let cem = 0, cinquenta = 0, dez = 0;

    function calcularNotas(valor) {
        if (valor >= 100) {
            cem = cem + 1;
            return calcularNotas(valor - 100);
        } else if (valor >= 50) {
            cinquenta = cinquenta + 1;
            return calcularNotas(valor - 50);
        } else if (valor >= 10) {
            dez = dez + 1;
            return calcularNotas(valor - 10);
        } else if (valor !== 0) {
            resp.innerText = "Não há notas suficientes.";
            return;
        }

        resp.innerText = `Notas de cem: ${cem}`;
        resp2.innerText = `Notas de cinquenta: ${cinquenta}`;
        resp3.innerText = `Notas de dez: ${dez}`;
    }

    calcularNotas(valor);
});
