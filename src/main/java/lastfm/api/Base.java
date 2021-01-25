package lastfm.api;

import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Base {
    protected Logger logger = null;

    public Base () {}

    public Base (Logger logger) {
        this.logger = logger;
    }

    protected String getRequest(String method, Map<String, String> parameters) throws IOException {
        String root = "http://ws.audioscrobbler.com/2.0/";
        String apiKey = System.getenv("last_fm_key");
        URL url = new URL(root + "?api_key=" + apiKey + "&method=" + method + "&" + ParameterStringBuilder.getParamsString(parameters));
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;

        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        String xml = content.toString().replace("<lfm status=\"ok\">", "").replace("</lfm>", "");
        if (logger != null) logger.debug(xml);
        in.close();
        con.disconnect();
        return xml;
    }

}
