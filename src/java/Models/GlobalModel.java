package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GlobalModel {
    private final List<Category> categories = new ArrayList();
    private final List<Image> images = new ArrayList();
    
    private GlobalModel() {
    }
    
    public static GlobalModel getInstance() {
        return GlobalModelHolder.INSTANCE;
    }
    
    private static class GlobalModelHolder {

        private static final GlobalModel INSTANCE = new GlobalModel();
    }
    
    public List<Category> getCategories() {
        Collections.sort(categories);
        return this.categories;
    }
    
    public List<Image> getImages() {
        Collections.sort(images);
        return this.images;
    }
    
    public void addImage(Image newImage) {
        int photoId;
        
        if(images.isEmpty()) {
            photoId = 1;
        }
        else {
            photoId = images.get(images.size()-1).getPhotoId() + 1;
        }
        
        newImage.setPhotoId(photoId);
        
        images.add(newImage);
    }
}
