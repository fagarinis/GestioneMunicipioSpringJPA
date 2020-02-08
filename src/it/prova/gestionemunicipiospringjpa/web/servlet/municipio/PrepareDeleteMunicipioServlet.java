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
 * Servlet implementation class PrepareDeleteMunicipioServlet
 * @author Cirotrent
 */
@WebServlet("/PrepareDeleteMunicipioServlet")
public class PrepareDeleteMunicipioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MunicipioService municipioService;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrepareDeleteMunicipioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String parametroIdDelMunicipioDaCancellare = request.getParameter("idMunicipio");
		Municipio municipioDaCancellare = null;
		
		try {
			
			municipioDaCancellare = municipioService.caricaSingoloMunicipio(Long.valueOf(parametroIdDelMunicipioDaCancellare));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("deletemunicipio", municipioDaCancellare);
		request.setAttribute("descrizioneInput", request.getAttribute("descrizioneInput"));
		request.setAttribute("codiceInput", request.getAttribute("codiceInput"));
		request.setAttribute("ubicazioneInput", request.getAttribute("ubicazioneInput"));
		
		RequestDispatcher rd = request.getRequestDispatcher("municipio/deleteMunicipio.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
