package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class pedidoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet pedidoController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet pedidoController at " + request.getContextPath() + "</h1>");
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
        HttpSession sesion = request.getSession();
        
        String carne = request.getParameter("carne");
        String queso = request.getParameter("queso");
        String clasicos = request.getParameter("clasicos");
        String infantil = request.getParameter("infantil");
        String gluten = request.getParameter("gluten");
        String carneCant = request.getParameter("carneCant");
        String quesoCant = request.getParameter("quesoCant");
        String clasicosCant = request.getParameter("clasicosCant");
        String infantilCant = request.getParameter("infantilCant");
        String glutenCant = request.getParameter("glutenCant");
        
        String arrTipos[] = {carne,queso,clasicos,infantil,gluten};
        String arrCant[] = {carneCant,quesoCant,clasicosCant,infantilCant,glutenCant};
        
        boolean filledTipos = false;
        ArrayList<String> optionsChosen = new ArrayList<>();
        ArrayList<Integer> cantChosen = new ArrayList<>();
        
        for (int x=0;x<arrTipos.length;x++) {
            if (!arrTipos[x].isEmpty() && !arrCant[x].equals("0")){
                filledTipos = true;
                optionsChosen.add(arrTipos[x]);
                cantChosen.add(Integer.parseInt(arrCant[x]));
            }
        }
        
        if (filledTipos) {
            sesion.setAttribute("pedidos", optionsChosen);
            sesion.setAttribute("cantidades", cantChosen);
            rd = contexto.getRequestDispatcher("/zona_localizacion.jsp");
            rd.forward(request, response); 
        } else {
            contexto.setAttribute("error", "Error, elija al menos una pizza");
            rd = contexto.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
