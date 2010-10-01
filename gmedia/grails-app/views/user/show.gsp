<head>
	<meta name="layout" content="main" />
	<title>Show User</title>
</head>

<body>
  <div class="body">
    <h1>Your Profile</h1>
    <div class="dialog">
      <table>
        <tbody>
          <tr class="prop">
            <td valign="top" class="name">Name:</td>
            <td valign="top" class="value">${user.name?.encodeAsHTML()}</td>
          </tr>
          <tr class="prop">
            <td valign="top" class="name">Email:</td>
            <td valign="top" class="value">${user.email?.encodeAsHTML()}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="buttons">
      <g:form>
        <input type="hidden" name="id" value="${user.id}" />
          <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
      </g:form>
    </div>
  </div>
</body>
