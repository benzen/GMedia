package gmedia

/**
  *
  * @author Benjamin Dreux(benjiiiiii@gmail.com)
  */


class PlayerTagLib {
 def playSingleMusic={
    attrs -> 
      out << '''\
  <script type="text/javascript">

$(document).ready(function() {
		var playItem = 0;

	var myPlayList = [
			  {name:"'''+attrs["music"].title+'''",
			   mp3:"'''+attrs["music"].mp3Path+'''",
			   ogg:"'''+attrs["music"].oggPath+'''"}];
	
	// Local copy of jQuery selectors, for performance.
	var jpPlayTime = $("#jplayer_play_time");
	var jpTotalTime = $("#jplayer_total_time");
	
	$("#jquery_jplayer").jPlayer({
		ready: function() {
		    displayPlayList();
		    playListInit(true); // Parameter is a boolean for autoplay.
		},
		    oggSupport: true
		    })
	    .jPlayer("onProgressChange", function(loadPercent, playedPercentRelative, playedPercentAbsolute, playedTime, totalTime) {   jpPlayTime.text($.jPlayer.convertTime(playedTime));
		jpTotalTime.text($.jPlayer.convertTime(totalTime));
	     })
	    .jPlayer("onSoundComplete", function() {   playListNext(); });
	
	$("#jplayer_previous").click( function() {
		playListPrev();
		$(this).blur();
		return false;
	    });
 
	$("#jplayer_next").click( function() {
		playListNext();
		$(this).blur();
		return false;
	    });
	
	function displayPlayList() {
	    $("#jplayer_playlist ul").empty();
	    for (i=0; i < myPlayList.length; i++) {
		var listItem = (i == myPlayList.length-1) ?
		    "<li class='jplayer_playlist_item_last'>" 
		    : "<li>";
		listItem += "<a href='#' id='jplayer_playlist_item_"+i+"' tabindex='1'>"+ myPlayList[i].name +"</a></li>";
		$("#jplayer_playlist ul").append(listItem);
		$("#jplayer_playlist_item_"+i).data( "index", i ).click( function() {
			var index = $(this).data("index");
			if (playItem != index) {
			    playListChange( index );
			} else {
			    $("#jquery_jplayer").jPlayer("play");
			}
			$(this).blur();
			return false;
		    });
	    }
	}
	
	function playListInit(autoplay) {
	    if(autoplay) {
		playListChange( playItem );
	    } else {
		playListConfig( playItem );
	    }
	}
	
	function playListConfig( index ) {
	    $("#jplayer_playlist_item_"+playItem).removeClass("jplayer_playlist_current").parent().removeClass("jplayer_playlist_current");
	    $("#jplayer_playlist_item_"+index).addClass("jplayer_playlist_current").parent().addClass("jplayer_playlist_current");
	    playItem = index;
	    $("#jquery_jplayer").jPlayer("setFile", myPlayList[playItem].mp3, myPlayList[playItem].ogg);
	}
	
	function playListChange( index ) {
	    playListConfig( index );
	    $("#jquery_jplayer").jPlayer("play");
	}
	
	function playListNext() {
	    var index = (playItem+1 < myPlayList.length) ? playItem+1 : 0;
	    playListChange( index );
	}
	
	function playListPrev() {
	    var index = (playItem-1 >= 0) ? playItem-1 : myPlayList.length-1;
	    playListChange( index );
	}
    });
</script>

  <div id="jquery_jplayer"></div> 
  
  <div class="jp-playlist-player"> 
    <div class="jp-interface"> 
      <ul class="jp-controls"> 
	<li><a href="#" id="jplayer_play" class="jp-play" tabindex="1">play</a></li> 
	<li><a href="#" id="jplayer_pause" class="jp-pause" tabindex="1">pause</a></li> 
	<li><a href="#" id="jplayer_stop" class="jp-stop" tabindex="1">stop</a></li> 
	<li><a href="#" id="jplayer_volume_min" class="jp-volume-min" tabindex="1">min volume</a></li> 
	<li><a href="#" id="jplayer_volume_max" class="jp-volume-max" tabindex="1">max volume</a></li> 
	<li><a href="#" id="jplayer_previous" class="jp-previous" tabindex="1">previous</a></li> 
	<li><a href="#" id="jplayer_next" class="jp-next" tabindex="1">next</a></li> 
      </ul> 
      <div class="jp-progress"> 
	<div id="jplayer_load_bar" class="jp-load-bar"> 
	  <div id="jplayer_play_bar" class="jp-play-bar"></div> 
	</div> 
      </div> 
      <div id="jplayer_volume_bar" class="jp-volume-bar"> 
	<div id="jplayer_volume_bar_value" class="jp-volume-bar-value"></div> 
      </div> 
      <div id="jplayer_play_time" class="jp-play-time"></div> 
      <div id="jplayer_total_time" class="jp-total-time"></div> 
    </div> 
    <div id="jplayer_playlist" class="jp-playlist"> 
      <ul> 
	<!-- The function displayPlayList() uses this unordered list --> 
	<li></li> 
      </ul> 
    </div> 
  </div> 
'''	
}
}
