<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<tiles:insertDefinition name="newsmanagement">

   <tiles:putAttribute name="body"> 
   <div id="data">
   
	    <form:form action="delete" modelAttribute="news">
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
					<td>${news.created}</td>
					<td><a href="${updateLink}"><spring:message code="label.edit"/></a>&nbsp;
					    <form:checkbox path="newsId" value="${news.id}"/>
					</td>
					
				</tr>	
			</c:forEach>
		</table>
		<p>
			<input type="submit" value="<spring:message code="label.delete"/>" name="btn_delete" />
		</p>
		</form:form>
 	</div>
 
    </tiles:putAttribute>
    
</tiles:insertDefinition>