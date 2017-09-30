package by.htp.ahremenko.dao.impl;

import java.util.List;

import by.htp.ahremenko.dao.NewsDAO;
import by.htp.ahremenko.dao.exception.DAOException;
import by.htp.ahremenko.domain.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository 
public class NewsDBImpl implements NewsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<News> getList(String searchingString) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		List<News> result = currentSession.createQuery("from News where rec_state = 1 order by created desc").getResultList();
		return result;
	}
	
	public News fetchById(int theId) throws DAOException {
		
		Session currentSession = sessionFactory.getCurrentSession();
		News theNews = currentSession.get(News.class, theId);
		return theNews; 
	}
	
	public void save(News theNews) throws DAOException {
		
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theNews); 
		
	}

	public void remove(Integer theId) throws DAOException {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("update News set rec_state = 0 where id=:newsId");
		theQuery.setParameter("newsId", theId);
		theQuery.executeUpdate();	
		
	}

	

	
	

}
