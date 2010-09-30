

<%@ page import="gmedia.domain.Music" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'music.label', default: 'Music')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${musicInstance}">
            <div class="errors">
                <g:renderErrors bean="${musicInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${musicInstance?.id}" />
                <g:hiddenField name="version" value="${musicInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="author"><g:message code="music.author.label" default="Author" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: musicInstance, field: 'author', 'errors')}">
                                    <g:select name="author.id" from="${gmedia.domain.Person.list()}" optionKey="id" value="${musicInstance?.author?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="length"><g:message code="music.length.label" default="Length" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: musicInstance, field: 'length', 'errors')}">
                                    <g:textField name="length" value="${fieldValue(bean: musicInstance, field: 'length')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="mp3Path"><g:message code="music.mp3Path.label" default="Mp3 Path" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: musicInstance, field: 'mp3Path', 'errors')}">
                                    <g:textField name="mp3Path" value="${musicInstance?.mp3Path}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="nbRead"><g:message code="music.nbRead.label" default="Nb Read" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: musicInstance, field: 'nbRead', 'errors')}">
                                    <g:textField name="nbRead" value="${fieldValue(bean: musicInstance, field: 'nbRead')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="nbSkip"><g:message code="music.nbSkip.label" default="Nb Skip" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: musicInstance, field: 'nbSkip', 'errors')}">
                                    <g:textField name="nbSkip" value="${fieldValue(bean: musicInstance, field: 'nbSkip')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="oggPath"><g:message code="music.oggPath.label" default="Ogg Path" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: musicInstance, field: 'oggPath', 'errors')}">
                                    <g:textField name="oggPath" value="${musicInstance?.oggPath}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="title"><g:message code="music.title.label" default="Title" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: musicInstance, field: 'title', 'errors')}">
                                    <g:textField name="title" value="${musicInstance?.title}" />
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
