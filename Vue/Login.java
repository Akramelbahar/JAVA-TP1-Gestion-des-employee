package Vue;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private JPanel p1;
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton;
    public JPasswordField getPassword() {
        return password;
    }

    public void setPassword(JPasswordField password) {
        this.password = password;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public JTextField getUsername() {
        return username;
    }

    public void setUsername(JTextField username) {
        this.username = username;
    }



    public Login() {
        setTitle("Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(3, 1)); // Use GridLayout for better arrangement

        JPanel us = new JPanel(new FlowLayout());
        us.add(new JLabel("USERNAME:"));
        username = new JTextField(20); // Set a preferred width
        us.add(username);
        p1.add(us);

        JPanel pass = new JPanel(new FlowLayout());
        pass.add(new JLabel("PASSWORD:"));
        password = new JPasswordField(20); // Use JPasswordField
        pass.add(password);
        p1.add(pass);

        JPanel buttons = new JPanel(new FlowLayout());
        loginButton = new JButton("Login");

        buttons.add(loginButton);
        p1.add(buttons);

        add(p1);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login(); // Instantiate the Login class
    }
}
