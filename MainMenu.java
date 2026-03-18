import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu(){

        setTitle("Car Rental System");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Color bg = new Color(30,30,30);
        Color accent = new Color(0,120,215);

        getContentPane().setBackground(bg);
        setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(45,45,45));
        panel.setLayout(new GridLayout(5,1,15,15));
        panel.setBorder(BorderFactory.createEmptyBorder(40,60,40,60));

        JLabel title = new JLabel("CAR RENTAL SYSTEM",SwingConstants.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,28));
        title.setForeground(Color.WHITE);

        JButton admin = new JButton("Admin Login");
        JButton user = new JButton("User Login");
        JButton register = new JButton("Register User");
        JButton exit = new JButton("Exit");

        styleButton(admin,accent);
        styleButton(user,accent);
        styleButton(register,accent);
        styleButton(exit,Color.RED);

        panel.add(title);
        panel.add(admin);
        panel.add(user);
        panel.add(register);
        panel.add(exit);

        add(panel);

        admin.addActionListener(e -> new AdminLogin());
        user.addActionListener(e -> new UserLogin());
        register.addActionListener(e -> new RegisterUser());
        exit.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void styleButton(JButton btn, Color color){

        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial",Font.BOLD,16));
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(200,40));

    }

    // MAIN METHOD (Program starts here)
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new MainMenu();
        });

    }

}