<html>
    <head>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="stylesheet" href="${resource(dir:'css',file:'jplayer-bluemonday.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
	<g:javascript library="application" />
	<g:javascript library="jquery" />
	<g:javascript library="jquery.jplayer" />

    </head>
    <body>
      <g:render template="/layouts/header"/>
        <g:layoutBody />
    </body>
</html>
