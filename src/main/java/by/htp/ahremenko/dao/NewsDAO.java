package by.htp.ahremenko.dao;

import by.htp.ahremenko.domain.News;
import java.util.List;
import by.htp.ahremenko.dao.exception.DAOException;


public interface NewsDAO {
	
	List<News> getList (String searchingString) throws DAOException;

	News fetchById(int id) throws DAOException;
	
	void save (News n) throws DAOException;
	
	void remove (Integer id) throws DAOException;
}
