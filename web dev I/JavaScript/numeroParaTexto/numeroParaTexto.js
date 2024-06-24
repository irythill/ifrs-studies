// Crie uma função que recebe um número inteiro entre 1 e 5 e retorna o número recebido em formato de texto.

function numeroParaTexto(num) {
  if (num == 1) {
    return console.log('um')
  } else if (num == 2) {
    return console.log('dois')
  } else if (num == 3) {
    return console.log('tres')
  } else if (num == 4) {
    return console.log('quatro')
  } else if (num == 5) {
    return console.log('cinco')
  } else {
    return console.log('numero fora de alcance')
  }
}

numeroParaTexto(4)
