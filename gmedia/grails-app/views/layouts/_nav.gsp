 <div id="nav">
            <div class="homePagePanel">
                <div class="panelTop"></div>
                <div class="panelBody">
		<ul>
                  <li><g:link controller="album">Manage Albums</g:link>
                    <ul>
                      <li><g:link controller="album" action="create">Create Album</g:link></li>
                      <li><g:link controller="album" action="list">List Album</g:link></li>
                    </ul>	
                  </li>
         	  <li><g:link controller="band">Manage Band</g:link>
         	    <ul>
                      <li><g:link controller="band" action="create">Create Band</g:link></li>
                      <li><g:link controller="band" action="list">List Band</g:link></li>
                    </ul>	
                  </li>
        	  <li><g:link controller="music">Manage Track</g:link>
         	    <ul>
                      <li><g:link controller="music" action="create">Create Track</g:link></li>
                      <li><g:link controller="music" action="list">List Track</g:link></li>
                    </ul>	
                  </li>
            	  <li><g:link controller="person">Manage Author</g:link>
         	    <ul>
                      <li><g:link controller="person" action="create">Create Author</g:link></li>
                      <li><g:link controller="person" action="list">List Author</g:link></li>
                    </ul>	
                  </li>
            	  <li><g:link controller="playlist">Manage Playlists</g:link>
         	    <ul>
                      <li><g:link controller="playlist" action="create">Create Playlist</g:link></li>
                      <li><g:link controller="playlist" action="list">List Playlist</g:link></li>
                    </ul>	
                  </li>
            	  <li><g:link controller="style">Manage Styles</g:link>
         	    <ul>
                      <li><g:link controller="style" action="create">Create Style</g:link></li>
                      <li><g:link controller="style" action="list">List Styles</g:link></li>
                    </ul>	
                  </li>
		  <li><g:link controller="music" action="play" >Player</g:link></li>
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
