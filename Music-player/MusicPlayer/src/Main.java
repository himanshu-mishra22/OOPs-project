import java.util.*;

public class Main {
    private static ArrayList<Album>albums = new ArrayList<>();
    public static void main(String[] args) {


        Album album = new Album("Album1","AC/DC");
        album.addSong("TNT",4.5);
        album.addSong("Highway to hell", 3.6);
        album.addSong("ThunderStruck", 5.0);
        albums.add(album);

        album = new Album("Album2","Arijit Singh");
        album.addSong("Phir bhi tum chahunga",5.2);
        album.addSong("Phir le aaya dil",4.6);
        album.addSong("Tera Fitoor", 2.4);
        albums.add(album);

        LinkedList<Song>playlist_1 = new LinkedList<>();
        albums.get(0).addToPlayList("TNT",playlist_1);
        albums.get(1).addToPlayList("Tera Fitoor",playlist_1);
        albums.get(0).addToPlayList("ThunderStruck",playlist_1);

        play(playlist_1);

    }

    private static void play(LinkedList<Song> playlist) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song>listIterator = playlist.listIterator();
        if(playlist.isEmpty()){
            System.out.println("This playlist has no song");
        }else{
            System.out.println("Now playing"+ listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();
            switch(action){
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing: "+listIterator.next().toString());
                    }else{
                        System.out.println("No song available, reached end of the playlist");
                        forward= false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing: "+listIterator.previous().toString());
                    }else{
                        System.out.println("No song available, first song of the playlist");
                        forward= false;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing: "+listIterator.previous().toString());
                            forward=true;
                        }else
                        {
                            System.out.println("Reached end of the list");
                        }
                    }else{
                        if(listIterator.hasNext()){
                            System.out.println("Now playing "+listIterator.next().toString());
                            forward=true;
                        }else{
                            System.out.println("Reached end of the playlist");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    if(playlist.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing: "+listIterator.next().toString());
                        }
                        else{
                            if (listIterator.hasPrevious())
                                System.out.println("Now playing: "+listIterator.previous().toString());
                        }
                    }

            }
        }


    }

    private static void printMenu(){
        System.out.println("Availabe Options \n press");
        System.out.println("0 - To quit\n"+
                "1 - To play next Song\n"+
                "2 - To play previous Song\n"+
                "3 - To replay the current song\n"+
                "4 - List of all songs\n"+
                "5 - Delete current song");
    }

    private static void printList(LinkedList<Song>playList){
        Iterator<Song> iterator = playList.iterator();
        System.out.println("=======================");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=======================");

    }
}