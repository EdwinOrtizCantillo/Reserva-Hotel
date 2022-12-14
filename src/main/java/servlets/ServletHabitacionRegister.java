
package servlets;

import controller.HabitacionController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ServletUsuarioRegister", urlPatterns = {"/ServletHabitacionRegister"})
public class ServletHabitacionRegister extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    public ServletHabitacionRegister(){
        super();
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HabitacionController habitaciones = new HabitacionController();
        int id_habitacion = Integer.parseInt(request.getParameter("id_habitacion"));
        String piso = request.getParameter("piso");
        String tipo = request.getParameter("tipo");
        String ciudad = request.getParameter("ciudad");
        int precio_dia = Integer.parseInt(request.getParameter("precio_dia"));
        boolean novedad = Boolean.parseBoolean(request.getParameter("novedad"));
        String result = habitaciones.register(id_habitacion, piso, tipo, ciudad, precio_dia, novedad);
        
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