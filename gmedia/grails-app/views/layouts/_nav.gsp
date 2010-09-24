 <div id="nav">
            <div class="homePagePanel">
                <div class="panelTop"></div>
                <div class="panelBody">
		<ul>
		  <li><g:link controller="music">Play random song</g:link></li>
        	  <li><g:link controller="playlist">Manage Playlists</g:link></li>	
        	  <li><g:link controller="music" action="list">Manage   Track</g:link></li>		
		</ul>
		<g:if test="${session.user}">
		<h1>Admin</h1>
		<ul>
                   <li>
		     <g:def var="user" value="${session.user}"/>
		     <g:link controller="user" action="show" >Profile</g:link>
		   </li>
		 </ul>
		 </g:if>
                </div>
                <div class="panelBtm"></div>
            </div>
        </div>