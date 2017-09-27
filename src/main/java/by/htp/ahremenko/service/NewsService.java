package by.htp.ahremenko.service;

import java.util.List;

import by.htp.ahremenko.domain.News;
import by.htp.ahremenko.service.exception.ServiceException;

public interface NewsService {

	public List<News> getList(String searchingString) throws ServiceException;

	public News fetchById(int theId) throws ServiceException;
	
	public void save(News theNews) throws ServiceException;

	public void remove(int theId) throws ServiceException;
	
}
