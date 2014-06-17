<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wangjie
  Date: 6/11/14
  Time: 12:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>账户管理 | 新建账户</title>
    <meta charset="UTF-8">
</head>
<body>

<h3>新建账户</h3>

<div>
    <form action="/accounts/addSubmit" method="post">

        <div>
            账户名称：
            <input type="text" name="name" /> <span class="required">*</span>
        </div>

        <div>
            账户描述：
            <input type="text" name="desc" /> <span class="required">*</span>
        </div>

        <div>
            账户余额：
            <input type="text" name="balance" />
        </div>

        <div>
            父账户：
            <select name="parentId">
                <option value="" selected="selected">No Parent</option>

                <c:if test="accounts != null && accounts.size > 0">
                <c:forEach items="accounts" var="account">
                    <option value="${account.id}">${account.name}</option>
                </c:forEach>
                </c:if>

            </select>
        </div>

        <div>
            账户类型：

            <select name="accountType" >
                <option value="LEAF">LEAF</option>
                <option value="INNER">INNER</option>
            </select>
        </div>

        <div>
            <button type="submit">新建账户</button>
        </div>

    </form>
</div>

</body>
</html>
