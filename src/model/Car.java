package model;

public class Car {
    private String model;
    private String title;
    private String date_of_add;
    private int year;
    private int mileage;

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate_of_add() {
        return date_of_add;
    }
    public void setDate_of_add(String date_of_add) {
        this.date_of_add = date_of_add;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
