const express = require('express');
const app = express();
const path = require('path');

app.use(express.json());
app.use(express.static(path.join(__dirname, '../front-end')));

const voluntariosRouter = require('./routes/voluntarios');

app.use('/voluntarios', voluntariosRouter);

app.listen(3000, () => {
    console.log('Servidor rodando em http://localhost:3000');
});