import javax.swing.*;
import java.awt.*;

public class NewBooking extends JFrame {

    public NewBooking(String carName, double price){

        setTitle("New Booking");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Color bg = new Color(30,30,30);
        Color accent = new Color(0,120,215);

        getContentPane().setBackground(bg);
        setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(45,45,45));
        panel.setLayout(new GridLayout(5,1,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(30,40,30,40));

        JLabel title = new JLabel("BOOK CAR: "+carName,SwingConstants.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,22));
        title.setForeground(Color.WHITE);

        JTextField name = new JTextField();
        JTextField days = new JTextField();

        JButton book = new JButton("Confirm Booking");

        styleButton(book,accent);

        panel.add(title);
        panel.add(name);
        panel.add(days);
        panel.add(book);

        add(panel);

        book.addActionListener(e -> {

            int d = Integer.parseInt(days.getText());

            double total = price * d;

            BookingDatabase.bookings.add(
                    new Booking(name.getText(),carName,d,total)
            );

            JOptionPane.showMessageDialog(this,"Booking Done\nTotal: "+total);

            dispose();

        });

        setVisible(true);
    }

    private void styleButton(JButton btn, Color color){

        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial",Font.BOLD,16));
        btn.setFocusPainted(false);

    }

}