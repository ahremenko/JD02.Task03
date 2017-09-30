package by.htp.ahremenko.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.htp.ahremenko.dao.exception.DAOException;
import by.htp.ahremenko.dao.impl.NewsDBImpl;
import by.htp.ahremenko.domain.News;


public class DaoTest extends NewsDBImpl {

	private NewsDAO newsDAO;
	private ClassPathXmlApplicationContext context;

	@Before
	public void setUp() throws ParseException {
		context = new ClassPathXmlApplicationContext("test_context.xml");
		newsDAO = (NewsDAO) context.getBean("newsDBImpl");
	}

	@Test
	public void findByIdTest() throws DAOException {
		News expectedNews = new News();
		expectedNews.setId(5001);
	
		expectedNews.setTitle("How Irma Became So Big and So Destructive");
	
		News realNews = newsDAO.fetchById(5001);

		assertTrue(expectedNews.equals(realNews));
	}

	@After
	public void closeContext() {
		context.close();
	}
}
