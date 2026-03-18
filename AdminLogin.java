import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminLogin extends JFrame {

    JTextField usernameField;
    JPasswordField passwordField;

    public AdminLogin(){

        setTitle("Admin Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Color bg = new Color(30,30,30);
        Color accent = new Color(0,120,215);

        getContentPane().setBackground(bg);
        setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400,300));
        panel.setBackground(new Color(45,45,45));
        panel.setLayout(new GridLayout(5,1,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(30,40,30,40));

        JLabel title = new JLabel("ADMIN LOGIN",SwingConstants.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,24));
        title.setForeground(Color.WHITE);

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        styleField(usernameField);
        styleField(passwordField);

        JButton loginBtn = new JButton("Login");
        styleButton(loginBtn,accent);

        panel.add(title);
        panel.add(usernameField);
        panel.add(passwordField);
        panel.add(loginBtn);

        add(panel);

        loginBtn.addActionListener(e -> login());

        passwordField.addActionListener(e -> login());
        usernameField.addActionListener(e -> login());

        setVisible(true);
    }

    private void login(){

        String user = usernameField.getText();
        String pass = new String(passwordField.getPassword());

        if(user.equals("admin") && pass.equals("admin")){

            new AdminDashboard();
            dispose();

        }else{

            JOptionPane.showMessageDialog(this,"Invalid Login");

        }

    }

    private void styleField(JTextField field){

        field.setFont(new Font("Arial",Font.PLAIN,16));
        field.setPreferredSize(new Dimension(200,35));

    }

    private void styleButton(JButton btn, Color color){

        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial",Font.BOLD,16));

    }

}