import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song>songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }
    public boolean addSong(String name,double duration){
         if(findSong(name)==null){
             songs.add(new Song(name,duration));
             System.out.println(name +" added Successfully.");
             return true;
         }
         else{
             System.out.println(name+" already exist in the album.");
             return false;
         }
    }

    private Song findSong(String name) {
        for(Song checkSong : songs){
            if(checkSong.getTitle().equals(name)) return checkSong;
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song>playlist){
        int idx = trackNumber-1;
        if(idx > 0 && idx <= this.songs.size()){
            playlist.add(this.songs.get(idx));
            return true;
        }
        System.out.println("This album does not have song with this tack number");
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song>playlist ){
        for(Song chkSong:songs){
            if (chkSong.getTitle().equals(title)){
                playlist.add(chkSong);
                return true;
            }
        }
        System.out.println(title+".. there is no such song in the album");
        return false;
    }
}
