async function cadastrar() {

    const prenome = document.getElementById('prenome').value.trim();
    const sobrenome = document.getElementById('sobrenome').value.trim();
    const mensagem = document.getElementById('mensagem');
    const nucleos = coletarOpcoes();

    if (!prenome || !sobrenome) {
        mensagem.innerText = 'Preencha todos os campos obrigatórios';
        return;
    }

    try {

        const resposta = await fetch(
            'http://localhost:3000/voluntarios',
            {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    prenome,
                    sobrenome,
                    nucleos
                })
            }
        );

        const dados = await resposta.json();

        if (resposta.ok) {

            mensagem.innerText = `Voluntario cadastrado com ID ${dados.id}`;

            document.getElementById('prenome').value = '';
            document.getElementById('sobrenome').value = '';
            desmarcarTodos();
            location.reload();

        } else {

            mensagem.innerText = dados.erro || 'Erro ao cadastrar';
        }

    } catch (erro) {

        console.error(erro);

        mensagem.innerText = 'Não foi possível conectar ao servidor.';
    }
}

async function removerVoluntario(prenome, sobrenome) {
    try {
        const resposta = await fetch('http://localhost:3000/voluntarios', {
            method: 'DELETE',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ prenome, sobrenome })
        });

        const dados = await resposta.json();

        if (resposta.ok) {
            console.log(dados.mensagem);
             location.reload();
        } else {
            console.error(dados.erro);
        }

    } catch (erro) {
        console.error(erro);
    }
}


function coletarOpcoes() {
  const checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');
  const selecionados = Array.from(checkboxes).map(cb => cb.value).join('|');
  return selecionados;
}

function desmarcarTodos() {
    document.querySelectorAll('input[type="checkbox"]:checked')
        .forEach(cb => cb.checked = false);
}

async function listarVoluntarios() {

    try {

        const resposta = await fetch('http://localhost:3000/voluntarios');

        const dados = await resposta.json();

        if (resposta.ok) {

            return dados;

        } else {

            console.error(dados.erro || 'Erro ao buscar voluntários');
            return [];
        }

    } catch (erro) {

        console.error(erro);
        return [];
    }
}

async function inserirNucleos(nucleosString) {

    const nucleos = document.createElement("div");
    nucleos.classList.add("nucleos_voluntarios");

    if (!nucleosString) return nucleos;

    const cargos = nucleosString.split('|');

    for (let i = 0; i < cargos.length; i++) {

        const link = document.createElement("a");
        link.classList.add("icons_voluntarios");
        link.style.backgroundImage = `url("imgs/nucleos/${cargos[i]}.webp")`;
        nucleos.appendChild(link);

    }

    return nucleos;
}

async function inserirHTML() {

    const coresCard = ["#a8e6cf", "#FFF176", "#f8bbd0", "#e452fa", "#ffffff", "#7e57c2"]
    const contentVoluntarios = document.getElementById("content_voluntarios");
    const voluntarios = await listarVoluntarios();

    if (voluntarios.length === 0) {
        
        const mensagem = document.createElement("h3");
        mensagem.classList.add("mensagem_voluntarios");
        mensagem.innerHTML = "Nenhum voluntário foi cadastrado";

        contentVoluntarios.appendChild(mensagem);

    }

    let contadorCores = 0;

    for (let i = 0; i < voluntarios.length; i++) {

        const div = document.createElement("div");
        const img = document.createElement("img");
        const name = document.createElement("h3");
        const botao = document.createElement("button");

        div.classList.add("card_voluntarios");
        img.classList.add("foto_voluntarios");
        name.classList.add("nome_voluntarios");
        botao.classList.add("remover_botao");

        div.style.backgroundColor = coresCard[contadorCores];
        img.src = `https://ui-avatars.com/api/?name=${voluntarios[i].prenome}+${voluntarios[i].sobrenome}&background=d97706&color=fff&size=200`;
        name.innerHTML = voluntarios[i].prenome + "<br>" + voluntarios[i].sobrenome;
        botao.innerText = "remover";
        botao.addEventListener('click', () => removerVoluntario(`${voluntarios[i].prenome}`, `${voluntarios[i].sobrenome}`));

        div.appendChild(img);
        div.appendChild(name);
        div.appendChild(await inserirNucleos(voluntarios[i].nucleos));
        div.appendChild(botao);

        contentVoluntarios.appendChild(div);

        contadorCores++;

        if (contadorCores == coresCard.length) {
            contadorCores = 0;
        }
    }
}

inserirHTML();