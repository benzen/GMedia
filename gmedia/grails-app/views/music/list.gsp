
<%@ page import="gmedia.domain.Music" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'music.label', default: 'Music')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                                           
                          <th><g:message code="music.author.label" default="Author" /></th>
                        
			   <g:sortableColumn property="Title" 
			     title="${message(code: 'music.title.label', default: 'Title')}" /> 
			   
			   <g:sortableColumn property="Album" 
			     title="${message(code: 'music.album.label', default: 'Album')}" />                         
                           
			   <g:sortableColumn property="length" 
			     title="${message(code: 'music.length.label', default: 'Length')}" />
			   
                           <g:sortableColumn property="nbRead" 
			   title="${message(code: 'music.nbRead.label', default: 'Nb Read')}" />
                        
                            <g:sortableColumn property="nbSkip" 
			    title="${message(code: 'music.nbSkip.label', default: 'Nb Skip')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${musicInstanceList}" status="i" var="musicInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                                          
                            <td>${fieldValue(bean: musicInstance, field: "author")}</td>

                            <td>${fieldValue(bean: musicInstance, field: "title")}</td>	
			    
                            <td>${fieldValue(bean: musicInstance, field: "album")}</td>	
                            
						    <td>${fieldValue(bean: musicInstance, field: "length")}</td>
                                             
                            <td>${fieldValue(bean: musicInstance, field: "nbRead")}</td>
                        
                            <td>${fieldValue(bean: musicInstance, field: "nbSkip")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${musicInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
