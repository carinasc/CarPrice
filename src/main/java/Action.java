import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nephrite on 03.09.17.
 */
public class Action {


    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String fileName = "/home/nephrite/Desktop/Несохранённый документ 1";
    public void createCar(ArrayList<Car> cars) throws IOException {

        System.out.println("Введите название (марка и модель): ");
        String nameCar = bufferedReader.readLine();
        System.out.println("Введите выберите тип: 1-легковой, 2-грузовой,3-мотоцикл");
        Carcase carcaseCar = null;
        int type = Integer.parseInt(bufferedReader.readLine());
        switch (type) {
            case 1:
                carcaseCar = Carcase.PASSENGERS;
                break;
            case 2:
                carcaseCar = Carcase.CARGO;
                break;
            case 3:
                carcaseCar = Carcase.MOTO;
                break;
        }


        Car car = new Car(nameCar, 0, null, cars.size() + 1, carcaseCar);
        cars.add(car);

    }


    public void createCarForSale(ArrayList<Car> carsForSale, ArrayList<Car> cars) throws IOException {

        System.out.println("Введите id выбранной машины: ");
        int idCar = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Введите имя менеджера: ");
        String manager = bufferedReader.readLine();
        System.out.println("Введите цену: ");
        int price = Integer.parseInt(bufferedReader.readLine());
        carsForSale.add(new Car(cars.get(idCar).getName(), price, manager, carsForSale.size()+1,cars.get(idCar).getCarcase()));
        cars.remove(idCar-1);
        PrintWriter printWriter = new PrintWriter(fileName);
        printWriter.write("");
        serialization(cars, fileName);
    }

    public void serialization(List a, String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String ser = objectMapper.writeValueAsString(a);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.write(ser);
        writer.newLine();
        writer.close();

    }

    public List<Car> deserialization(String fileName) throws IOException {
//считать из файла коллекцию машинок:
        BufferedReader reader = new BufferedReader(new FileReader(fileName));//создали ридер с указаниемпути к файлу
        String des = reader.readLine();//организовали десериализуемую строку, в которую сначала будем считывать список
        ObjectMapper objectMapper = new ObjectMapper();
        //дальше срзау делаем лист с требуемыми машинками
        ArrayList <Car> desCar = objectMapper.readValue(des, objectMapper.getTypeFactory().constructCollectionType(List.class, Car.class));

        return desCar;
    }
    public void outputCars(List <Car> a){
        for (int i = 0; i < a.size(); i++) {
            System.out.println("Автомобиль: " + a.get(i).getName() + " типа: " + a.get(i).getCarcase() + " с номером " + a.get(i).getId());
        }
    }
}
