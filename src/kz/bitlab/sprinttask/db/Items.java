package kz.bitlab.sprinttask.db;

public class Items {
    private Long id;
    private String name;
    private String description;
    private double price;
    private Brands brands;

    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }

    public Items(Long id, String name, String description, double price, Brands brands) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.brands = brands;
    }

//    public Items(Long id, String name, String description, double price) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.price = price;
//    }

    public Items() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
