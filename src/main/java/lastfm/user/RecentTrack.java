package lastfm.user;

import lastfm.track.Track;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

import static java.awt.SystemColor.info;

@XmlRootElement(name = "recenttracks")
@XmlAccessorType(XmlAccessType.NONE)
public class RecentTrack {

    private List<Track> tracks;

    @XmlElement(name = "track")
    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public Track getNowPlaying() {
        for (Track track: this.getTracks())
            if (track.getNowPlaying()) {
                return track;
            }
        return null;
    }
}
