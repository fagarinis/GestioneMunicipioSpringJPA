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
 * Servlet implementation class ExecuteUpdateAbitanteServlet
 * @author MohamedMohamedAli
 */
@WebServlet("/ExecuteUpdateAbitanteServlet")
public class ExecuteUpdateAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private AbitanteService abitanteService;
	@Autowired
	private MunicipioService municipioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
	
    public ExecuteUpdateAbitanteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idMunicipio= Long.parseLong(request.getParameter("idMunicipio"));
		Long idAbitante= Long.parseLong(request.getParameter("idAbitante"));
		String nome = request.getParameter("nomeInput");
		String cognome = request.getParameter("cognomeInput");
		int eta = Integer.parseInt(request.getParameter("etaInput"));
		String indirizzo = request.getParameter("indirizzoInput");
		Abitante abitante = new Abitante();
		Municipio municipio = municipioService.caricaSingoloMunicipio(idMunicipio);
		
		abitante.setId(idAbitante);
		abitante.setNome(nome);
		abitante.setCognome(cognome);
		abitante.setEta(eta);
		abitante.setResidenza(indirizzo);
		abitante.setMunicipio(municipio);
		abitanteService.aggiorna(abitante);
		List<Abitante>abitanti = abitanteService.listAllAbitanti();
		
		request.setAttribute("listaAbitantiAttributeName", abitanti);
		RequestDispatcher rd = request.getRequestDispatcher("/abitante/result.jsp");
		rd.forward(request, response);
	}

}
