package by.htp.ahremenko.controller;
import java.util.List;

import javax.validation.Valid;

//import javax.validation.Valid;

//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

import by.htp.ahremenko.domain.News;
import by.htp.ahremenko.service.NewsService;
import by.htp.ahremenko.service.exception.ServiceException;



@Controller
@RequestMapping("/")
public class NewsController {
	
	@Autowired
	private NewsService newsService; 
	
	@RequestMapping("/listNews")
	public String processForm(Model theModel) {
		
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
		//System.out.println("New User was put into model. [" + theUser.getId() +"]");
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
		
		//System.out.println("New User was put into model. [" + theUser.getId() +"]");
		
	}
	
	@RequestMapping("/saveNews")
	public String processForm(@Valid @ModelAttribute("news") News theNews, Model theModel) {

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
	
	@RequestMapping("/delete")
	public String deleteNews(@RequestParam("newsId") int theId, Model theModel) {
		
		System.out.println("Now ID: " + theId + " will be deleted.");
		try {
			newsService.remove(theId);
			List<News> result = newsService.getList(""); 
			theModel.addAttribute("newsList", result);		
			return "newsmanagement";
		} catch (ServiceException e){
			theModel.addAttribute("errorMessage", "Error: " + e.getMessage());
			return "error";
		}
		
	}
	
	@RequestMapping("/about")	
	public String goToAboutPage() {
		return "about";
	}
}
