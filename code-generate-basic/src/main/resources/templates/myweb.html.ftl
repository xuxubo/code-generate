<!DOCTYPE html>
<html>
<head>
    <title>My Web Page</title>
</head>
<body>
<h1>Hello, World!</h1>
<ul>
    <#list menuItems as item>
        <li><a href="${item.url}">${item.label}"></a> </li>
    </#list>
</ul>
<footer>
    ${currentYear} 官网
</footer>

</body>
</html>