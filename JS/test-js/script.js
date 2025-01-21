const log = document.getElementById("log")

let logs = []

logs.push("test")
logs.push("test2")


for (let el of logs) {
  log.append(el)
  log.append(document.createElement("br"))
  }

  