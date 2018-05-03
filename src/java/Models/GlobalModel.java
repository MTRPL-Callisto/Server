package Models;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        //Recycling Points
        Point2D.Double sello = new Point2D.Double(60.21820809999999, 24.811967600000003);
        Point2D.Double HMARC = new Point2D.Double(60.2198613, 24.664098100000047);
        Point2D.Double giganttiForum = new Point2D.Double(60.169132, 24.937878899999987);
        Point2D.Double verkkokauppa = new Point2D.Double(60.15638089999999, 24.92093729999999);
        Point2D.Double giganttiLommila = new Point2D.Double(60.2198613, 24.664098100000047);
        Point2D.Double sorttiAsemaKonala = new Point2D.Double(60.25141129999999, 24.83332489999998);
        Point2D.Double sorttiAsemaRuskeasanta = new Point2D.Double(60.321016, 24.99305800000002);
        Point2D.Double sorttiAsemaKivikko = new Point2D.Double(60.236787,25.05102599999998);
        Point2D.Double sMarketKonala = new Point2D.Double(60.24477779999999, 24.846507100000053);
        Point2D.Double kMarketKilo = new Point2D.Double(60.21699820000001, 24.78197499999999);
        
        //Plastic
        Set<Point2D.Double> recyclingPoints1 = new HashSet<>();
        
        recyclingPoints1.add(sello);
        recyclingPoints1.add(HMARC);
        recyclingPoints1.add(sMarketKonala);
        recyclingPoints1.add(kMarketKilo);
        
        Category plastic = new Category("Plastic", 1, "Many types of plastics are accepted by commercial recyclers by contract or as part of co-mingled recycling, where they collected, shredded and extruded for use in new plastic products.", recyclingPoints1);
        
        //Paper & Cardboard
        Set<Point2D.Double> recyclingPoints2 = new HashSet<>();
        
        recyclingPoints2.add(sello);
        recyclingPoints2.add(HMARC);
        recyclingPoints2.add(sorttiAsemaKonala);
        recyclingPoints2.add(sMarketKonala);
        recyclingPoints2.add(sorttiAsemaRuskeasanta);
        recyclingPoints2.add(sorttiAsemaKivikko);
        recyclingPoints2.add(kMarketKilo);
        
        Category paperAndCardboard = new Category("Paper & Cardboard", 2, "Clean mixed paper and cardboard is recycled into a variety of paper products. Lower grade products can be recycled or composted as organic waste.", recyclingPoints2);
    
        //Metal
        Set<Point2D.Double> recyclingPoints3 = new HashSet<>();
        
        recyclingPoints3.add(sello);
        recyclingPoints3.add(HMARC);
        recyclingPoints3.add(sorttiAsemaKonala);
        recyclingPoints3.add(sMarketKonala);
        recyclingPoints3.add(sorttiAsemaRuskeasanta);
        recyclingPoints3.add(sorttiAsemaKivikko);
        recyclingPoints3.add(kMarketKilo);
        
        Category metal = new Category("Metal", 3, "Making products from recycled metals uses less energy, reduces carbon emissions and uses less water compared with using raw materials.", recyclingPoints3);
    
        //Glass
        Set<Point2D.Double> recyclingPoints4 = new HashSet<>();
        
        recyclingPoints4.add(sello);
        recyclingPoints4.add(HMARC);
        recyclingPoints4.add(sorttiAsemaKonala);
        recyclingPoints4.add(sMarketKonala);
        recyclingPoints4.add(sorttiAsemaRuskeasanta);
        recyclingPoints4.add(sorttiAsemaKivikko);
        recyclingPoints4.add(kMarketKilo);
        
        Category glass = new Category("Glass", 4, "Glass is completely recyclable and saves precious energy resources. Making products from recycled glass uses less energy than starting from scratch. Recycled glass is made into new beverage bottles, food jars, insulation and other construction materials.", recyclingPoints4);
    
        //Electrical Waste
        Set<Point2D.Double> recyclingPoints5 = new HashSet<>();
        
        recyclingPoints5.add(HMARC);
        recyclingPoints5.add(giganttiForum);
        recyclingPoints5.add(verkkokauppa);
        recyclingPoints5.add(giganttiLommila);
        recyclingPoints5.add(sorttiAsemaKonala);
        recyclingPoints5.add(sorttiAsemaRuskeasanta);
        recyclingPoints5.add(sorttiAsemaKivikko);
        
        Category electricalWaste = new Category("Electrical Waste", 5, "The volume of e-waste is growing three times faster than other waste streams. Used electronic equipment contains valuable resources such as precious metals and can be toxic to the environment if placed in landfill.", recyclingPoints5);
    
        //Add categories to list
        categories.add(plastic);
        categories.add(paperAndCardboard);
        categories.add(metal);
        categories.add(glass);
        categories.add(electricalWaste);
        
    }

}
