<html>
<head>
  <meta name="layout" content="main" />
  <title>Gmedia Player</title>   



</head>
<body>

  <g:if test="${params.music}">
        <g:playSingleMusic music="${params.music}"/>
  </g:if>
</body>
</html>
