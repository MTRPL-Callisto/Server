package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GlobalModel {
    private final List<Category> categories = new ArrayList();
    
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
}
