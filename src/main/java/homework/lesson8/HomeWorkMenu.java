package homework.lesson8;

import java.util.Scanner;

public class HomeWorkMenu {
    static {
        menu="\n1. Добавить новую машину. \n" +
             "2. Удалить машину. \n" +
             "3. Считать машины с файла. \n" +
             "4. Сохранить список машин в файл \n" +
             "5. Сортировки и фильтры списка машин \n" +
             "6. Вывести все авто из списка. \n" +
             "7. Выход \n \n" +
             "Введите номер: " ;

        menuSortAndFilter="\n11. Вывести авто по заданной модели в порядке возрастания года выпуска. \n" +
                "12. Вывессти авто по заданной модели, которые эксплуатируются больше N лет. \n" +
                "13. Вывессти авто заданного года выпуска, цена которых больше указанной \n" +
                "14. Вывессти авто в порядке убывания цены. Если цены одинаковые - в порядке возрастания года выпуска \n" +
                "15. Список моделей автомобилей, зарегистрированных в программе. \n" +
                "16. Для каждой модели вывести список автомобилей. \n" +
                "17. Выход \n \n" +
                "Введите номер: " ;
    }
    final static String menu;

    final static String menuSortAndFilter;

    public static void run() {
        ListCar list = new ListCar();
        Scanner scanner = new Scanner(System.in);
        int menuNumber;
        scanner.useDelimiter("\\n");

        System.out.print(menu);
        menuNumber = scanner.hasNextInt() ? scanner.nextInt() : 0;
        while (menuNumber != 7) {
            switch (menuNumber) {
                case 1 -> addNewCar(list, scanner);
                case 2 -> removeCar(list, scanner);
                case 3 -> readFromFile(list, scanner);
                case 4 -> saveToFile(list, scanner);
                case 5 -> printNextMenu(list, scanner);
                case 6 -> printList(list);
            }
            System.out.print("Для вывода меню нажмите Enter...");
            scanner.next();
            System.out.print(menu);
            menuNumber = scanner.hasNextInt() ? scanner.nextInt() : 0;
        }
        scanner.close();
    }

    private static void printNextMenu(ListCar list, Scanner scanner) {
        int menuNumber;

        System.out.print(menuSortAndFilter);
        menuNumber = scanner.hasNextInt() ? scanner.nextInt() : 0;

        while (true) {
            if (menuNumber == 17) break;
            switch (menuNumber) {
                case 11 -> sort1(list, scanner);
                case 12 -> sort2(list, scanner);
                case 13 -> sort3(list, scanner);
                case 14 -> sort4(list);
                case 15 -> sort5(list);
                case 16 -> sort6(list);
            }
            System.out.print("Для вывода меню нажмите Enter...");
            scanner.next();
            System.out.print(menuSortAndFilter);
            menuNumber = scanner.hasNextInt() ? scanner.nextInt() : 0;
        }
    }

    private static void sort1(ListCar list, Scanner scanner) {
        System.out.print("Введите название модели авто: ");
        String model = scanner.next();
        list.sortCartoUpperYears(model,0);
    }

    private static void sort2(ListCar list, Scanner scanner) {
        int age = 0;
        String model="";

        System.out.print("Введите название модели авто:\t");
        model = scanner.next();

        System.out.print("Введите количество лет: ");
        if (scanner.hasNextInt()) {
            age = scanner.nextInt();
        }

        list.sortCartoUpperYears(model,age);
    }

    private static void sort3(ListCar list, Scanner scanner) {
        int year = 0;
        double price = 0;

        System.out.print("Введите год выпуска: ");
        if (scanner.hasNextInt()) {
            year = scanner.nextInt();
        }

        System.out.print("Введите цену: ");
        if (scanner.hasNextDouble()) {
            price = scanner.nextDouble();
        }

        list.filtrToPrice(year,price);
    }

    private static void sort4(ListCar list) {
        list.sortByPrice();
    }

    private static void sort5(ListCar list) {
        list.printListModels();
    }

    private static void sort6(ListCar list) {
        list.listCarsByModel();
    }

    private static void printList (ListCar list) {
        list.printAllCar();
    }

    private static void saveToFile(ListCar list, Scanner scanner) {
        System.out.print("Введите имя файла: ");
        String path = scanner.next();
        list.saveInfoToFile(path);
    }

    private static void readFromFile(ListCar list, Scanner scanner) {
        System.out.print("Введите имя файла: ");
        String path = scanner.next();
        list.readingFromFile(path);
    }

    private static void addNewCar(ListCar list, Scanner scanner) {
        String model = "MODEL";
        int year = 1990;
        double price = 1;
        String vinCode = "XXXXXXXXXX";

        System.out.print("Введите модель авто: ");
        model = scanner.next();

        System.out.print("Введите год выпуска авто: ");
        if (scanner.hasNextInt()) {
            year = scanner.nextInt();
        }

        System.out.print("Введите стоимость: ");
        if (scanner.hasNextDouble()) {
            price = scanner.nextDouble();
        }

        System.out.print("Введите VIN-код авто: ");
        vinCode = scanner.next();

        list.add(model,year,price,vinCode);
    }

    private static void removeCar(ListCar list, Scanner scanner) {
        int id = 0;
        System.out.print("Введите id авто, которого нужно удалить: ");
        if (scanner.hasNextInt()) {
            id = scanner.nextInt();
        }
        if (id > 0) {
            list.remove(id);
        }
    }
}

