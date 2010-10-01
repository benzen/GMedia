

<%@ page import="gmedia.domain.Album" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'album.label', default: 'Album')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
      </head>
    <body>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${albumInstance}">
            <div class="errors">
                <g:renderErrors bean="${albumInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${albumInstance?.id}" />
                <g:hiddenField name="version" value="${albumInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="album.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: albumInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${albumInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="author"><g:message code="album.author.label" default="Author" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: albumInstance, field: 'author', 'errors')}">
                                    <g:select name="author.id" from="${gmedia.domain.Author.list()}" optionKey="id" value="${albumInstance?.author?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="logoPath"><g:message code="album.logoPath.label" default="Logo Path" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: albumInstance, field: 'logoPath', 'errors')}">
                                    <g:textField name="logoPath" value="${albumInstance?.logoPath}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="styles"><g:message code="album.styles.label" default="Styles" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: albumInstance, field: 'styles', 'errors')}">
                                    <g:select name="styles" from="${gmedia.domain.Style.list()}" multiple="yes" optionKey="id" size="5" value="${albumInstance?.styles*.id}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="tracks"><g:message code="album.tracks.label" default="Tracks" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: albumInstance, field: 'tracks', 'errors')}">
                                    
<ul>
<g:each in="${albumInstance?.tracks?}" var="t">
    <li><g:link controller="music" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="music" action="create" params="['album.id': albumInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'music.label', default: 'Music')])}</g:link>

                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
