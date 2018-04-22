package Models;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Image implements Comparable{
    private String title;
    private byte[] image;
    private int photoId;

    public Image() {
    }

    public Image(String title, byte[] image) {
        String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH:mm:ss").format(new Date());
        this.title = title + "_img_" + timeStamp;
        this.image = image;
    }
    

    @XmlElement
    public String getTitle() {
        return title.substring(0, title.indexOf("_img_"));
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


    public void setImage(byte[] image) {
        this.image = image;
    }
    
    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
    
    @XmlElement
    public int getPhotoId() {
        return this.photoId;
    }
    
    @Override
    public int compareTo(Object o) {
        return this.photoId - ((Image)o).getPhotoId();
    } 
    
}
