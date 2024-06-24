/* Crie uma função chamada churrasquinhoParaSnake() que recebe uma string no formato churrasquinho (dashed-case) e retorna essa string no formato snake_case. Ou seja, substitui “-” por “_”

function churrasquinhoParaSnake(churras) {
  let snake = churras.replace(/-/g, '_')
  return console.log(snake)
}

churrasquinhoParaSnake('Campus-Osorio-precisa-de-DCE') */

function churrasquinhoParaSnake(churrasquinho) {
  let churras = document.getElementById('churras').value

  let snake = churras.replace(/-/g, '_')
  return alert(snake)
}
