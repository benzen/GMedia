

<%@ page import="gmedia.domain.Music" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'music.label', default: 'Music')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${musicInstance}">
            <div class="errors">
                <g:renderErrors bean="${musicInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="author"><g:message code="music.author.label" default="Author" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: musicInstance, field: 'author', 'errors')}">
                                    <g:select name="author.id" from="${gmedia.domain.Person.list()}" optionKey="id" optionValue="firstName" value="${musicInstance?.author?.id}"  />
                                </td>
                            </tr>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="album"><g:message code="music.album.label" default="Album" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: musicInstance, field: 'album', 'errors')}">
                                    <g:select name="album.id" from="${gmedia.domain.Album.list()}" optionKey="id" optionValue="name" value="${musicInstance?.album?.id}"  />
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
                                                                     
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="mp3Path"><g:message code="music.mp3Path.label" default="Mp3" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: musicInstance, field: 'mp3Path', 'errors')}">
                                    <input type="file" name="mp3File"/>
                                </td>
                            </tr>
                     
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="oggPath"><g:message code="music.oggPath.label" default="Ogg" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: musicInstance, field: 'oggPath', 'errors')}">
                                    <input type="file" name="OggFile"/>
                                </td>
                            </tr>
                        

                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
