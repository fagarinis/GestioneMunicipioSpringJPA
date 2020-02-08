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
import it.prova.gestionemunicipiospringjpa.model.Municipio;
import it.prova.gestionemunicipiospringjpa.service.abitante.AbitanteService;
import it.prova.gestionemunicipiospringjpa.service.municipio.MunicipioService;

/**
 * Servlet implementation class ExecuteInsertAbitanteServlet
 * @author claudia258
 */
@WebServlet("/ExecuteInsertAbitanteServlet")
public class ExecuteInsertAbitanteServlet extends HttpServlet {
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
    public ExecuteInsertAbitanteServlet() {
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
		String nomeInseritoNelForm = request.getParameter("nomeInput");
		String cognomeInseritoNelForm = request.getParameter("cognomeInput");
		String etaInseritoNelForm = request.getParameter("etaInput");
		String residenzaInseritaNelForm = request.getParameter("residenzaInput");
		Long idMunicipio = Long.parseLong(request.getParameter("idMunicipio"));
		Municipio municipioDaSettare = municipioService.caricaSingoloMunicipio(idMunicipio);
		
		Abitante abitanteDaInserire = new Abitante();
		abitanteDaInserire.setNome(nomeInseritoNelForm);
		abitanteDaInserire.setCognome(cognomeInseritoNelForm);
		abitanteDaInserire.setEta(Integer.parseInt(etaInseritoNelForm));
		abitanteDaInserire.setResidenza(residenzaInseritaNelForm);
		abitanteDaInserire.setMunicipio(municipioDaSettare);
		
		try {
			abitanteService.inserisciNuovo(abitanteDaInserire);
			request.setAttribute("listaAbitantiAttributeName", abitanteService.listAllAbitanti());
		}catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("abitante/result.jsp");
		rd.forward(request, response);
		
	}

}
