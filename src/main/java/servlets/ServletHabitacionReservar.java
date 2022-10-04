package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.HabitacionController;
import java.sql.Date;


@WebServlet("/ServletHabitacionReservar")
public class ServletHabitacionReservar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHabitacionReservar() {
        super();
        // TODO Auto-generated constructor stub
    }

        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
		// TODO Auto-generated method stub
		HabitacionController habitaciones = new HabitacionController();
		
		int id_habitacion = Integer.parseInt(request.getParameter("id_habitacion"));
		String username = request.getParameter("username");
                String pago = request.getParameter("pago");
                Date fecha_ingreso = Date.valueOf("fecha_ingreso");
                Date fecha_salida = Date.valueOf("fecha_salida");
		
		String habitacionesStr = habitaciones.reservar(id_habitacion,username, pago, fecha_ingreso, fecha_salida);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(habitacionesStr);
		out.flush();
		out.close();
		
	}

	
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
                throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

