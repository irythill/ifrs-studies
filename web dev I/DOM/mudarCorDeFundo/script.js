let listaDeCores = [
  'black',
  'white',
  'blue',
  'green',
  'red',
  'wheat',
  'hotpink',
  'coral',
  'violet',
  'purple'
]

let botao = document.getElementById('botao')

botao.addEventListener('click', function mudarCorDeFundo() {
  for (let i = 0; i < listaDeCores.length; i++) {
    document.body.style.backgroundColor =
      listaDeCores[Math.floor(Math.random() * listaDeCores.length)]
  }
})
