package lastfm.api.user;

import lastfm.api.Base;
import lastfm.user.Info;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class GetInfo extends Base {

    public GetInfo(Logger logger) {
        super(logger);
    }

    public Info get(String user) throws JAXBException, IOException {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("user", user);

        JAXBContext context = JAXBContext.newInstance(Info.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Info) unmarshaller.unmarshal(new StringReader(getRequest("user.getinfo", parameters)));
    }
}
