var blogeo = document.getElementById('signin');
blogeo.addEventListener('click', function() {
    var e = document.getElementById('email').value;
    var p = document.getElementById('password').value;
    const parametros = new URLSearchParams();
    parametros.append('PrmEmail', e);
    parametros.append('PrmPassword', p);
    //alert(parametros);
    axios.get("http://localhost/adios")
        .then(function(response) {
            console.log(response)
            console.log("Contenido" + response.data)
            console.log("Estatus" + response.status)
            document.getElementById('titulo').innerHTML = response.data
        })
        .catch(function(error) {
          console.log(error)
        })
    //alert('Evento boton: ' + document.getElementById('password').value);
});