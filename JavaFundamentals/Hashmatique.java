import java.util.HashMap;
import java.util.Set;
class Hashmatique {
    public static void main(String[] args){
        HashMap<String, String> trackList = new HashMap<String, String>();
        // adding songs and their lyrics
        trackList.put("In The End", "One thing, I don't know why");
        trackList.put("Numb", "I've become so numb");
        trackList.put("Super Human", "I'm a super human");
        trackList.put("Falling Up", "I fall up");
        // getting lyrics by song name
        System.out.println(trackList.get("Numb"));
        // print all tracks with their lyrics
        Set<String> keys = trackList.keySet();
        for(String key: keys) {
            System.out.printf("\n%s: %s\n", key, trackList.get(key));
        }
    }
}
