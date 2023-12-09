import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Signup extends JFrame implements ActionListener {
    JButton signup;
    JButton back;
    JLabel sug;
    JLabel icon;
    JTextField userField;
    JTextField passField;
    JComboBox gender;

    JComboBox role;

    JComboBox year;
    JComboBox day;
    JComboBox month;
    JFrame sign;


    Signup() {
        sign = new JFrame();
        sign.setSize(420, 800);
        sign.setResizable(false);
        sign.setLayout(null);
        sign.setVisible(true);
        sign.getContentPane().setBackground(Color.black);
        sign.setTitle("Spotify(SignUp)");


        ImageIcon image = new ImageIcon("download (1).png");
        icon = new JLabel();
        icon.setIcon(image);
        icon.setBounds(100, 0, 300, 200);
        icon.setVisible(true);
        sign.add(icon);


        sug = new JLabel("SignUp");
        sug.setFont(new Font(" ", Font.BOLD, 30));
        sug.setForeground(Color.white);
        sug.setBounds(150, 140, 200, 50);
        sign.add(sug);


        JLabel user = new JLabel("Username:");
        user.setForeground(Color.white);
        userField = new JTextField();
        userField.setPreferredSize(new Dimension(50, 30));
        userField.setBounds(100, 240, 200, 30);
        user.setBounds(100, 190, 200, 50);
        sign.add(user);
        sign.add(userField);


        JLabel pass = new JLabel("Password:");
        pass.setForeground(Color.white);
        passField = new JTextField();
        passField.setPreferredSize(new Dimension(50, 30));
        passField.setBounds(100, 320, 200, 30);
        pass.setBounds(100, 270, 200, 50);
        sign.add(pass);
        sign.add(passField);

        JLabel gen = new JLabel("Gender:");
        String genderr[] = {"Men", "Women"};
        gender = new JComboBox(genderr);
        gen.setForeground(Color.white);
        gen.setBounds(100, 360, 200, 30);
        gender.setBounds(100, 400, 200, 50);
        sign.add(gen);
        sign.add(gender);

        JLabel roleee = new JLabel("Role:");
        String rolee[] = {"Listener", "Artist"};
        role = new JComboBox(rolee);
        roleee.setForeground(Color.white);
        roleee.setBounds(100, 455, 200, 30);
        role.setBounds(100, 490, 200, 50);
        sign.add(roleee);
        sign.add(role);

        JLabel birth = new JLabel("Date of birth:");
        birth.setForeground(Color.white);
        birth.setBounds(100, 545, 200, 30);
        sign.add(birth);

        String years[] = {"1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005"};
        year = new JComboBox(years);
        year.setBounds(100, 580, 60, 50);
        sign.add(year);

        String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        month = new JComboBox(months);
        month.setBounds(160, 580, 90, 50);
        sign.add(month);

        String days[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        day = new JComboBox(days);
        day.setBounds(250, 580, 50, 50);
        sign.add(day);

        signup = new JButton();
        signup.addActionListener(this);
        signup.setBounds(100, 650, 200, 50);
        signup.setText("SignUp");
        signup.setFocusable(false);
        signup.setBackground(Color.GREEN);
        signup.setFont(new Font(" ", Font.CENTER_BASELINE, 20));
        sign.add(signup);

        back = new JButton();
        back.addActionListener(this);
        back.setBounds(20, 20, 50, 50);
        ImageIcon backi = new ImageIcon("318504.png");
        back.setBackground(Color.black);
        back.setIcon(backi);
        back.setBorderPainted(false);
        back.setFocusable(false);
        sign.add(back);

        sign.setSize(425, 800);
    }

    // Check if the username already exists in the user database
    private boolean isUsernameExists(String username) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("user_database.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length > 0 && userData[0].equals(username)) {
                    reader.close();
                    return true; // Username already exists
                }
            }
            reader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return false; // Username is not found
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signup) {
            String username = userField.getText();


            // Check if the username already exists
            if (isUsernameExists(username)) {
                JOptionPane.showMessageDialog(this, "Username already exists. Please choose a different username.");
            } else {
                String password = passField.getText();
                String genderr = (String) gender.getSelectedItem();
                String rolee = (String) role.getSelectedItem();
                String birthDate = (String) year.getSelectedItem() + "/" + (String) month.getSelectedItem() + "/" + (String) day.getSelectedItem();
                String artistic = " ";

                if (rolee.equals("Artist")) {
                    createArtistFile(username);
                    createalbumFile(username);
                    createmusicalbumFile(username);
                }
                // Save the user information to a file
                try {
                    FileWriter writer = new FileWriter("user_database.txt", true);
                    writer.write(username + "," + password + "," + genderr + "," + rolee + "," + birthDate + "," + artistic + "\n");
                    writer.close();

                    JOptionPane.showMessageDialog(this, "Registration successful!" + "\n" + "Please Login.");
                    sign.dispose();
                    Loging loging = new Loging();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

        if (e.getSource() == back) {
            Menu menu = new Menu();
            sign.dispose();
        }
    }
    //Create the files that Artist need
    private void createArtistFile(String username) {
        try {
            FileWriter writer = new FileWriter(username + ".Artist.txt");
            writer.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
    private void createalbumFile(String username) {
        try {
            FileWriter writer = new FileWriter(username + ".Albums.txt");
            writer.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
    private void createmusicalbumFile(String username) {
        try {
            FileWriter writer = new FileWriter(username + "_Albums.txt");
            writer.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
