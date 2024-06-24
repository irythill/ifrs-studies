/* Q2) Crie uma função que recebe um array e retorna true se todos os elementos do array forem iguais. Se pelo menos um for diferente, retorna false.

let arr = [1, 1, 1, 1]

function uniforme(arr) {
  for (let i = 1; i < arr.length; i++) {
    if (arr[i] === arr[0]) {
      return true
    } else {
      return false
    }
  }
}

console.log(uniforme(arr)) */

let arrayUniforme = [1, 1, 1, 1].filter(value => value === value)

console.log(arrayUniforme)
