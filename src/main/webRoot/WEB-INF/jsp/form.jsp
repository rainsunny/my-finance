<%--
  Created by IntelliJ IDEA.
  User: wangjie
  Date: 5/16/14
  Time: 12:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>

<h2>Edit and send message</h2>

<form action="/form-submit" method="post">
    <div>
        From: <input type="text" name="from"/>
    </div>
    <div>
        To: <input type="text" name="to"/>
    </div>
    <div>
        Message: <input type="text" name="msg"/>
    </div>
    <div>
        <button type="submit">Send Message</button>
    </div>
</form>

</body>
</html>
