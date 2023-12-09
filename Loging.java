import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Loging extends JFrame implements ActionListener {
    JButton loginb;

    JButton back;
    JLabel logi;
    JLabel icon;
    public static String username;
    public static String userGender;
    public static String userDateOfBirth;
    public static String selectedRole;
    public static String rolee;
    JTextField userField;
    JTextField passField;
    JComboBox role;
    JFrame login;

    Loging() {
        login = new JFrame();
        login.setSize(420, 600);
        login.setLayout(null);
        login.setResizable(false);
        login.setVisible(true);
        login.getContentPane().setBackground(Color.black);
        login.setTitle("Spotify(Login)");


        ImageIcon image = new ImageIcon("download (1).png");
        icon = new JLabel();
        icon.setIcon(image);
        icon.setBounds(100,0,300,200);
        icon.setVisible(true);
        login.add(icon);


        logi = new JLabel("Login");
        logi.setFont(new Font(" ",Font.BOLD,30));
        logi.setForeground(Color.white);
        logi.setBounds(160,140,200,50);
        login.add(logi);

        JLabel user = new JLabel("Username:");
        user.setForeground(Color.white);
        userField = new JTextField();
        userField.setBounds(100,230,200,30);
        user.setBounds(100,180,200,50);
        login.add(user);
        login.add(userField);




        JLabel pass = new JLabel("Password:");
        pass.setForeground(Color.white);
        passField = new JTextField();
        passField.setPreferredSize(new Dimension(50 ,30));
        passField.setBounds(100,300,200,30);
        pass.setBounds(100,255,200,50);
        login.add(pass);
        login.add(passField);


        JLabel roleee = new JLabel("Role:");
        String rolee[]={"Listener","Artist"};
        role = new JComboBox(rolee);
        roleee.setForeground(Color.white);
        roleee.setBounds(100,325,200,50);
        role.setBounds(100,370,200,50);
        login.add(roleee);
        login.add(role);







        loginb= new JButton();
        loginb.addActionListener(this);
        loginb.setBounds(100,450,200,50);
        loginb.setText("Login");
        loginb.setFocusable(false);
        loginb.setBackground(Color.GREEN);
        loginb.setFont(new Font(" ",Font.CENTER_BASELINE,20));
        login.add(loginb);

        login.setSize(425 , 600);



        back= new JButton();
        back.addActionListener(this);
        back.setBounds(20,20,50,50);
        ImageIcon backi = new ImageIcon("318504.png");
        back.setBackground(Color.black);
        back.setIcon(backi);
        back.setBorderPainted(false);
        back.setFocusable(false);
        login.add(back);

        login.setSize(425 , 600);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginb) {
            //Get inputs and use them
            username = userField.getText();
            String password = passField.getText();
            selectedRole = (String) role.getSelectedItem();

            // Check username and pass and role
            boolean userFound = false;
            userGender = null;
            userDateOfBirth = null;
            String role = null;
            try {
                BufferedReader reader = new BufferedReader(new FileReader("user_database.txt"));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] userData = line.split(",");
                    if (userData[0].equals(username) && userData[1].equals(password) && userData[3].equals(selectedRole)) {
                        userFound = true;
                        userGender = userData[2];
                        role = userData[3];
                        rolee = role;
                        userDateOfBirth = userData[4];
                        break;
                    }
                }
                reader.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


            if (userFound) {
                if (role.equals("Listener")) {
                    Profile profile = new Profile(username, userGender, userDateOfBirth, selectedRole);
                    login.dispose();
                } else if (role.equals("Artist")) {
                    ProfileArt profileArt = new ProfileArt(username, userGender, userDateOfBirth, selectedRole,ProfileArt.artistic1);
                    login.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(this, "User not found or wrong username or password!" + "\n" + "             Please SignUp or try again.");
            }
        }
        if(e.getSource()==back){
            Menu menu = new Menu();
            login.dispose();
        }
    }
}
