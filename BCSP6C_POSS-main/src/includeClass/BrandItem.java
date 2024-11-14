package includeClass;


public class BrandItem {
    private String id;
    private String name;

    public BrandItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id +"="+ name;
    }
    
    
}
