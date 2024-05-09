function generatePoem() {
    var userWord = document.getElementById('userWord').value;
    var poem = createPoem(userWord);
    displayPoem(poem);
}

function createPoem(word) {
    return `Aquí empieza el poema con la palabra: ${word}`;
}

function displayPoem(poem) {
    document.getElementById('poemDisplay').innerHTML = poem;
}