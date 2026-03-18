import java.io.*;
import java.util.ArrayList;

public class BookingDatabase {

    public static ArrayList<Booking> bookings = new ArrayList<>();
    private static final String FILE = "bookings.dat";

    static {
        loadBookings();
    }

    public static void addBooking(Booking b){

        bookings.add(b);
        saveBookings();

    }

    public static void saveBookings(){

        try{

            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(FILE));

            oos.writeObject(bookings);
            oos.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public static void loadBookings(){

        try{

            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(FILE));

            bookings = (ArrayList<Booking>) ois.readObject();
            ois.close();

        }catch(Exception e){

            bookings = new ArrayList<>();

        }

    }

}