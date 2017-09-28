<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<tiles:insertDefinition name="edit-form">

	<tiles:putAttribute name="body"> 

   <div id="data">
	
		<br>
			
			<br>
			<form:form action="saveNews" modelAttribute="news">
				<form:hidden path="id" />
				<spring:message code="label.title"/>: <form:input path="title" /> 
				<br>
				<br>
				<spring:message code="label.brief"/>: <form:input path="brief" /> <form:errors path="brief" cssClass="error" />
				<br>
				<br>
				<input type="submit" value="<spring:message code="label.ok"/>" name="btn_save" />
				<input type="submit" value="<spring:message code="label.cancel"/>" name="btn_cancel" onclick="return true;"/>
			</form:form>


 	</div>
 
    </tiles:putAttribute>
    
</tiles:insertDefinition>