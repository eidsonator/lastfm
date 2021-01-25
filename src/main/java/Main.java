import lastfm.Image;
import lastfm.api.user.GetInfo;
import lastfm.api.user.GetRecentTracks;
import lastfm.track.Track;
import lastfm.user.Info;
import lastfm.user.RecentTrack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {


    public static void main(String[] args) throws IOException, JAXBException {

        LogManager.getLogger("info.eidson").info("Logged");
        recentTracks();
        userInfo();

    }

    private static void recentTracks() throws IOException, JAXBException {
        Logger logger = LogManager.getLogger("info.eidson");

        GetRecentTracks getRecentTracks = new GetRecentTracks(logger);
        RecentTrack recentTracks = getRecentTracks.get("eidsonator");
        Track track = recentTracks.getNowPlaying();
        System.out.println(track.getArtist());
        System.out.println(track.getName());
        Image image = track.getImage();
        System.out.println(image.getValue());
    }

    private static void userInfo() throws IOException, JAXBException {
        Logger logger = LogManager.getLogger("info.eidson");
        GetInfo getInfo =  new GetInfo(logger);


        Info info = getInfo.get("eidsonator");

        System.out.println(info.getPlaycount());

    }

}
