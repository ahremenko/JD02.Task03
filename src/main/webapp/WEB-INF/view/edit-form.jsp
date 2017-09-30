<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<tiles:insertDefinition name="edit-form">

	<tiles:putAttribute name="body"> 

   <div id="data">
	
		<br><br>
			<form:form action="saveNews" modelAttribute="news">
				<form:hidden path="id" />
				<form:hidden path="active" />
				<spring:message code="label.title"/>
				<br>
				 <form:input path="title" size="50"/> 
				<br>
				<br>
				<spring:message code="label.created"/>
				<br>
				 <form:input path="created" size="10"/> <form:errors path="created" cssClass="error" />
				<br>
				<br>
				<spring:message code="label.brief"/>
				<br> 
				 <form:textarea path="brief" cols="50" rows="3"/> <form:errors path="brief" cssClass="error"/>
				<br>
				<br>
				<spring:message code="label.content"/>
				<br>
				 <form:textarea path="content"  cols="50" rows="5"/> <form:errors path="content" cssClass="error"/>
				<br>
				<input type="submit" value="<spring:message code="label.ok"/>" name="btn_save" />
				<a href="javascript:history.back()"><spring:message code="label.cancel" /></a>
				<!--  input type="submit" value="<spring:message code="label.cancel"/>" name="btn_cancel" onclick="return true;"/ -->
			</form:form>

 	</div>
 
    </tiles:putAttribute>
    
</tiles:insertDefinition>