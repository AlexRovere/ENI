import { Quizz } from "./Quizz.js"
import { Question } from "./Question.js"

let question = new Question("Combien d'heure dans une journée ?", [10, 20, 24, 34], 2)
let question2 = new Question("Combien de minutes dans une journée ?", [150, 2000, 3600, 9600], 2)
let question3 = new Question("Quel est le meilleur langage ?", ["java", "php", "JS", "cobol"], 3)


let questions = []
questions.push(question)
questions.push(question2)
questions.push(question3)


let quizz = new Quizz(questions)

quizz.afficherQuestion()

document.getElementById("submit").addEventListener("click", () => {
  quizz.collecterReponse()
})