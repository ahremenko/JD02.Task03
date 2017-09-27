package by.htp.ahremenko.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.htp.ahremenko.dao.NewsDAO;
import by.htp.ahremenko.dao.exception.DAOException;
import by.htp.ahremenko.domain.News;
import by.htp.ahremenko.service.NewsService;
import by.htp.ahremenko.service.exception.ServiceException;

@Service
public class NewsServiceImpl implements NewsService {

	// need to inject customer dao
	@Autowired
	private NewsDAO newsDAO;
	
	//@Override
	@Transactional
	public List<News> getList(String searchingString) throws ServiceException {
		
		try {
			List<News> result = newsDAO.getList(searchingString);	
		    return result; 
		} catch ( DAOException e) {
			//logger.error("Error on server:" + e.getMessage());
			throw new ServiceException(e.getMessage());
		}
   
	}

	//@Override
	@Transactional
	public void save(News theNews) throws ServiceException {
		
		// log
		
		// check
		try {
			newsDAO.save(theNews);
		} catch ( DAOException e) {
			//logger.error("Error on server:" + e.getMessage());
			throw new ServiceException(e.getMessage());
		}	
	}

	//@Override
	@Transactional
	public News fetchById(int theId) throws ServiceException {
		try {
			News result = newsDAO.fetchById(theId);
			return result;
		} catch ( DAOException e) {
			//logger.error("Error on server:" + e.getMessage());
			throw new ServiceException(e.getMessage());
		}		
	}

	//@Override
	@Transactional
	public void remove(int theId) throws ServiceException {
		try {
			newsDAO.remove(theId);
		} catch ( DAOException e) {
			//logger.error("Error on server:" + e.getMessage());
			throw new ServiceException(e.getMessage());
		}		
	}
}





