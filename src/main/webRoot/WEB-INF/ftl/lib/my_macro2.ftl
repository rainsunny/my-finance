<#macro html title="My Accounting">
<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
</head>
<body>
    <#nested >
</body>
</html>
</#macro>


<@html>
    <h2>This is a template!</h2>
</@html>

