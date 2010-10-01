

<%@ page import="gmedia.domain.Playlist" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'playlist.label', default: 'Playlist')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${playlistInstance}">
            <div class="errors">
                <g:renderErrors bean="${playlistInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${playlistInstance?.id}" />
                <g:hiddenField name="version" value="${playlistInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="styles"><g:message code="playlist.styles.label" default="Styles" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: playlistInstance, field: 'styles', 'errors')}">
                                    <g:select name="styles" from="${gmedia.domain.Style.list()}" multiple="yes" optionKey="id" size="5" value="${playlistInstance?.styles*.id}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="playlist.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: playlistInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${playlistInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="tracks"><g:message code="playlist.tracks.label" default="Tracks" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: playlistInstance, field: 'tracks', 'errors')}">
                                    <g:select name="tracks" from="${gmedia.domain.Music.list()}" multiple="yes" optionKey="id" size="5" value="${playlistInstance?.tracks*.id}" />
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
