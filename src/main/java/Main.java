import org.omg.PortableInterceptor.ACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by nephrite on 02.09.17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Car> cars = new ArrayList<Car>();
        ArrayList<Car> carsForSale = new ArrayList<Car>();
        String fileName = "/home/nephrite/Desktop/Несохранённый документ 1";
        String fileNameforCarsSold = "/home/nephrite/Desktop/аывп";
        Action action = new Action();
        System.out.println("Введите пункт от 1 до 4: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int item = Integer.parseInt(bufferedReader.readLine());//считали пункт меню
        switch (item) {
            case 1:
                //должны добавить машинку в список и сазу сериализовать. создадим 4 машинки:
                for (int i = 0; i < 3; i++) {
                    action.createCar(cars);
                }
                //после того, как машинки созданы, сериализуем их в файл:
                action.serialization(cars, fileName);
                break;
            case 2:

                action.outputCars(action.deserialization(fileName));
                break;
            case 3:
                cars = (ArrayList<Car>) action.deserialization(fileName);
                action.outputCars(cars);
                action.createCarForSale(carsForSale, cars);//создаем машину в новом листе
                action.serialization(carsForSale, fileNameforCarsSold);
                break;
            case 4:
                cars = (ArrayList<Car>) action.deserialization(fileName);
                action.outputCars(cars);
                System.out.println("-------------------------------------------");
                carsForSale = (ArrayList<Car>) action.deserialization(fileNameforCarsSold);
                System.out.println();
                System.out.println();
                System.out.println();
                action.outputCars(carsForSale);
        }


    }
}
