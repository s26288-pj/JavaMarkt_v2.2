package model;

public class DatabaseItem {
    private Car car;

    public DatabaseItem(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
    public void setCar(Car car) {
        this.car = car;
    }


    public int compareTo(Car c) {
        int compareTitle = getCar().getTitle().compareTo(c.getTitle());

        if(compareTitle == 0) {
            return getCar().getModel().compareTo(c.getModel());
        }
        else {
            return compareTitle;
        }
    }

}
