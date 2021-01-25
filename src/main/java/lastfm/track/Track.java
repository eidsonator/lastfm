package lastfm.track;

import lastfm.Image;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "track")
public class Track {

    private String artist;
    private Boolean nowPlaying = false;
    private String name;
    private List<Image> imageList;

    @XmlElement(name = "artist")
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @XmlAttribute(name = "nowplaying")
    public Boolean getNowPlaying() {
        return nowPlaying;
    }

    public void setNowPlaying(Boolean nowPlaying) {
        this.nowPlaying = nowPlaying;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "image")
    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public Image getImage()
    {
        return this.getImage(Image.EXTRA_LARGE);
    }

    public Image getImage(String size)
    {
        for (Image image : getImageList()) {
            if (image.getSize().equals(size)) {
                return image;
            }
        }
        return null;
    }
}
