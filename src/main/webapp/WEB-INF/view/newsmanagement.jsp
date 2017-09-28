<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tiles:insertDefinition name="newsmanagement">

   <tiles:putAttribute name="body"> 
   <div id="data">
	
		<table>
				<tr>
					<th>Title</th>
					<th>Brief</th>
					<th>Date</th>
					<th>Actions</th>
				</tr> 
				<tr>
					
			<c:forEach items="${newsList}" var="news">
			
					<c:url var="updateLink" value="/news/updateNews">
						<c:param name="newsId" value="${news.id}" />
					</c:url>

				<tr>
					<td>${news.title}</td>
					<td>${news.brief}</td>
					<td>${news.created}</td>
					<td><a href="${updateLink}">Edit</a></td>
				</tr>	
			</c:forEach>
		</table>

 	</div>
 
    </tiles:putAttribute>
    
</tiles:insertDefinition>