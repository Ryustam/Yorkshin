const express = require('express');
const morgan = require('morgan');
const path = require('path');
// const apiRouter = require('./routes');

const app = express();

app.use(morgan('dev'));
app.use(express.urlencoded({extended:false}));
app.use(express.json());
app.use("/node_modules", express.static(path.join(__dirname,"node_modules")));
app.use(express.static(path.join(__dirname, 'public')));

// 루트 경로로 접근했을 때 index.html 제공
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'index.html'));
});
// app.use('/api', apiRouter);

const port = process.env.PORT || 3000;
app.listen(port, () =>console.log(`Server listening on port: ${port}`));
