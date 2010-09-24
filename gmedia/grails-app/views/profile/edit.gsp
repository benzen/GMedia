<head>
  <meta name="layout" content="main" />
  <title>Edit User</title>
</head>

<body>

  <div class="nav"></div>

  <div class="body">
    <h1>Edit your Profile</h1>
    <g:form >
      <input type="hidden" name="id" value="${user.id}" />
      <input type="hidden" name="name" value="${user.name?.encodeAsHTML()}" />
      <div class="dialog">
        <table>
          <tbody>
            <tr class="prop">
              <td valign="top" class="user"><label for="name">Full Name:</label></td>
              <td valign="top" class="value ${hasErrors(bean:user,field:'name','errors')}">
                <input type="text" id="name" name="name" value="${name?.encodeAsHTML()}"/>
              </td>
            </tr>
            <tr class="prop">
              <td valign="top" class="name"><label for="password">Password:</label></td>
              <td valign="top" class="value ${hasErrors(bean:user,field:'password','errors')}">
                <input type="password" id="password" name="password" value="${user.password?.encodeAsHTML()}"/>
              </td>
             </tr>
	     <tr class="prop">
               <td valign="top" class="name"><label for="confirmPassword">Confirm password:</label></td>
               <td valign="top" class="value ${hasErrors(bean:user,field:'confirmPassword','errors')}">
                 <input type="password" id="confirmPassword" name="confirmPassword" value="${user.password?.encodeAsHTML()}"/>
               </td>
             </tr>
             <tr class="prop">
               <td valign="top" class="name"><label for="email">Email:</label></td>
               <td valign="top" class="value ${hasErrors(bean:user,field:'email','errors')}">
                 <input type="text" id="email" name="email" value="${user?.email?.encodeAsHTML()}"/>
               </td>
             </tr>
           </tbody>
         </table>
       </div>
       <div class="buttons">
         <span class="button"><g:actionSubmit class="save" value="Update"/></span>
       </div>
     </g:form>
   </div>
</body>
