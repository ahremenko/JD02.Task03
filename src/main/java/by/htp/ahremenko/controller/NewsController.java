package by.htp.ahremenko.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import by.htp.ahremenko.domain.News;
import by.htp.ahremenko.service.NewsService;
import by.htp.ahremenko.service.exception.ServiceException;



@Controller
@RequestMapping("/")
public class NewsController {
	
	@Autowired
	private NewsService newsService; 
	
	private static final Logger logger = Logger.getLogger(NewsController.class);
	
	@RequestMapping("/listNews")
	public String processForm(Model theModel) {
		
		logger.info("Get list of news done.");
		try {
			List<News> result = newsService.getList(""); 
			theModel.addAttribute("newsList", result);		
			return "newsmanagement";
		} catch (ServiceException e){
			theModel.addAttribute("errorMessage", "Error: " + e.getMessage());
			return "error";
		}
	
	}
	
	@RequestMapping("/addNews")
	public String showForm(Model theModel) {
		News theNews= new News();
		theModel.addAttribute("news", theNews); 
		return "edit-form";
	}
	
	@RequestMapping("/edit")
	public String showEditForm(@RequestParam("newsId") int theId, Model theModel) {
		try {
			News theNews= newsService.fetchById(theId);
			theModel.addAttribute("news", theNews); 
			return "edit-form";
		} catch (ServiceException e){
			theModel.addAttribute("errorMessage", "Error: " + e.getMessage());
			return "error";
		}	
	}
	
	@RequestMapping("/saveNews")
	public String processForm(Model theModel, @Valid @ModelAttribute("news") News theNews, BindingResult theBindingResult) {
		
		logger.info("News ID: " + theNews.getId() + " will be saved.");
		if (theBindingResult.hasErrors()) {
			return "edit-form";
		} else {
			try {
				newsService.save(theNews);
				List<News> result = newsService.getList(""); 
				theModel.addAttribute("newsList", result);		
				return "newsmanagement";
			} catch (ServiceException e){
				theModel.addAttribute("errorMessage", "Error: " + e.getMessage());
				return "error";
			}
		}
	}
	
	@RequestMapping(path = "/delete", method = RequestMethod.POST)
	public String deleteNews(Model theModel, HttpServletRequest request) {
		
		if ( request.getParameterValues("selectedIds") != null ) {
			try {
				
				for (String theIds : request.getParameterValues("selectedIds")) {
					int theId = Integer.parseInt(theIds);
					newsService.remove(theId);
					//logger.info("Now News ID: " + theIds + " will be deleted!");
				}
				
				List<News> result = newsService.getList(""); 
				theModel.addAttribute("newsList", result);		
				
			} catch (ServiceException e){
				theModel.addAttribute("errorMessage", "Error: " + e.getMessage());
				return "error";
			}	
				
		}	
		return "newsmanagement";		
	}

	
	@RequestMapping("/about")	
	public String goToAboutPage() {
		return "about";
	}
	
	/*public void initBinder(WebDataBinder binder){
        SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }*/
}
