/**
 * Created by nephrite on 02.09.17.
 */
public class Car {
    private String name;
    private int price;
    private String manager;
    private int identifier;
    private Carcase carcase;

    public Car(String name, int price, String manager, int identifier, Carcase carcase) {
        this.name = name;
        this.price = price;
        this.manager = manager;
        this.identifier = identifier;
        this.carcase = carcase;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public Carcase getCarcase() {
        return carcase;
    }

    public void setCarcase(Carcase carcase) {
        this.carcase = carcase;
    }
}
