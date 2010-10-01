
<%@ page import="gmedia.domain.Album" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'album.label', default: 'Album')}" />
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
                                           
                            <g:sortableColumn property="name" title="${message(code: 'album.name.label', default: 'Name')}" />
                        
                            <th><g:message code="album.author.label" default="Author" /></th>
                        
                            <g:sortableColumn property="logoPath" title="${message(code: 'album.logoPath.label', default: 'Logo')}" />
                            <g:sortableColumn property="tracks" title="${message(code:'album.tracks.label', default:'Tracks')}"/>
                            <g:sortableColumn property="styles" title="${message(code:'album.styles.label', default:'Styles')}"/>
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${albumInstanceList}" status="i" var="albumInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                                             
                            <td>${fieldValue(bean: albumInstance, field: "name")}</td>
                            <td>${fieldValue(bean: albumInstance, field: "author")}</td>
                            <td>
                              <img src="${createLink(controller:'dl', action:'images', params: [id: albumInstance.logoPath])}"/>
                            </td>
                            <td>
                              <g:each in="${albumInstance.tracks}" var="t" status="j">
                              "${t.name}"<g:if test="albumInstance.tracks.size() != j">,</g:if>
                              </g:each>
                            </td>
                            <td>
                              <g:each in="${albumInstance.styles}" var="s" status="k">
                              "${s.name}"<g:if test="albumInstance.styles.size() != k">,</g:if>
                              </g:each>
                            </td>                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${albumInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
