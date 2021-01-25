package lastfm.api.user;

import lastfm.api.Base;
import lastfm.user.RecentTrack;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class GetRecentTracks extends Base {

    public GetRecentTracks(Logger logger) {
        super(logger);
    }

    public RecentTrack get(String user) throws JAXBException, IOException {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("user", user);

        JAXBContext context = JAXBContext.newInstance(RecentTrack.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return  (RecentTrack) unmarshaller.unmarshal(new StringReader(this.getRequest("user.getrecenttracks", parameters)));

    }
}
