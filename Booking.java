import java.io.Serializable;

public class Booking implements Serializable {

    String username;
    String carName;
    int days;
    double total;

    public Booking(String username,String carName,int days,double total){

        this.username = username;
        this.carName = carName;
        this.days = days;
        this.total = total;

    }

}