<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wangjie
  Date: 6/12/14
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>账户管理 | 更新账户信息</title>
    <meta charset="UTF-8">
</head>
<body>

<h3>更新账户信息</h3>

<div>

    <form action="/accounts/updateSubmit" method="post">

        <input type="hidden" name="accountId" value="${account.id}" />

        <div>
            账户名：
            <input type="text" name="name" value="${account.name}" />
        </div>

        <div>

            账户描述：
            <input type="text" name="desc" value="${account.desc}" />
        </div>

        <div>

            余额：
            <input type="number" name="balance" value="${account.balance}"/>
        </div>

        <div>

            父账户：
            <select name="parentId">

                <option value="" >No Parent</option>

                <c:if test="parents != null && parents.size > 0">
                <c:forEach items="parents" var="parent">
                    <option value="${parent.id}" <c:if test="${parent.id == account.id}">selected="selected"</c:if> >
                    ${parent.name}
                    </option>
                </c:forEach>
                </c:if>

            </select>
        </div>

        <div>
            账户状态：
            <select name="accountState">
                <option value="NORMAL" <c:if test="${'NORMAL' == account.id}">selected="selected"</c:if>>正常</option>
                <option value="NOT_USE" <c:if test="${'NOT_USE' == account.id}">selected="selected"</c:if>>未使用</option>
            </select>
        </div>

        <div>
            <button type="submit">提交</button>
        </div>

    </form>

</div>

</body>
</html>
