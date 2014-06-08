<%--
  Created by IntelliJ IDEA.
  User: wangjie
  Date: 5/16/14
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Message List</title>
</head>
<body>

<h2>Message List</h2>

<div>
    <table>
        <thead>
        <tr>
            <th>No.</th>
            <th>From</th>
            <th>To</th>
            <th>Message</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${beanList}" var="bean" varStatus="status">
        <tr>
            <td>${status.index}</td>
            <td>${bean.from}</td>
            <td>${bean.to}</td>
            <td>${bean.msg}</td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
