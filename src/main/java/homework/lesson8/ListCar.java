package homework.lesson8;

import com.google.gson.Gson;

import java.io.*;

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public class ListCar {
    private int nextId;
    private List<Car> listCar = new ArrayList<>();

    public ListCar() {
        this.nextId = 1;
    }


    public void add(String model, int year, double price, String vinCode) {
        listCar.add(new Car (nextId++, model.toUpperCase(), year, price, vinCode.toUpperCase() ));
    }

    public void remove(int id){
        if (id < this.nextId) {
            listCar.removeIf(car -> car.getId() == id);
        }
    }

     private void printList(List<Car> cars) {
        cars.forEach(System.out::println);
    }

    public void readingFromFile(String path) {
        Gson gson = new Gson();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            int count = 0;
            while (line != null) {
                Car car = gson.fromJson(line, Car.class);
//                listCar.remove(car.getId());
                listCar.add(car);
                count++;
                line = reader.readLine();
                if (car.getId() > nextId) {
                    nextId = car.getId() + 1;
                }
            }
            System.out.println("Данные загружены. Добавлено " + count + " авто");
        }
        catch (IOException e) {
            System.out.println("Something wrong with file");
        }
    }

    public void saveInfoToFile(String path) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(path)) {
            for (Car c: listCar) {
                String s = gson.toJson(c);
                writer.write(s + "\n");
            }
            System.out.println("Данные сохранены.");
         } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortCartoUpperYears(String model, int age) {
        int curYear =  Year.now().getValue();
        listCar.stream()
                .filter(c -> c.getModel().equalsIgnoreCase(model))
                .filter(c -> curYear - c.getYear() >= age)
                .sorted(Comparator.comparing(Car::getYear))
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    public void filtrToPrice(int year, double price) {
         listCar.stream()
                .filter(c -> c.getYear()==year)
                .filter(c -> c.getPrice() > price)
                .sorted(Comparator.comparing(Car::getYear))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public void sortByPrice() {
        listCar.stream()
                .sorted(Comparator.comparing(Car::getPrice).reversed()
                .thenComparing(Car::getYear))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private Set<String> getlistModels() {
        Set<String> set = new HashSet<>();
        listCar.forEach(car->set.add(car.getModel()));
        return set;
    }

    public void printListModels() {
        Set <String> set = getlistModels();
        set.forEach(System.out::println);
    }

    public void listCarsByModel() {
        Set <String> set = getlistModels();
        for (String s: set) {
            System.out.println(s);
            listCar.stream()
                    .filter(car -> car.getModel().equalsIgnoreCase(s))
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
        }
    }

    public void printAllCar() {
        printList(listCar);
    }
}