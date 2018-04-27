package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GlobalModel {
    private final List<Category> categories = new ArrayList();
    private final List<Image> images = new ArrayList();
    
    private GlobalModel() {
        initCategories();
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
    
    public Category getCategoryByName(String name) {
        for (Category c : categories) {
            if (c.getCategoryName().equals(name)) {
                return c;
            }
        }
        return null;
    }
    
    public List<Image> getImages() {
        Collections.sort(images);
        return this.images;
    }    
    
    public Image getImageById(int requestedId) {
        for (Image i : images) {
            if (i.getPhotoId() == requestedId) {
                return i;
            }
        }
        return null;
    }
    
    public List<Image> getImagesInCategory(String categoryName) {
        List<Image> imagesInCategory = new ArrayList();
        
        for (Image i : images) {
            if (i.getCategoryName().equals(categoryName)) {
                imagesInCategory.add(i);
            }
        }
        
        if (imagesInCategory.isEmpty()) return null;
        else return imagesInCategory;
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
    
    
    private void initCategories() {
        //TODO: add categories and their info
    }

}
