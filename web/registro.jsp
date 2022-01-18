<%
    ServletContext contexto = request.getServletContext();
    RequestDispatcher rd;
    HttpSession sesion = request.getSession();
    String usuario = (String) sesion.getAttribute("nombre");
    if (usuario != null) {
        rd = contexto.getRequestDispatcher("/pedidos.jsp");
        rd.forward(request, response);
    } else {
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Telepizza</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <style media="screen">
          body {
            background-image: url("images/background.png");
             background-size: cover;
          }
        </style>
    </head>
    <body>
      <header>
        <nav class="navbar" style="background-color: #FF0506">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">
              <img src="images/logo.png" alt="" width="250" height=70 class="d-inline-block align-text-top">
            </a>
          </div>
        </nav>
      </header>

      <main class="container">
        <div class="row position-relative">
          <div class="col-6 text-center bg-white my-4 rounded border border-warning border-3">
            <h2 class="my-5">ALTA CLIENTE</h2>
            <form action="altaController" method="post">
              <div class="row">
                <div class="col-4 py-2">
                  Usuario:
                </div>
                <div class="col">
                  <input type="text" name="usuario" value="" pattern="/^[A-Za-z]{8,}$/" required>
                </div>
              </div>
              <div class="row py-2">
                <div class="col-4">
                  Contraseña:
                </div>
                <div class="col">
                  <input type="password" name="pass" value="" pattern="/(?=.*[A-Z])(?=.*[a-z])(?=.*[$_!·\\\*\/-<>&%\(\)]).{8}/" required>
                </div>
              </div>
              <div class="row py-2">
                <div class="col-4">
                  Repite Contraseña:
                </div>
                <div class="col">
                  <input type="password" name="repass" value="" required>
                </div>
              </div>
              <div class="row py-2">
                <div class="col-4">
                  Direccion:
                </div>
                <div class="col">
                  <input type="text" name="direccion" value="" required>
                </div>
              </div>
              <div class="row py-2">
                <div class="col-4">
                  Email:
                </div>
                <div class="col">
                  <input type="email" name="email" value="" required>
                </div>
              </div>                
              <div class="row py-2">
                <div class="col-4">
                  Telefono:
                </div>
                <div class="col">
                  <input type="text" name="telf" value="" pattern="/^\d{9}$/" required>
                </div>
              </div>
              <div class="my-4 text-center">
                <input type="submit" value="Registrar" class="btn btn-secondary" style="width:100px">
              </div>
            </form>
          </div>

          <div class="col-6">
            <img src="images/repartidor.png" alt="">
          </div>
        </div>
      </main>

      <footer class="d-flex flex-wrap justify-content-between py-2 text-white" style="background-color: #AA241B; position: absolute; bottom: 0; width: 100%">
        <div class="container-fluid row">
          <div class="col-9">
            Telepizza España
            <a href="#"><img src="images/mg.png" alt="" width="70" height="40"></a>
          </div>
          <div class="col-3">
            <img src="images/facebook.png" alt="" width="30" height="30">
            <img src="images/tuenti.png" alt="" width="30" height="30">
            <img src="images/twitter.png" alt="" width="30" height="30">
            <img src="images/youtube.png" alt="" width="30" height="30">
            <img src="images/google.png" alt="" width="30" height="30">
            <img src="images/instagram.png" alt="" width="30" height="30">
          </div>
        </div>
      </footer>
    </body>
</html>
<%}%>
