package REST;

import Models.Category;
import Models.GlobalModel;
import Models.Image;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/categories")
public class CategoriesREST {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getCategories() {
        return GlobalModel.getInstance().getCategories();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addCategory(Category newCategory) {
        GlobalModel.getInstance().getCategories().add(newCategory);
        return "Recieved new category: " + newCategory.getCategoryId() + ". " + newCategory.getCategoryName();
    }
    
    @GET
    @Path("/{categoryName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategoryByName(@PathParam("categoryName") String categoryName) {
        return GlobalModel.getInstance().getCategoryByName(categoryName);
    }
    
    @GET
    @Path("/{categoryName}/images")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Image> getImagesInCategory(@PathParam("categoryName") String categoryName) {
        return GlobalModel.getInstance().getImagesInCategory(categoryName);
    }
}
