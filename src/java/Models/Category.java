package Models;

import java.awt.geom.Point2D;
import java.util.Set;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Category implements Comparable {
    private String categoryName;
    private int categoryId;
    private String description;
    private Set<Point2D> recyclingPoints;
    
    public Category() {
      
    }

    public Category(String categoryName, int categoryId, String description, Set<Point2D> recyclingPoints) {
        this.categoryName = categoryName;
        this.categoryId = categoryId;
        this.description = description;
        this.recyclingPoints = recyclingPoints;
    }

    @XmlElement
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @XmlElement
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName ;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Point2D> getRecyclingPoints() {
        return recyclingPoints;
    }

    public void setRecyclingPoints(Set<Point2D> recyclingPoints) {
        this.recyclingPoints = recyclingPoints;
    }

    @Override
    public int compareTo(Object o) {
        return this.categoryId - ((Category)o).getCategoryId();
    } 
}
