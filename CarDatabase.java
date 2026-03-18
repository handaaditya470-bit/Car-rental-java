import java.util.ArrayList;

public class CarDatabase {

    public static ArrayList<Car> cars = new ArrayList<>();

    static {

        cars.add(new Car(1,"Maruti Swift","2023",2500));
        cars.add(new Car(2,"Hyundai Creta","2024",4000));
        cars.add(new Car(3,"Tata Nexon","2023",3500));
        cars.add(new Car(4,"Mahindra Thar","2024",5000));
        cars.add(new Car(5,"Toyota Fortuner","2024",8000));
        cars.add(new Car(6,"Honda City","2023",4200));
        cars.add(new Car(7,"Kia Seltos","2024",4500));
        cars.add(new Car(8,"Mahindra Scorpio","2024",4800));
        cars.add(new Car(9,"Tata Punch","2023",2200));
        cars.add(new Car(10,"Maruti Baleno","2023",2600));

    }

}