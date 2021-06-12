import java.util.HashMap;
import java.util.Set;
public class TrackList {
    public static void main(String[] args){
        HashMap<String, String> trackList = new HashMap<String,String>();
        trackList.put("Dream On","Dream On, Maybe tomorrow, the good Lord will take you away");
        trackList.put("Hole in my Soul","The punishment sometimes, Don't seem to fit the crime");
        trackList.put("No more","Blood stains the ivories");
        trackList.put("Living on the edge","There's something wrong with the world today");
        String firstSong = trackList.get("Dream On");
        Set<String> trackTitles = trackList.keySet();
        for (String trackTitle : trackTitles) {
            System.out.print(trackTitle +": ");
            System.out.println(trackList.get(trackTitle)); 
        }
    }
}