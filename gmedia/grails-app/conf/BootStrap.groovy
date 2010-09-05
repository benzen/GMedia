import gmedia.Music
class BootStrap {

    def init = { servletContext ->
    new Music( title:"die another day", length:22, nbSkip:0, nbRead:0 ).save()    
    }
    def destroy = {
    }
}
