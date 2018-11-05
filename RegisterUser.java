import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RegisterUser {
    @SuppressWarnings("unchecked")
    
    RegisterUser()
    {
        
        
        JFrame register = new JFrame("BakeMyTrip");
        
        
        JLabel title = new JLabel("Sign Up");
        title.setBounds(200,50,100,50);
        title.setFont(new Font("Arial", Font.ITALIC, 20));
        title.setForeground(Color.RED);
        
        JTextField name = new JTextField("Name");
        name.setBounds(140,100,200,30);
        
        JTextField dob = new JTextField("Date of Birth DD/MM/YY");
        dob.setBounds(140,150,200,30);
        
        JTextField address = new JTextField("Address");
        address.setBounds(140,200,200,30);
        
        JTextField email = new JTextField("Email ID");
        email.setBounds(140,250,200,30);
        
        JTextField username = new JTextField("Choose username");
        username.setBounds(140,300,200,30);
        
        JPasswordField password = new JPasswordField("Choose password");
        password.setBounds(140,350,200,30);
        
        JButton finRegister = new JButton("Register");
        finRegister.setBounds(140,400,200,40);
        
        finRegister.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1) {
                    JSONObject userDetails = new JSONObject();
                    userDetails.put("username",username.getText());
                    userDetails.put("password",password.getText());
                    userDetails.put("name",name.getText());
                    userDetails.put("dob",dob.getText());
                    userDetails.put("address",address.getText());
                    userDetails.put("email",email.getText());
                    
                    
                    try(FileWriter file = new FileWriter("users.json",true)) {
                        file.write(userDetails.toJSONString());
                        file.write("\n");
                        file.flush();
                        
                        register.setVisible(false);
                        register.dispose();
                    } catch (IOException exp) {
                        exp.printStackTrace();
                    }
                    
                }
               
            }
        });
        
        
        
        
  
        register.add(title);
        register.add(name);
        register.add(dob);
        register.add(address);
        register.add(email);
        register.add(username);
        register.add(password);
        register.add(finRegister);
        
        
        register.setSize(500,500);
        register.setLayout(null);
        register.setVisible(true);
        
        
    }
}