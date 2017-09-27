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

		/*SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(News.class)
				.buildSessionFactory();

		Session session = factory.openSession();

		try {

			 session.beginTransaction();
		     
			 //List<User> result = session.createQuery("FROM User").list();
			 
			 List<News> result = session.createQuery("from News").getResultList();

			 session.getTransaction().commit();

		     theModel.addAttribute("newsList", result);
		     
		} finally {
			factory.close();
		}
		*/
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
	
	@RequestMapping("/saveNews")
	public String processForm(@Valid @ModelAttribute("news") News theNews, BindingResult theBindingResult, Model theModel) {
		
		/*
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(News.class)
				.buildSessionFactory();

		Session session = factory.openSession();
		
		int newsId;
		
		newsId = theNews.getId();
		
				
		try {
			
			session.beginTransaction();
			if  ( newsId == 0 ) {
				 // add 
	  			 session.save(theNews); 
			} else {
				session.saveOrUpdate(theNews);
			}
			
 			 session.getTransaction().commit();
 			 
 			 session.beginTransaction();
 			 List<News> result = session.createQuery("from News").getResultList();

			 session.getTransaction().commit();

		     theModel.addAttribute("newsList", result);
		     System.out.println("News saved!");
		} finally {
			factory.close();
		}
		
		if (theBindingResult.hasErrors()) {
			return "edit-form";
		} else {
			return "newsmanagement";
		}*/
		return "newsmanagement";
	}
	
	@RequestMapping("/about")	
	public String goToAboutPage() {
		return "about";
	}
}
