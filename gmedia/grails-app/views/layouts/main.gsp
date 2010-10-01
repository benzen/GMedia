<html>
    <head>
        <title>
	  <g:layoutTitle default="Grails" />
	</title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="stylesheet" href="${resource(dir:'css',file:'jplayer-bluemonday.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
	<g:javascript library="jquery" plugin="jquery"/>
	<jq:plugin name="jplayer"/>
	<jq:plugin name="ui"/>
<!--	<g:javascript library="application" /> -->
	<g:layoutHead />
	
    </head>
    <body>
      <g:render template="/layouts/header"/>
      <g:render template="/layouts/nav"/>
      <div  id="body">
	<g:if test="${flash.message}">
          <div class="message">${flash.message}</div>
	</g:if>
	<g:if test="${flash.error}">
          <div class="errors">${flash.error}</div>
	</g:if>
      </div>
      <g:layoutBody/>
    </body>
</html>
