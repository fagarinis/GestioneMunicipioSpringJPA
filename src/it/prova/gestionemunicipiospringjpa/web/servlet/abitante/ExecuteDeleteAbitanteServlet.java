package it.prova.gestionemunicipiospringjpa.web.servlet.abitante;

import java.io.IOException;
import java.util.List;

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

/**
 * Servlet implementation class ExecuteDeleteAbitanteServlet
 */
@WebServlet("/ExecuteDeleteAbitanteServlet")
public class ExecuteDeleteAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AbitanteService abitanteService;

	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExecuteDeleteAbitanteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//#test
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		Long idAbitanteDaCancellare = Long.parseLong(request.getParameter("idAbitante"));
		Abitante abitanteDaCancellare = new Abitante();
		abitanteDaCancellare.setId(idAbitanteDaCancellare);

		//esecuzione rimuovi
		abitanteService.rimuovi(abitanteDaCancellare);
		
		//ricreo la lista di ricerca
		List<Abitante> listaAbitanti = abitanteService.listAllAbitanti();
		request.setAttribute("listaAbitantiAttributeName", listaAbitanti);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/abitante/result.jsp");
		rd.forward(request, response);
	}

}
