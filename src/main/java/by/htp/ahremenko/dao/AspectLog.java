package by.htp.ahremenko.dao;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import by.htp.ahremenko.controller.NewsController;
import by.htp.ahremenko.domain.News;


	@Aspect
	@Component
	public class AspectLog {
		
		private static final Logger logger = Logger.getLogger(AspectLog.class);
		
		@Before("execution(* by.htp.ahremenko.dao.*.*(org.springframework.ui.Model, ..))")
		public void logStoredData(JoinPoint joinPoint) {
			Object[] args = joinPoint.getArgs();
			for (Object argument : args) {
				if (argument instanceof News) {
					logger.info("Store object - " + argument.toString() );
					//HttpServletRequest request = (HttpServletRequest) argument;
					//System.out.println(new Date()+ " | url: " + request.getRequestURI() + " | method: " + request.getMethod());
				}
			}
		}
	}
	


