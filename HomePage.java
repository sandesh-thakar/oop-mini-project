import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage  {
    public static void main(String args[])
    {
        JFrame f = new JFrame("BakeMyTrip");
        
        JLabel title = new JLabel("BakeMyTrip");
        title.setBounds(160,50,200,80);
        title.setFont(new Font("Courier New", Font.ITALIC, 30));
        title.setForeground(Color.BLUE);
        
        f.add(title);
        
        JButton login = new JButton("Login");
        JButton register = new JButton("Sign Up");
        
        login.setBounds(200,175,100,40);
        register.setBounds(200,225,100,40);
        
        login.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1) {
                    LoginUser login = new LoginUser();
                }
            }
        });
        
        register.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1) {
                    RegisterUser new_registration = new RegisterUser();
                }
               
            }
        });
        
        f.add(login);
        f.add(register);
        
        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);
        
        
    }
}
        