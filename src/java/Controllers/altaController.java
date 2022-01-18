package Controllers;

import DAO.Bd;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class altaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet altaController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet altaController at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        ServletContext contexto = request.getServletContext();
        RequestDispatcher rd;
        
        String username = request.getParameter("usuario");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");
        String direccion = request.getParameter("direccion");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telf");
        
        if (pass.equals(repass)) {
            Usuario usuario = new Usuario(0, username, pass, direccion, email, telefono);
            try {
                Bd.registrarUsuario(usuario);
            } catch (SQLException ex) {
                contexto.setAttribute("error", "Error en el SQL");
                rd = contexto.getRequestDispatcher("/error.jsp");
                rd.forward(request, response);                
            }
            contexto.setAttribute("error", "Usuario registrado correctamente");
            rd = contexto.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);            
        } else {
            contexto.setAttribute("error", "Las contraseñas no coinciden");
            rd = contexto.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
