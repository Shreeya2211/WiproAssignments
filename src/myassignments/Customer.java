package myassignments;

public class Customer {
    public Long id;
    public String name;
    public Integer tier;

    public Customer(Long id, String name, Integer tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    public String toString() {
        return name + " (Tier " + tier + ")";
    }
}
