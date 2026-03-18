import javax.swing.*;
import java.awt.*;

public class UserLogin extends JFrame {

    JTextField userField;
    JPasswordField passField;

    public UserLogin(){

        setTitle("User Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Color bg = new Color(30,30,30);
        Color accent = new Color(0,120,215);

        getContentPane().setBackground(bg);
        setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(45,45,45));
        panel.setLayout(new GridLayout(4,2,15,15));
        panel.setBorder(BorderFactory.createEmptyBorder(40,50,40,50));

        JLabel title = new JLabel("USER LOGIN",SwingConstants.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,26));
        title.setForeground(Color.WHITE);

        JLabel userLabel = new JLabel("Username");
        userLabel.setForeground(Color.WHITE);

        JLabel passLabel = new JLabel("Password");
        passLabel.setForeground(Color.WHITE);

        userField = new JTextField();
        passField = new JPasswordField();

        JButton login = new JButton("Login");

        login.setBackground(accent);
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Arial",Font.BOLD,14));

        panel.add(title);
        panel.add(new JLabel(""));

        panel.add(userLabel);
        panel.add(userField);

        panel.add(passLabel);
        panel.add(passField);

        panel.add(new JLabel(""));
        panel.add(login);

        add(panel);

        login.addActionListener(e -> loginUser());

        passField.addActionListener(e -> loginUser());

        setVisible(true);
    }

    private void loginUser(){

        String username = userField.getText();
        String password = new String(passField.getPassword());

        if(UserDatabase.validateUser(username,password)){

            JOptionPane.showMessageDialog(this,"Login Successful");

            dispose();

            new UserDashboard(username);

        }
        else{

            JOptionPane.showMessageDialog(this,"Invalid Credentials");

        }

    }

}