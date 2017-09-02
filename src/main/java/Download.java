import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

/**
 * Created by nephrite on 02.09.17.
 */
public class Download {
    ArrayList<Car> carsAvailable;


    public Download(ArrayList<Car> carsAvailable)  {
        this.carsAvailable = carsAvailable;
    }

    public String Ser(ArrayList<Car> carsAvailable) throws JsonProcessingException {

        ObjectMapper o = new ObjectMapper();
        String string = o.writeValueAsString(carsAvailable);
        return  string;
    }

    public void toFile(String string) {}

}
