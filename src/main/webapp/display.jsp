<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"   %>
	<%@ page isELIgnored="false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<table border="1">
      <th>ID</th>
      <th>Name</th>
 
      <c:forEach items="${InfoList}" var="current">
        <tr>
          <td><c:out value="${current.getId()}" /></td>
          <td><c:out value="${current.getName()}" /></td>
          <td><a href="approve/${current.id}">Approve</a></td> 
   <td><a href="delete/${current.id}">Delete</a></td> 
        </tr>
      </c:forEach>
    </table>

</body>
</html>