package Controllers;

import DAO.Bd;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext contexto = getServletContext();
        RequestDispatcher rd;
        HttpSession sesion = request.getSession();
        
        ArrayList<Usuario> listaUsuarios = null;
        try {
            listaUsuarios = Bd.getUsuarios();
        } catch (SQLException ex) {
            contexto.setAttribute("error", "Error en el SQL");
            rd = contexto.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
        
        boolean logged = false;
        String user = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        for (Usuario usuario:listaUsuarios) {
            if (user.equals(usuario.getUsuario()) && pass.equals(usuario.getPass())) {
                logged = true;
                sesion.setAttribute("id", usuario.getId());
                sesion.setAttribute("telefono", usuario.getPhone());
                break;
            }
        }
        
        if (logged) {
            sesion.setAttribute("nombre", user);
            long horaAccesoLong = sesion.getCreationTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date horaAcceso = new Date(horaAccesoLong);
            String formateo = sdf.format(horaAcceso);
            sesion.setAttribute("diaAcceso", formateo);
            sdf = null;
            sdf = new SimpleDateFormat("hh:mm:ss");
            formateo = sdf.format(horaAcceso);
            sesion.setAttribute("horaAcceso", formateo);
            rd = contexto.getRequestDispatcher("/pedidos.jsp");
            rd.forward(request, response);
        } else {
            contexto.setAttribute("error", "Error, verifique su usuario o contraseña");
            rd = contexto.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
