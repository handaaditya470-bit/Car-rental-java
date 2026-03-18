import java.io.*;
import java.util.ArrayList;

public class UserDatabase {

    static ArrayList<User> users = new ArrayList<>();
    static final String FILE = "users.dat";

    static{
        loadUsers();
    }

    public static void addUser(User u){

        users.add(u);
        saveUsers();

    }

    public static boolean validateUser(String username,String password){

        for(User u : users){

            if(u.username.equals(username) && u.password.equals(password)){
                return true;
            }

        }

        return false;
    }

    public static void saveUsers(){

        try{

            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(FILE));

            oos.writeObject(users);

            oos.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public static void loadUsers(){

        try{

            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(FILE));

            users = (ArrayList<User>) ois.readObject();

            ois.close();

        }
        catch(Exception e){

            users = new ArrayList<>();

        }

    }

}