package Models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Category implements Comparable {
    private String categoryName;
    private int categoryId;
    
    public Category(String name, int id) {
        this.categoryName = name;
        this.categoryId = id;
    }
    
    public Category() {
      
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

    @Override
    public int compareTo(Object o) {
        return this.categoryId - ((Category)o).getCategoryId();
    } 
}
