<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <link rel="stylesheet" href="/resources/static/style.css" type="text/css">
  <link rel="stylesheet" href="/resources/static/table_style.css" type="text/css">
  <script type="text/javascript" src="/resources/static/app.js"></script>

<title>Search</title>
</head>
<body>
  <h1>Search on StackExchange - Web application example</h1>
  <hr>
  <div class="form">
    <table>
      <tr>
        <td>Enter your title</td>
        <td><input id="title" name="title"></td>
        <td><button onclick="getRest()">Submit</button></td>
      </tr>
    </table>
    <div id="log"></div>
  </div>
  <div id="result"></div>
</body>
</html>