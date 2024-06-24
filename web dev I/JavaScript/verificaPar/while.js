/* Imprima no console todos os números entre -20 e 20. 

let x = -21

while (x <= 19) {
  x++
  console.log(x)
} */

/* Imprima no console todos os números pares entre 20 e 90, em ordem decrescente. 

let x = 92

while (x >= 22) {
  x -= 2
  console.log(x)
} */

/* Imprima no console todos os números divisíveis por 5 e 4 entre 5 e 50. */

let z = 5

while (z <= 50) {
  if (z % 4 == 0 && z % 5 == 0) {
    console.log(z)
    z++
  } else {
    console.log('Não é divisível')
  }
}
