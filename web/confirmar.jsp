<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="Modelo.Pizza"%>
<%@page import="DAO.Bd"%>
<%@page import="Modelo.Tipo_pizza"%>
<%@page import="java.util.ArrayList"%>
<%
    ServletContext contexto = request.getServletContext();
    RequestDispatcher rd;
    HttpSession sesion = request.getSession();
    String usuario = (String) sesion.getAttribute("nombre");
    if (usuario == null) {
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
        <%
            Date fechaPedido = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fechaPedidoFormateada = sdf.format(fechaPedido);
            sdf = new SimpleDateFormat("HH:mm:ss");
            String horaPedidoFormateada = sdf.format(fechaPedido);
            
            ArrayList<String> pizzaIds = (ArrayList<String>) sesion.getAttribute("pedidos");
            ArrayList<Pizza> pizzas = new ArrayList<>();
            for (String str:pizzaIds) {
                Pizza pizza = Bd.getPizzasById(str);
                pizzas.add(pizza);
            }
            ArrayList<Integer> cantidades = (ArrayList<Integer>) sesion.getAttribute("cantidades");
            double total = 0;
            for (int x=0;x<pizzas.size();x++) {
                total += pizzas.get(x).getPrecio() * cantidades.get(x).intValue();
            }
            
            String envio = (String) sesion.getAttribute("tipoEnvio");
        %>
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
          <div class="col-6 text-center bg-white my-5 rounded border border-warning border-3">
            <p>Gracias</p>
            <p>${nombre}, tu pedido ha sido tramitado a las <%=fechaPedidoFormateada%> <%=horaPedidoFormateada%>,
             y consta de los siguientes productos:</p>
            <table style="width: 100%">
                <tr>
                    <th>Cantidad</th>
                    <th>Decripcion</th>
                    <th>Precio unidad</th>
                </tr>
                <%
                    for (int x=0;x<pizzas.size();x++) {
                %>
                    <tr>
                        <td><%=cantidades.get(x)%></td>
                        <td><%=pizzas.get(x).getNombre()%></td>
                        <td><%=pizzas.get(x).getPrecio()%></td>
                    </tr>
                <%
                    }
                %>
            </table>
            <p class="">TOTAL PEDIDO: <%=total%></p>
            <p>Aproximadamente en 30 min sera servido el pedido en <%=envio%></p>
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

