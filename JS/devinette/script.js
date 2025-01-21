const TRY = 10
document.getElementById("reset").addEventListener("click", () => {
  newGame()
})

let mot
let tryLeft

newGame()

function creerAlphabet () {
  const letters = []
  for (i = 65; i <= 90; i++) {
    letters.push(String.fromCharCode(i))
  }

  const $letters = document.getElementById("letters")
  $letters.replaceChildren()

  for (let letter of letters) {
    let div = document.createElement("div")
    div.id = letter
    div.innerHTML = letter
    div.value = letter
    div.addEventListener("click", (evt) => rechercherLettre(evt))
    $letters.appendChild(div)
  }
}

function creerMot () {
  let mots = ["JAMBON", "ESPADON", "MELANGER"]
  mot = mots[Math.floor(Math.random() * mots.length)]
  console.log(mot)
  let div = document.createElement("div")
  div.innerHTML = mot.replaceAll(/./g, "_")
  div.value = mot
  div.id = "word"
  document.getElementById("word").replaceWith(div)
}

function newGame() {
  tryLeft = TRY
  creerMot()
  creerAlphabet()
  document.getElementById("message").innerHTML = ""
  document.getElementById("tryLeft").innerHTML = TRY
  document.getElementById("usedLetters").removeChild()
}

function rechercherLettre (evt) {
  let tryLeft = document.getElementById("tryLeft").innerHTML
  if (tryLeft > 0) {
    const value = evt.target.value
    if (mot.toUpperCase().includes(value)) {
      revelerLettre(value)
    }
    enleverLettre(value)
    addUsedLetters(value)
    enleverEssai()
    verifVictoire()
  } else {
    alert("Vous n'avez plus d'essai restant !")
  }
}

function revelerLettre (letter) {
  let idxs = []
  let motToFind = mot.split("")
  let searchIdx = 0

  motToFind.forEach(element => {
    if (element === letter) {
      let idxToAdd = motToFind.indexOf(element, searchIdx)
      searchIdx = idxToAdd + 1
      idxs.push(idxToAdd)
    }
  });

  let wordEl = document.getElementById("word")
  let wordValue = wordEl.innerHTML
  let newWord = wordValue
  for (let idx of idxs) {
    newWord = newWord.substring(0, idx) + letter + newWord.substring(idx + 1)
  }
  wordEl.innerHTML = newWord
}

function enleverLettre (letter) {
  document.getElementById(letter).remove()
}

function addUsedLetters(letter) {
  let div = document.createElement("div")
  div.innerHTML = letter
  document.getElementById("usedLetters").appendChild(div)
}

function enleverEssai () {
  tryLeft--
  document.getElementById("tryLeft").innerHTML = tryLeft
}

function verifVictoire () {
  let wordEl = document.getElementById("word")
  if (wordEl.innerHTML.includes("_") && tryLeft < 1) {
    document.getElementById("message").innerHTML = "VOUS AVEZ PERDU !!!"
  } else if (!wordEl.innerHTML.includes("_")) {
    document.getElementById("message").innerHTML = "VOUS AVEZ GAGNE !!!"
  }
  else if (wordEl.innerHTML.includes("_")) {
    document.getElementById("message").innerHTML = "Vous n'avez pas trouvé, essayez encore !"
  }
}




