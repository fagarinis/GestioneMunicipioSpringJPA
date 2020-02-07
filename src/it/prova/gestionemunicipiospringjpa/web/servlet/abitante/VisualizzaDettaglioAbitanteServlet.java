package it.prova.gestionemunicipiospringjpa.web.servlet.abitante;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionemunicipiospringjpa.model.Abitante;
import it.prova.gestionemunicipiospringjpa.service.abitante.AbitanteService;
import it.prova.gestionemunicipiospringjpa.service.municipio.MunicipioService;

/**
 * Servlet implementation class VisualizzaDettaglioAbitanteServlet
 */
@WebServlet("/VisualizzaDettaglioAbitanteServlet")
public class VisualizzaDettaglioAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@Autowired
	private MunicipioService municipioService;
	
	@Autowired
	private AbitanteService abitanteService;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaDettaglioAbitanteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idAbitanteDaPagina = request.getParameter("idAbitante");
		Abitante abitante = abitanteService.caricaSingoloAbitante(Long .parseLong(idAbitanteDaPagina));
		
		request.setAttribute("abitanteSingoloAttributeName", abitante);
		
		RequestDispatcher rd = request.getRequestDispatcher("abitante/dettaglio.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
