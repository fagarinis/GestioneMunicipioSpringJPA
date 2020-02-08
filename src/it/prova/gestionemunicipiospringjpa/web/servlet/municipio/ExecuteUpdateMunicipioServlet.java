package it.prova.gestionemunicipiospringjpa.web.servlet.municipio;

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

import it.prova.gestionemunicipiospringjpa.model.Municipio;
import it.prova.gestionemunicipiospringjpa.service.municipio.MunicipioService;

/**
 * Servlet implementation class ExecuteUpdateMunicipioServlet
 * @author Cirotrent
 */
@WebServlet("/ExecuteUpdateMunicipioServlet")
public class ExecuteUpdateMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MunicipioService municipioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public ExecuteUpdateMunicipioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("userInfo") == null) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		

		String idMunicipioDaPagina = request.getParameter("idMunicipio");
		Municipio municipioDaModificare = municipioService.caricaSingoloMunicipio(Long.parseLong(idMunicipioDaPagina));

		String descrizioneParameter = request.getParameter("descrizioneInput");
		String ubicazioneParameter = request.getParameter("ubicazioneInput");
		String codiceParameter = request.getParameter("codiceInput");

			municipioDaModificare.setDescrizione(descrizioneParameter);
			municipioDaModificare.setCodice(codiceParameter);
			municipioDaModificare.setUbicazione(ubicazioneParameter);;

			municipioService.aggiorna(municipioDaModificare);
			
		
		request.setAttribute("listaMunicipiAttributeName", municipioService.listAllMunicipi());//cercaPersonaByExample(personaModificata)
		RequestDispatcher rd = request.getRequestDispatcher("/municipio/result.jsp");
		rd.forward(request, response);
	}

}
