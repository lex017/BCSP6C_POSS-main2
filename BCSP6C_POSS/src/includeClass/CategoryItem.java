package includeClass;


public class CategoryItem {
    private String id;
    private String name;

    public CategoryItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id +"="+ name;
    }
    
    
}
