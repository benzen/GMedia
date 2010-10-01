 <div id="nav">
            <div class="homePagePanel">
                <div class="panelTop"></div>
                <div class="panelBody">
		<ul>
                  <li><g:link controller="album">Manage Albums</g:link></li>	
         	  <li><g:link controller="band">Manage Band</g:link></li>		 
        	  <li><g:link controller="music">Manage Track</g:link></li>		
            	  <li><g:link controller="person">Manage Author</g:link></li>		         	                    
            	  <li><g:link controller="playlist">Manage Playlists</g:link></li>	
            	  <li><g:link controller="style">Manage Styles</g:link></li>	
		  <li><g:link controller="player">Player</g:link></li>
		</ul>
		<g:if test="${session.user}">
		<h1>Admin</h1>
		<ul>
                   <li>
		     <g:def var="user" value="${session.user}"/>
		     <g:link controller="user" action="show"  >Profile</g:link>
		   </li>
		 </ul>
		 </g:if>
                </div>
                <div class="panelBtm"></div>
            </div>
        </div>
