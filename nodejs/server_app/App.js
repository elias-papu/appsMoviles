const express = require('express');
const app = express();
const PORT = 8000;

app.use(express.json());
app.get('/', (req, res) => {
  res.send('<html><body><h1>Hola papus soy el servidor de Elías en NodeJS</h1></body></html>');
});

app.post('/suma', (req, res) => {
  const num1 = parseInt(req.query.num1);
  const num2 = parseInt(req.query.num2);

  if (isNaN(num1) || isNaN(num2)) {
    return res.status(400).json({ error: 'Error en los números por culpa de Pedro!!' });
  } else {
    const suma = num1 + num2;
    res.json({ suma });
  }
});

app.post('/multi', (req, res) => {
  const { num1, num2 } = req.body;
  if (typeof num1 !== 'number' || typeof num2 !== 'number') {
    return res.status(400).json({ error: 'Error en los números por culpa de Pedro otra vez!!' });
  } else {
    const multi = num1 * num2;
    res.json({ multi });
  }
})

app.listen(PORT, () => {
  console.log(`Servidor corriendo en http://localhost:${PORT}`);
});