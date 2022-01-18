<%@page import="java.util.ArrayList"%>
<%@ page session = "false" %>
<%
    ServletContext contexto = request.getServletContext();
    RequestDispatcher rd;
    HttpSession sesion = request.getSession();
    String usuario = (String) sesion.getAttribute("nombre");
    ArrayList<String> pedidos = (ArrayList<String>) sesion.getAttribute("pedidos");
    if (pedidos == null) {
        rd = contexto.getRequestDispatcher("/pedidos.jsp");
        rd.forward(request, response);
    } else if (usuario == null){
        rd = contexto.getRequestDispatcher("/index.jsp");
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
        <form action="envioController" method="POST">
            <div class="row position-relative">
              <div class="col-6 text-center">
                  <img src="images/delivery.png" class="bg-white rounded-circle border" width="200">
                  <p class="text-white">A domicilio</p>
                  <input type="radio" name="entrega" value="domicilio">
              </div>
              <div class="col-6 text-center">
                  <img src="images/shop.png" class="bg-white rounded-circle border" width="200" height="200">
                  <p class="text-white">En tienda</p>
                  <input type="radio" name="entrega" value="tienda" checked>              
              </div>
            </div>
            <div class="row justify-content-center">
                <input class="text-center" type="submit" value="enviar" style="width: 100px">
            </div>
        </form>
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
<% } %>