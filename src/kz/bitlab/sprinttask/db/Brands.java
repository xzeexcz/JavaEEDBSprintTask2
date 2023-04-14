package kz.bitlab.sprinttask.db;

public class Brands {
    private Long id;
    private String name;
    private String Country;

    public Brands(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        Country = country;
    }

    public Brands() {
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

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }
}
