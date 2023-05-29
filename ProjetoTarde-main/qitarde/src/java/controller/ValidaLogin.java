package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import model.Titular;
import model.User;

@WebServlet(name = "ValidaLogin", urlPatterns = {"/verifica_usuario.java"})
public class ValidaLogin extends HttpServlet {
    private String email;
    private String pass;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        this.email = request.getParameter("email");
        this.pass = request.getParameter("pass");
        
        Titular obj = new Titular();
        obj.setNome(this.email);
        obj.setSenha(this.pass);
        
        try {
        if(obj.isLogged()) {
            HttpSession session = request.getSession();
            session.setAttribute("userNameSession", obj);
            //request.setAttribute("userName", obj);
            request.getRequestDispatcher("informacao.jsp").forward(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.print(
                    "<script>"
                  + "alert('Acesso negado!');"
                  + "window.location.replace('index.html');"
                  + "</script>"
            );
        }
    } catch(SQLException | ClassNotFoundException erro) {
        PrintWriter out = response.getWriter();
        out.print(erro);
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}