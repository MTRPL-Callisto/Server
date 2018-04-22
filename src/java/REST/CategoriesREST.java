/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import Models.Category;
import Models.GlobalModel;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author iosdev
 */
@Path("categories")
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
    
}
