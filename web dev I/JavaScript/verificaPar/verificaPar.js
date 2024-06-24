/* Crie uma função chamada verificaPar() que recebe um número como parâmetro e retorna true se o número for par ou false se for impar.

function verificaPar(num) {
  if (num % 2 == 0) {
    return console.log(true + `, o ${num} é par!`)
  } else {
    return console.log(false + `, o ${num} é impar!`)
  }
}

verificaPar(3) */

// Função verificaPar pegando um valor do usuário

function verificaPar(num) {
  let numero = document.getElementById('number').value

  if (numero % 2 == 0) {
    return alert(`O número ${numero} é par!`)
  } else {
    return alert(`O número ${numero} é impar!`)
  }
}
