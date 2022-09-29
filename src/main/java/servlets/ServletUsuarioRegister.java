
package servlets;

import controller.UsuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletUsuarioRegister", urlPatterns = {"/ServletUsuarioRegister"})
public class ServletUsuarioRegister extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    public ServletUsuarioRegister(){
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioController usuario = new UsuarioController();
        String username = request.getParameter("username");
        String contrasena = request.getParameter("contrasena");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String ciudad_origen = request.getParameter("ciudad_origen");
        String email = request.getParameter("email");
        String celular = request.getParameter("celular");
        boolean premium = Boolean.parseBoolean(request.getParameter("premium"));
        String result = usuario.register(username, contrasena, nombre, apellidos, ciudad_origen, email, celular, premium);
        
        response.setContentType("text-html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}