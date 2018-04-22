package Models;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Image {
    private String title;
    private byte[] image;
    private int photoId;

    public Image() {
    }

    @XmlElement
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH:mm:ss").format(new Date());
        this.title = title + "_img_" + timeStamp;
    }

    @XmlElement
    public String getPhotoInBase64() {
        return Base64.getEncoder().encodeToString(image);
    }
    
    public byte[] getImage() {
        return image;
    }

    public void setImage(String photoInBase64) {
        byte[] image = Base64.getDecoder().decode(photoInBase64);
        this.image = image;
    }
    
    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
    
    @XmlElement
    public int getPhotoId() {
        return this.photoId;
    }
    
    
}
