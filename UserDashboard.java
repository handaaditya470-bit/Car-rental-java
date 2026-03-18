import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class UserDashboard extends JFrame {

    String username;

    HashMap<String,String> imageMap = new HashMap<>();

    public UserDashboard(String username){

        this.username = username;

        // IMAGE MAPPING
        // IMAGE MAPPING
imageMap.put("Maruti Swift","swift.jpg");
imageMap.put("Hyundai Creta","creta.jpg");
imageMap.put("Tata Nexon","nexon.jpg");
imageMap.put("Mahindra Thar","thar.jpg");
imageMap.put("Toyota Fortuner","fortuner.jpg");
imageMap.put("Honda City","city.jpg");
imageMap.put("Kia Seltos","seltos.jpg");
imageMap.put("Mahindra Scorpio","scorpio.jpg");
imageMap.put("Tata Punch","punch.jpeg");
imageMap.put("Maruti Baleno","baleno.jpg");

        setTitle("User Dashboard");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        Color bg = new Color(30,30,30);
        getContentPane().setBackground(bg);

        JLabel title = new JLabel("AVAILABLE CARS",SwingConstants.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,30));
        title.setForeground(Color.WHITE);
        title.setBorder(BorderFactory.createEmptyBorder(20,0,20,0));

        JPanel carPanel = new JPanel();
        carPanel.setBackground(bg);
        carPanel.setLayout(new GridLayout(0,3,25,25));
        carPanel.setBorder(BorderFactory.createEmptyBorder(30,40,30,40));

        for(Car c : CarDatabase.cars){

            JPanel card = createCarCard(c);
            carPanel.add(card);

        }

        JScrollPane scroll = new JScrollPane(carPanel);
        scroll.getViewport().setBackground(bg);
        scroll.setBorder(null);

        add(title,BorderLayout.NORTH);
        add(scroll,BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createCarCard(Car car){

        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());
        card.setBackground(new Color(45,45,45));
        card.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        String file = imageMap.get(car.name);

        if(file != null){

            ImageIcon icon = new ImageIcon("images/" + file);

            Image img = icon.getImage().getScaledInstance(220,140,Image.SCALE_SMOOTH);

            imageLabel.setIcon(new ImageIcon(img));

        }

        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info,BoxLayout.Y_AXIS));
        info.setBackground(new Color(45,45,45));

        JLabel name = new JLabel(car.name + " (" + car.year + ")");
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Arial",Font.BOLD,18));
        name.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel price = new JLabel("₹"+car.pricePerDay+" / day");
        price.setForeground(Color.LIGHT_GRAY);
        price.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel status = new JLabel(car.available ? "Available":"Booked");
        status.setForeground(car.available ? Color.GREEN : Color.RED);
        status.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton book = new JButton("Book Car");
        book.setBackground(new Color(0,120,215));
        book.setForeground(Color.WHITE);
        book.setFocusPainted(false);
        book.setAlignmentX(Component.CENTER_ALIGNMENT);

        if(!car.available){
            book.setEnabled(false);
        }

        book.addActionListener(e -> bookCar(car));

        info.add(Box.createVerticalStrut(10));
        info.add(name);
        info.add(Box.createVerticalStrut(5));
        info.add(price);
        info.add(Box.createVerticalStrut(5));
        info.add(status);
        info.add(Box.createVerticalStrut(10));
        info.add(book);
        info.add(Box.createVerticalStrut(10));

        card.add(imageLabel,BorderLayout.NORTH);
        card.add(info,BorderLayout.CENTER);

        return card;
    }

    private void bookCar(Car car){

        String daysStr = JOptionPane.showInputDialog("Enter number of days:");

        try{

            int days = Integer.parseInt(daysStr);

            double total = days * car.pricePerDay;

            Booking booking = new Booking(username,car.name,days,total);

            BookingDatabase.bookings.add(booking);

            car.available = false;

            JOptionPane.showMessageDialog(this,"Booking Confirmed\nTotal: ₹"+total);

            dispose();

            new UserDashboard(username);

        }
        catch(Exception e){

            JOptionPane.showMessageDialog(this,"Invalid input");

        }

    }

}