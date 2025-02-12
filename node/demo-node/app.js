const http = require("http")

const host = "localhost"

const port = 3000

const server = http.createServer((req, res) => {
  res.statusCode = 200
  res.setHeader("Content-Type", "text/plain")
  res.end("Hello world !")
})

server.listen(port, host, () => {
  console.log(`Le serveur est en cours sur http://${host}:${port}/`)
})