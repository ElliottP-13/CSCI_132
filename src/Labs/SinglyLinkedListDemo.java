package src.Labs;

/**
 * Created by pryor on 10/18/2018.
 */
public class SinglyLinkedListDemo {
    public static void main(String[] args) {
        SinglyLinkedList<String> airports = new SinglyLinkedList<>();
        String[] ports = new String[] {"SFO", "LAX", "SLC", "BOS", "BZN"};
        airports.buildFromArray(ports);

        System.out.println(airports.toString());
        System.out.println(airports.getNth(1));

        Song[] song = new Song[5];
        for(int x= 0; x < song.length; x++){
            song[x] = new Song("Song " + x, "Artist " + x);
        }

        SinglyLinkedList<Song> songs = new SinglyLinkedList<>();
        songs.buildFromArray(song);

        System.out.println(songs.toString());
    }
}
