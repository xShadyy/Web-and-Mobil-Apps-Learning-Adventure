const http = require('http');
const fs = require('fs');
const path = require('path');

const server = http.createServer((req,res) => {
    if (req.url === '/') {
        res.writeHead(200, {'Content-Type': 'text/plain'});
        res.end('Strona glowna');
    }

    else if (req.url === '/json') {
        const jsonData = {
            name: 'Jan Kowalski',
            age: 30,
            job: 'programista'
        };
        res.writeHead(200, {'Content-Type': 'text/plain'});
        res.end(JSON.stringify(jsonData));
    }

    else if (req.url === '/html') {
        const htmlContent = `
            <!DOCTYPE html>
            <html lang="pl">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Dynamiczny HTML</title>
            </head>
            <body>
                <h1>To jest dynamicznie generowany HTML</h1>
            </body>
            </html>
        `;
        res.writeHead(200, { 'Content-Type': 'text/html' });
        res.end(htmlContent);
    }

    else if (req.url === '/file') {
        const filePath = path.join(__dirname, 'public', 'index.html');
        fs.readFile(filePath, 'utf8', (err, data) => {
            if (err) {
                res.writeHead(500, { 'Content-Type': 'text/plain' });
                res.end('Błąd serwera');
            } else {
                res.writeHead(200, { 'Content-Type': 'text/html' });
                res.end(data);
            }
        });
    }
    else {
        res.end('404: Strona nie została znaleziona');
    }
});

const PORT = 3000;
server.listen(PORT, () => {
    console.log(`Serwer działa na porcie ${PORT}`);
});