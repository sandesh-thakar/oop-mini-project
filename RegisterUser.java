import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RegisterUser {
    @SuppressWarnings("unchecked")
    
    
    
    boolean check_username(String username)
    {
        String line;
        
        try {
            BufferedReader bufferreader = new BufferedReader(new FileReader("users.json"));
            
            while((line=bufferreader.readLine())!=null) {
                
                int index=line.lastIndexOf(':');
               
                String un = line.substring(index+2,line.length()-2);
                
                if(un.equals(username))
                    return false;
                
            }
        } catch (FileNotFoundException exp) {
            exp.printStackTrace();
        } catch (IOException exp) {
            exp.printStackTrace();
        }
        return true;
    }
    
    
    
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
                    
                    if(check_username(username.getText()))
                    {
                    
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
                    
                    else
                        username.setText("Invalid username");
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