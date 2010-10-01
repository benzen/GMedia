
<%@ page import="gmedia.domain.Music" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'music.label', default: 'Music')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="music.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: musicInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="music.author.label" default="Author" /></td>
                            
                            <td valign="top" class="value"><g:link controller="person" action="show" id="${musicInstance?.author?.id}">${musicInstance?.author?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="music.length.label" default="Length" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: musicInstance, field: "length")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="music.mp3Path.label" default="Mp3 Path" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: musicInstance, field: "mp3Path")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="music.nbRead.label" default="Nb Read" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: musicInstance, field: "nbRead")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="music.nbSkip.label" default="Nb Skip" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: musicInstance, field: "nbSkip")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="music.oggPath.label" default="Ogg Path" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: musicInstance, field: "oggPath")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="music.title.label" default="Title" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: musicInstance, field: "title")}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${musicInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
