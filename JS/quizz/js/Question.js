class Question {
  static idx = 0
  constructor (enonce, reponses, reponseCorrecte) {
    this.enonce = enonce
    this.reponses = reponses
    this.reponseCorrecte = reponseCorrecte
    this.index = Question.idx
    Question.idx++
  }

  afficher () {
    let questionsDom = document.getElementById("questions")
    let label1 = document.createElement('label')
    let label2 = document.createElement('label')
    let label3 = document.createElement('label')
    let label4 = document.createElement('label')

    let input1 = document.createElement('input')
    let input2 = document.createElement('input')
    let input3 = document.createElement('input')
    let input4 = document.createElement('input')

    let enonce = document.createElement("div")
    enonce.innerText = this.enonce

    let container = document.createElement("div")
    container.classList.add("column")
    container.id = `question-${this.index}`

    let containerInput = document.createElement("div")
    containerInput.classList.add("container")


    label1.id = `q-${this.index}-label-1`
    label2.id = `q-${this.index}-label-2`
    label3.id = `q-${this.index}-label-3`
    label4.id = `q-${this.index}-label-4`

    input1.id = `q-${this.index}-input-1`
    input2.id = `q-${this.index}-input-2`
    input3.id = `q-${this.index}-input-3`
    input4.id = `q-${this.index}-input-4`

    input1.value = 0
    input2.value = 1
    input3.value = 2
    input4.value = 3
    input1.type = "radio"
    input2.type = "radio"
    input3.type = "radio"
    input4.type = "radio"

    input1.name = `q-${this.index}`
    input2.name = `q-${this.index}`
    input3.name = `q-${this.index}`
    input4.name = `q-${this.index}`
    label1.innerText = this.reponses[0]
    label2.innerText = this.reponses[1]
    label3.innerText = this.reponses[2]
    label4.innerText = this.reponses[3]

    questionsDom.appendChild(container)

    container.appendChild(enonce)
    container.appendChild(containerInput)

    containerInput.appendChild(label1)
    containerInput.appendChild(input1)
    containerInput.appendChild(label2)
    containerInput.appendChild(input2)
    containerInput.appendChild(label3)
    containerInput.appendChild(input3)
    containerInput.appendChild(label4)
    containerInput.appendChild(input4)
  }
}

export { Question }
