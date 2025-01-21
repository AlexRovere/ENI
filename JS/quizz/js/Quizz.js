class Quizz {
  constructor (questions) {
    this.questions = questions
    this.score = 0
  }

  afficherQuestion () {
    for (let question of this.questions) {
      question.afficher()
    }
  }

  collecterReponse () {
    this.score = 0

    for (let rep of this.questions) {
      let idx = rep.index
      let reponses = document.getElementsByName(`q-${idx}`)

      let checked = Array.from(reponses).find(r => r.checked === true)
      if (!checked) continue
      let reponse = checked.value

      let questionContainer = document.getElementById(`question-${idx}`)
      let div = document.createElement("div")


      if (+reponse === rep.reponseCorrecte) {
        this.score += 10
        div.style.color = "green"
        div.innerText = "Bien joué, bonne réponse !"

      } else {
        div.innerText = "Mauvaise réponse"
        div.style.color = "red"
      }
      questionContainer.appendChild(div)
      this.afficherResultat()
    }
  }

  afficherResultat () {
    let div = document.getElementById("score")
    div.innerText = this.score
  }
}

export { Quizz }
