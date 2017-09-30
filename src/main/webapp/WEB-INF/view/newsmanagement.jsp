<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<tiles:insertDefinition name="newsmanagement">

   <tiles:putAttribute name="body"> 
   <div id="data">
   
	    <form action="delete" method="post">
		<table>
				<tr>
					<th><spring:message code="label.title"/></th>
					<th><spring:message code="label.brief"/></th>
					<th><spring:message code="label.created"/></th>
					<th><spring:message code="label.actions"/></th>
				</tr> 
				<tr>
					
			<c:forEach items="${newsList}" var="news">
			
					<c:url var="updateLink" value="edit">
						<c:param name="newsId" value="${news.id}" />
					</c:url>

				<tr>
					<td>${news.title}</td>
					<td>${news.brief}</td>
					<td><fmt:formatDate value="${news.created}" pattern="dd/MM/yyyy"/></td>
					<td><a href="${updateLink}"><spring:message code="label.edit"/></a>&nbsp;
						<input type="checkbox" name="selectedIds" value="${news.id}"/>
					</td>
				</tr>	
			</c:forEach>
		</table>
		
         <input type="submit" value="<spring:message code="label.delete" />" onclick="return confirm('<spring:message code="label.ausure" />')" >
                  
         
        </form>
		
		
 	</div>
 
    </tiles:putAttribute>
    
</tiles:insertDefinition>