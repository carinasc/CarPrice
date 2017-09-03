import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by nephrite on 02.09.17.
 */
public class Car {
    private String name;
    private int price;
    private String manager;
    private int id;
    private Carcase carcase;

    //перед конструктором
    @JsonCreator
    public Car(@JsonProperty("name")String name, @JsonProperty("price")int price, @JsonProperty("manager")String manager,
               @JsonProperty("id") int id, @JsonProperty("carcase")Carcase carcase) {
        this.name = name;
        this.price = price;
        this.manager = manager;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carcase getCarcase() {
        return carcase;
    }

    public void setCarcase(Carcase carcase) {
        this.carcase = carcase;
    }
}
