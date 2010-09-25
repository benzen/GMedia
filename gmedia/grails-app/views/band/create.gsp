

<%@ page import="gmedia.model.Band" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'band.label', default: 'Band')}" />
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
            <g:hasErrors bean="${bandInstance}">
            <div class="errors">
                <g:renderErrors bean="${bandInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" enctype="multipart/form-data">
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name"><g:message code="band.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: bandInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${bandInstance?.name}" />
                                </td>
                            </tr>
<tr class="prop">
      <td valign="top" class="name">
         <label for="logoPath"><g:message code="band.logoPath.label" default="Logo Path" /></label>
      </td>
      <td valign="top" class="value ${hasErrors(bean: bandInstance, field: 'logoPath', 'errors')}">
         <!-- et là un input file -->
         <input type="file" name="logoFile"/>
      </td>
   </tr>                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="webSite"><g:message code="band.webSite.label" default="Web Site" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: bandInstance, field: 'webSite', 'errors')}">
                                    <g:textField name="webSite" value="${bandInstance?.webSite}" />
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