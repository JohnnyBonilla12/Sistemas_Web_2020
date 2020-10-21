var blogeo = document.getElementById('signin');
blogeo.addEventListener('click', function() {
    var e = document.getElementById('email').value;
    var p = document.getElementById('password').value;
    const parametros = new URLSearchParams();
    parametros.append('PrmEmail', e);
    parametros.append('PrmPassword', p);
    //alert(parametros);

    // axios.get("http://localhost/hola?" + parametros)
    //     .then(function(response) {
    //         console.log(response)
    //         console.log("Contenido" + response.data)
    //         console.log("Estatus" + response.status)
    //         document.getElementById('titulo').innerHTML = response.data
    //     })
    //     .catch(function(error) {
    //       console.log(error)
    //     })
        
    //alert('Evento boton: ' + document.getElementById('password').value);
    // axios.post("http://localhost/adios?" + parametros)
    // .then(function(response) {
    //     console.log(response)
    //     console.log("Contenido" + response.data)
    //     console.log("Estatus" + response.status)
    //     document.getElementById('titulo').innerHTML = response.data
    // })
    // .catch(function(error) {
    //   console.log(error)
    // })

    //Se hace la peticion POST como JSON
    // axios.post("http://localhost/adios" , {
    //   PrmEmail: e,
    //   PrmPassword: p
    // })
    // .then(function(response) {
    //     console.log(response)
    //     console.log("Contenido" + response.data)
    //     console.log("Estatus" + response.status)
    //     document.getElementById('titulo').innerHTML = response.data
    // })
    // .catch(function(error) {
    //   console.log(error)
    // })

  //  axios.post("http://localhost/adiosJson" , {
  //     PrmEmail: e,
  //     PrmPassword: p
  //   })
  //   .then(function(response) {
  //       console.log(response)
  //       console.log("Contenido" + response.data)
  //       console.log("Estatus" + response.status)
  //       document.getElementById('titulo').innerHTML = response.data
  //   })
  //   .catch(function(error) {
  //     console.log(error)
  //   })

  axios.post("http://localhost:4567/usuarios", {
        PrtEmail : document.getElementById('email').value,
        PrtPassword : document.getElementById('password').value
  })
    .then(function (response) {
        console.log(response)
        console.log(response.data)
        console.log(response.statusText)
        document.getElementById('titulo').innerHTML = response.data
    })
    .catch(function (error) {
        console.log(error)
    })
});