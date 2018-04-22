package REST;

import Models.GlobalModel;
import Models.Image;
import java.util.Base64;
import java.util.List;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("images")
public class ImagesREST {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Image> getImages() {
        return GlobalModel.getInstance().getImages();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addImage(JsonObject jsonObject) {
        String photoInBase64 = jsonObject.getString("photoInBase64");
        String title = jsonObject.getString("title");
        
        byte[] image = Base64.getDecoder().decode(photoInBase64);
        
        Image newImage = new Image(title, image);
        
        GlobalModel.getInstance().addImage(newImage);
        return "Recieved new image: " + newImage.getTitle();
    }
}
