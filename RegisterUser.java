import javax.swing.*;
import java.awt.*;

public class RegisterUser extends JFrame {

    JTextField username;
    JPasswordField password;

    public RegisterUser(){

        setTitle("Register User");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Color bg = new Color(30,30,30);
        Color panelBg = new Color(45,45,45);
        Color accent = new Color(0,120,215);

        getContentPane().setBackground(bg);
        setLayout(new GridBagLayout());

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400,300));
        panel.setBackground(panelBg);
        panel.setLayout(new GridLayout(4,1,15,15));
        panel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));

        JLabel title = new JLabel("REGISTER USER",SwingConstants.CENTER);
        title.setFont(new Font("Arial",Font.BOLD,24));
        title.setForeground(Color.WHITE);

        username = new JTextField();
        password = new JPasswordField();

        styleField(username);
        styleField(password);

        JButton registerBtn = new JButton("Register");
        styleButton(registerBtn,accent);

        panel.add(title);
        panel.add(username);
        panel.add(password);
        panel.add(registerBtn);

        add(panel);

        registerBtn.addActionListener(e -> register());

        username.addActionListener(e -> register());
        password.addActionListener(e -> register());

        setVisible(true);
    }

    private void register(){

        String user = username.getText();
        String pass = new String(password.getPassword());

        if(user.isEmpty() || pass.isEmpty()){

            JOptionPane.showMessageDialog(this,"Please enter username and password");
            return;

        }

        UserDatabase.addUser(new User(user,pass));

        JOptionPane.showMessageDialog(this,"User Registered Successfully");

        dispose();
    }

    private void styleField(JTextField field){

        field.setFont(new Font("Arial",Font.PLAIN,16));
        field.setPreferredSize(new Dimension(200,35));

    }

    private void styleButton(JButton btn, Color color){

        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial",Font.BOLD,16));
        btn.setFocusPainted(false);

    }

}