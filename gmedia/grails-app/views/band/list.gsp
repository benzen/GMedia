
<%@ page import="gmedia.domain.Band" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'band.label', default: 'Band')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                                             
                            <g:sortableColumn property="name" title="${message(code: 'band.name.label', default: 'Name')}" />                       
                            <g:sortableColumn property="albums" title="${message(code:'band.albums.label',default:'Album')}"/>
                            <g:sortableColumn property="styles" title="${message(code:'band.styles.label',default:'Styles')}"/>
                            <g:sortableColumn property="members" title="${message(code:'band.members.label',default:'Members')}"/>
                            <g:sortableColumn property="webSite" title="${message(code: 'band.webSite.label', default: 'Web Site')}" />
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${bandInstanceList}" status="i" var="bandInstance">
                      <g:link action="show" id="${bandInstance.id}">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                            <td>${fieldValue(bean: bandInstance, field: "name")}</td>
                            <td><g:each in="${bandInstance.albums}" var="a" status="j"  >
                                ${a.name}<g:if test="${!bandInstance.albums.size()==j}">,</g:if>
                              </g:each></td>
                            <td><g:each in="${bandInstance.styles}" var="s" status="k"  >
                                ${s.name}<g:if test="${!bandInstance.styles.size()==k}">,</g:if>
                              </g:each></td>
                            <td><g:each in="${bandInstance.members}" var="m" status="l"  >
                                ${m.name}<g:if test="${!bandInstance.members.size()==l}">,</g:if>
                              </g:each></td>
                            <td>${fieldValue(bean: bandInstance, field: "webSite")}</td>
                        </tr>
                        </g:link>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${bandInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
