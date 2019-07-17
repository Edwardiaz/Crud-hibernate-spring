package app;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dao.EjercicioDao;
import entity.Ejercicio;

@Controller
public class PruebaController {

	 @RequestMapping(value= "/" , method= RequestMethod.GET)
	    public String handler(Model model) {
		 
		 model.addAttribute("nombre", "Pepe");
	     return "index";
	    }
	 
	 @RequestMapping(value= "/hola")
	 public String insertar(@RequestParam(value="nombre", required = false, defaultValue = "mundo")String nombre, 
		    	@RequestParam(value="apellido", required = false, defaultValue = "mundo")String apellido,
		    	@RequestParam(value="genero", required = false, defaultValue = "mundo")String genero, 
		    	@RequestParam(value="email", required = false, defaultValue = "mundo")String email) {
		 
		 EjercicioDao ejercicioDao = new EjercicioDao();
		 Ejercicio ejer = new Ejercicio();
		 
		 ejer.setNombre(nombre);
		 ejer.setApellido(apellido);
		 ejer.setGenero(genero);
		 ejer.setEmail(email);
		 ejercicioDao.insertarEjercicio(ejer);
		 
		 
		 return "index";
	 }
	 
	 @RequestMapping("/lista")
	 public String consultarPersona(Model m) {
//		 ModelAndView mv = new ModelAndView();
		 
		 EjercicioDao ejerDao = new EjercicioDao();
		 
		 List<Ejercicio> listaEjer = ejerDao.getEjericio();
		 m.addAttribute("list", listaEjer);
		 return "mostrar";
	 }
	 
	 
}
