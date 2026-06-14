const sqlite3 = require('sqlite3').verbose();

const db = new sqlite3.Database('./data/database.db', (err) => {
    if (err) {
        console.error(err.message);
    } else {
        console.log('Banco conectado!');
    }
});


db.run(`
    CREATE TABLE IF NOT EXISTS voluntarios (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        prenome TEXT NOT NULL,
        sobrenome TEXT NOT NULL,
        nucleos TEXT NOT NULL
    )
`, (err) => {
    if (err) {
        console.error('Erro ao criar tabela:', err.message);
    } else {
        console.log('Tabela voluntarios criada com sucesso!');
    }
});

module.exports = db;