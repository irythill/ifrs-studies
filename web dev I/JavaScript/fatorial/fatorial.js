/* Função de fatorar números 

function fatorial(fact) {
  let numero = 1
  for (let i = fact; i > 0; i--) {
    numero *= i
  }
  return console.log(numero)
}

fatorial(0) */

// Função fatorial para a web

function fatorial() {
  let num = document.getElementById('num').value
  let i = 1
  let fact = 1

  while (i <= num) {
    fact *= i
    i++
  }
  return alert(`O fatorial de !${num} é ${fact}`)
}
