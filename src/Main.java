import model.Car;
import model.Database;
import model.DatabaseItem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Car> getSampleCars() {
        ArrayList<Car> sample = new ArrayList<Car>();
        for (int i = 1; i <= 5; i++) {
            Car c = new Car();
            c.setModel("Auto " + i);
            c.setTitle("Model " + i);
            c.setDate_of_add("27-05-2022");
            c.setYear(1999);
            c.setMileage(100000);
            sample.add(c);
        }
        return sample;
    }
    public static Database getSampleDatabase() {
        Database database = new Database();
        for(Car c: getSampleCars()) {
            database.getItems().add(new DatabaseItem(c));
        }
        return database;
    }

    public static void printData(Database database) {
        boolean apply_filter = true;
        String filter = "";         //<
        int year = 0;               //<
        int mileage = 0;            //<

        System.out.println("Jaki filtr chcesz wykorzystac?");
        System.out.println("1. Model lub tytul ogloszenia");
        System.out.println("2. Rocznik auta");
        System.out.println("3. Przebieg");
        System.out.println("4. Brak filtra (wyswietl wszystkie ogloszenia)");
        System.out.print("Wpisz swoj wybor: ");
        Scanner sc = new Scanner(System.in);

        switch(sc.nextInt()) {
        case 1:
            System.out.print("Wpisz tytul ogloszenia lub model: ");
            sc = new Scanner(System.in);
            filter = sc.nextLine();
            break;
        case 2:
            System.out.print("Wpisz rocznik samochodu: ");
            sc = new Scanner(System.in);
            year = sc.nextInt();
            break;
        case 3:
            System.out.print("Wpisz przebieg (w km): ");
            sc = new Scanner(System.in);
            mileage = sc.nextInt();
            break;
        case 4:
            break;
        }

        if(year == 0 && mileage == 0 && filter.equals(""))
            apply_filter = false;

        System.out.println("================================================");
        System.out.println("|Title\t|Model\t|Posted date\t|Year\t|Mileage\t|");
        System.out.println("------------------------------------------------");
        for (DatabaseItem item : database.getItems()) {
            if(apply_filter) {
                if (item.getCar().getTitle().equals(filter) || item.getCar().getModel().equals(filter) ||
                        item.getCar().getDate_of_add().equals(filter) || item.getCar().getYear() == year ||
                        item.getCar().getMileage() == mileage) {
                    System.out.println("|"
                            + item.getCar().getTitle() + "\t|"
                            + item.getCar().getModel() + "\t|"
                            + item.getCar().getDate_of_add() + "\t|"
                            + item.getCar().getYear() + "\t|"
                            + item.getCar().getMileage() + "\t|");
                    System.out.println("------------------------------------------------");
                } else continue;
            }
            else {
                System.out.println("|"
                        + item.getCar().getTitle() + "\t|"
                        + item.getCar().getModel() + "\t|"
                        + item.getCar().getDate_of_add() + "\t|"
                        + item.getCar().getYear() + "\t|"
                        + item.getCar().getMileage() + "\t|");
                System.out.println("------------------------------------------------");
            }
        }
    }

    public static void main(String[] args) {
        Database database = getSampleDatabase();
        printData(database);
    }
}
