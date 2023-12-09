import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Profile extends JFrame implements ActionListener {
    public String username;
    public String gender;
    public String dateOfBirth;
    public JLabel genderr;
    public JLabel date;
    public static String role;
    private Random random;

    private int imagee;
    String genderp;

    JFrame profile;
    JLabel profilee;
    JLabel name;

    JLabel rolee;
    JLabel icon;
    JLabel user;
    JButton logout;
    JButton playlist;
    JButton creat;
    JButton remove;
    JButton play;
    ImageIcon imageee;

    private String[] profMImages = {
            "listenerm1.png",
            "listenerm2.png",
            "listenerm3.png"
    };
    private String[] profWImages = {
            "listenerw1.png",
            "listenerw2.png",
            "listenerw3.png"
    };
    Profile(String username, String gender, String dateOfBirth, String role) {
        this.username = username;
        this.gender = gender;
        genderp = gender;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
        profile = new JFrame();
        profile.setSize(420, 600);
        profile.setLayout(null);
        profile.setResizable(false);
        profile.setVisible(true);
        profile.getContentPane().setBackground(Color.black);
        profile.setTitle("Profile");

        ImageIcon image = new ImageIcon("download (1).png");
        icon = new JLabel();
        icon.setIcon(image);
        icon.setBounds(100, -50, 300, 200);
        icon.setVisible(true);
        profile.add(icon);

        random = new Random();
        imagee = random.nextInt(3);

        if (genderp.equals("Men")){
            imageee = new ImageIcon(profMImages[imagee]);
        } else if (genderp.equals("Women")) {
            imageee = new ImageIcon(profWImages[imagee]);
        }

        user = new JLabel();
        user.setIcon(imageee);
        user.setBounds(120, 100, 150, 150);
        user.setVisible(true);
        profile.add(user);


        logout = new JButton();
        logout.addActionListener(this);
        logout.setBounds(135, 500, 120, 35);
        logout.setText("logout");
        logout.setFocusable(false);
        logout.setForeground(Color.white);
        logout.setBackground(Color.GRAY);
        logout.setFont(new Font(" ", Font.CENTER_BASELINE, 15));
        profile.add(logout);

        playlist = new JButton();
        playlist.addActionListener(this);
        playlist.setBounds(115, 355, 160, 40);
        playlist.setText("Playlist");
        playlist.setFocusable(false);
        playlist.setForeground(Color.black);
        playlist.setBackground(Color.red);
        playlist.setFont(new Font(" ", Font.CENTER_BASELINE, 20));
        profile.add(playlist);

        creat = new JButton();
        creat.addActionListener(this);
        creat.setBounds(70, 400, 125, 40);
        creat.setText("Create Playlist");
        creat.setFocusable(false);
        creat.setForeground(Color.BLACK);
        creat.setBackground(Color.red);
        creat.setFont(new Font(" ", Font.CENTER_BASELINE, 12));
        profile.add(creat);

        remove = new JButton();
        remove.addActionListener(this);
        remove.setBounds(200, 400, 125, 40);
        remove.setText("Remove Playlist");
        remove.setFocusable(false);
        remove.setForeground(Color.BLACK);
        remove.setBackground(Color.red);
        remove.setFont(new Font(" ", Font.CENTER_BASELINE, 12));
        profile.add(remove);

        play = new JButton();
        play.addActionListener(this);
        play.setBounds(115, 445, 160, 40);
        play.setText("Play");
        play.setFocusable(false);
        play.setBackground(Color.green);
        play.setFont(new Font(" ", Font.CENTER_BASELINE, 20));
        profile.add(play);

        name = new JLabel();
        name.setFont(new Font(" ", Font.BOLD, 30));
        name.setForeground(Color.white);
        name.setBounds(165, 250, 200, 50);
        profile.add(name);

        rolee = new JLabel();
        rolee.setFont(new Font(" ", Font.BOLD, 13));
        rolee.setForeground(Color.white);
        rolee.setBounds(150, 295, 200, 50);
        profile.add(rolee);

        genderr = new JLabel();
        genderr.setFont(new Font(" ", Font.BOLD, 13));
        genderr.setForeground(Color.white);
        genderr.setBounds(205, 295, 200, 50);
        profile.add(genderr);

        date = new JLabel();
        date.setFont(new Font(" ", Font.BOLD, 10));
        date.setForeground(Color.white);
        date.setBounds(160, 312, 200, 50);
        profile.add(date);

        profile.setSize(425, 600);
        // read information from file and show them in profile
        try {
            BufferedReader reader = new BufferedReader(new FileReader("user_database.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length >= 5) {
                    username = userData[0];
                    role = userData[3];
                    gender = userData[2];
                    dateOfBirth = userData[4];
                    displayUserDetails();
                }
            }
            reader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }

    private void displayUserDetails() {
        name.setText(username);
        genderr.setText(gender);
        date.setText(dateOfBirth);
        rolee.setText(role + ",");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==logout){
            Loging jPanel = new Loging();
            profile.dispose();

        }
        if(e.getSource()==play){
            MusicPlayer musicPlayer = new MusicPlayer();
            profile.dispose();

        }
    }
}