<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="#" method="post" modelAttribute="newsGrid">
        <table>
            
            <tbody>
            <c:forEach items="${newstList}" var="news" varStatus="status">
                <tr>
                    <td>${news.id}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>  
    </form:form>

</body>
</html>