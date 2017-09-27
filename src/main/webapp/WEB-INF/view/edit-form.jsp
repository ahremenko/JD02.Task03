<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<tiles:insertDefinition name="edit-form">

	<tiles:putAttribute name="body"> 

   <div id="data">
	
		<br>
			
			<br>
			<form:form action="saveNews" modelAttribute="news">
				<form:hidden path="id" />
				Title: <form:input path="title" /> 
				<br>
				<br>
				Brief: <form:input path="brief" /> <form:errors path="brief" cssClass="error" />
				<br>
				<br>
				<input type="submit" value="Save" name="btn_save" />
				<input type="submit" value="Cancel" name="btn_cancel" />
			</form:form>

 	</div>
 
    </tiles:putAttribute>
    
</tiles:insertDefinition>