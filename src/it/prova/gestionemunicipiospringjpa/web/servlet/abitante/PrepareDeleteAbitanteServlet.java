package it.prova.gestionemunicipiospringjpa.web.servlet.abitante;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.prova.gestionemunicipiospringjpa.model.Abitante;
import it.prova.gestionemunicipiospringjpa.service.abitante.AbitanteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
/**
 * Servlet implementation class PrepareDeleteAbitanteServlet
 * @author federicof1994
 */
@WebServlet("/PrepareDeleteAbitanteServlet")
public class PrepareDeleteAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	@Autowired
	private AbitanteService abitanteService;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrepareDeleteAbitanteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Abitante abitante = abitanteService.caricaSingoloAbitanteEager(Long.parseLong(request.getParameter("idAbitante")));
		
		request.setAttribute("abitanteInput", abitante);
		
		RequestDispatcher rd = request.getRequestDispatcher("/abitante/deleteAbitante.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
