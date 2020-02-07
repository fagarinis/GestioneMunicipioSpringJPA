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
import it.prova.gestionemunicipiospringjpa.model.Municipio;
import it.prova.gestionemunicipiospringjpa.service.abitante.AbitanteService;
import it.prova.gestionemunicipiospringjpa.service.municipio.MunicipioService;

/**
 * Servlet implementation class ExecuteSearchAbitanteServlet
 */
@WebServlet("/ExecuteSearchAbitanteServlet")
public class ExecuteSearchAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private MunicipioService municipioService;	
	
	@Autowired
	private AbitanteService abitanteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public ExecuteSearchAbitanteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idMunicipio= Long.parseLong(request.getParameter("idMunicipio"));
		String nome = request.getParameter("nomeInput");
		String cognome = request.getParameter("cognomeInput");
		String indirizzo = request.getParameter("indirizzoInput");
		Abitante abitante = new Abitante();
		Municipio municipio = municipioService.caricaSingoloMunicipio(idMunicipio);
		
		abitante.setNome(nome);
		abitante.setCognome(cognome);
		abitante.setResidenza(indirizzo);
		abitante.setMunicipio(municipio);
		
		List<Abitante>abitanti = abitanteService.findByExample(abitante);
		
		request.setAttribute("listaAbitantiAttributeName", abitanti);
		RequestDispatcher rd = request.getRequestDispatcher("/abitante/result.jsp");
		rd.forward(request, response);
	}

}
