const db = require('../database/connection');
const express = require('express');
const router = express.Router();

router.post('/', (req, res) => {

    const { prenome, sobrenome, nucleos } = req.body;

    db.run(
        
        'INSERT INTO voluntarios (prenome, sobrenome, nucleos) VALUES (?, ?, ?)',
        [prenome, sobrenome, nucleos],

        function(err) {

            if (err) {
                return res.status(500).json(err);
            }

            res.json({
                id: this.lastID
            });
        }
    );
});

router.get('/', (req, res) => {

    db.all('SELECT * FROM voluntarios', [], (err, rows) => {

        if (err) {
            return res.status(500).json(err);
        }

        res.json(rows);
    });
});

router.delete('/', (req, res) => {

    const { prenome, sobrenome } = req.body;

    db.run(
        'DELETE FROM voluntarios WHERE prenome = ? AND sobrenome = ?',
        [prenome, sobrenome],

        function(err) {

            if (err) {
                return res.status(500).json(err);
            }

            if (this.changes === 0) {
                return res.status(404).json({ erro: 'Voluntário não encontrado' });
            }

            res.json({ mensagem: 'Voluntário removido com sucesso' });
        }
    );
});

module.exports = router;