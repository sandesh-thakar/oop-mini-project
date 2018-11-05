import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LoginUser {
    @SuppressWarnings("unchecked")
    
    boolean checkCredentials(String username, String password) {
        String line;
        
        try {
            BufferedReader bufferreader = new BufferedReader(new FileReader("users.json"));
            
            while((line=bufferreader.readLine())!=null) {
                
                int index=line.lastIndexOf(':');
                String usr = line.substring(index+2,line.length()-2);
                
                int index1=line.indexOf(':');
                int index2=line.indexOf(',');
                
                String psw = line.substring(index1+2,index2-1);
                
                if(username.equals(usr) && password.equals(psw))
                    return true;
            }
        } catch (FileNotFoundException exp) {
            exp.printStackTrace();
        } catch (IOException exp) {
            exp.printStackTrace();
        }
        
        
        return false;
    }
    
    LoginUser() {
        JFrame login = new JFrame("BakeMyTrip");
        
        JLabel title = new JLabel("Login");
        title.setBounds(200,50,100,50);
        title.setFont(new Font("Arial", Font.ITALIC, 20));
        title.setForeground(Color.RED);
        
        
        JTextField username = new JTextField("Username");
        username.setBounds(140,100,200,30);
        
        JPasswordField password = new JPasswordField("Password");
        password.setBounds(140,150,200,30);
        
        JLabel invalid = new JLabel("Invalid username and/or password");
        invalid.setBounds(140,180,200,10);
        invalid.setForeground(Color.RED);
        invalid.setVisible(false);
        
        JButton loginbutton = new JButton("Login");
        loginbutton.setBounds(140,225,200,40);
        
        loginbutton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1) {
                    if(checkCredentials(username.getText(),password.getText())) {
                        invalid.setVisible(false);
                    }
                    
                    else {
                        invalid.setVisible(true);
                    }
                }
            }
        });
        
        login.add(title);
        login.add(username);
        login.add(password);
        login.add(invalid);
        login.add(loginbutton);
        
        login.setSize(500,500);
        login.setLayout(null);
        login.setVisible(true);
    }
}