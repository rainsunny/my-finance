<%--
  Created by IntelliJ IDEA.
  User: wangjie
  Date: 6/11/14
  Time: 12:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>账户管理 | 查看账户信息</title>
    <meta charset="UTF-8">
</head>
<body>

<h3>查看账户信息</h3>

<div>

    <table>
        <tr>
            <td>账户ID</td>
            <td>${account.id}</td>
        </tr>
        <tr>
            <td>账户名称</td>
            <td>${account.name}</td>
        </tr>
        <tr>
            <td>账户描述</td>
            <td>${account.desc}</td>
        </tr>
        <tr>
            <td>父账户</td>
            <td>${account.parentName}</td>
        </tr>
        <tr>
            <td>账户余额</td>
            <td>${account.balance}</td>
        </tr>
        <tr>
            <td>账户类型</td>
            <td>${account.accountType}</td>
        </tr>
        <tr>
            <td>账户状态</td>
            <td>${account.accountState}</td>
        </tr>
        <tr>
            <td>账户创建时间</td>
            <td>${account.createTime}</td>
        </tr>
        <tr>
            <td>账户更新时间</td>
            <td>${account.updateTime}</td>
        </tr>
    </table>


</div>

<div>

    <button type="button" class="btn"><a href="/accounts/update/${account.id}" target="_blank">修改账户</a> </button>
</div>

</body>
</html>
