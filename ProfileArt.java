import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ProfileArt extends JFrame implements ActionListener {
    public String username;
    public String gender;
    public String dateOfBirth;
    public JLabel genderr;
    public JLabel date;
    public static String role;
    private Random random;

    private int imagee;
    String genderp;
    public static String artistic1;
    private List<String> userMusic = new ArrayList<>();
    String artisticc;
    JFrame profile;
    JLabel name;
    JLabel rolee;
    JLabel icon;
    JLabel user;
    JButton logout;
    JButton playlist;
    JButton creat;
    JButton remove;
    JButton addalbum;
    JButton removealbum;
    JButton showalbum;
    JButton musictoalbum;
    private List<String> userAlbums = new ArrayList<>();
    private Map<String, List<String>> albumsToMusic = new HashMap<>();
    JButton play;


    JLabel artisticshow;
    JButton artisticset;
    JButton artisticchange;
    ImageIcon imageee;

    JButton addMusicButton;
    JButton showMusicButton;
    JButton removeMusicButton;
    private String[] profMImages = {
            "artistm1.png",
            "artistm2.png",
            "artistm3.png"
    };
    private String[] profWImages = {
            "artistw1.png",
            "artistw2.png",
            "artistw3.png"
    };
    ProfileArt(String username, String gender, String dateOfBirth, String role,String artistic) {
        this.username = username;
        this.artistic1 = artistic;
        this.gender = gender;
        genderp = gender;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
        profile = new JFrame();
        profile.setSize(420, 820);
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

        //Choose random image and show it in profile
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
        logout.setBounds(135, 740, 120, 35);
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
        playlist.setForeground(Color.BLACK);
        playlist.setBackground(Color.RED);
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

        artisticset = new JButton();
        artisticset.addActionListener(this);
        artisticset.setBounds(70, 450, 125, 40);
        artisticset.setText("Set artistic");
        artisticset.setFocusable(false);
        artisticset.setForeground(Color.BLACK);
        artisticset.setBackground(Color.YELLOW);
        artisticset.setFont(new Font(" ", Font.CENTER_BASELINE, 12));
        profile.add(artisticset);

        artisticchange = new JButton();
        artisticchange.addActionListener(this);
        artisticchange.setBounds(200, 450, 125, 40);
        artisticchange.setText("Change artistic");
        artisticchange.setFocusable(false);
        artisticchange.setForeground(Color.BLACK);
        artisticchange.setBackground(Color.yellow);
        artisticchange.setFont(new Font(" ", Font.CENTER_BASELINE, 12));
        profile.add(artisticchange);

        addalbum = new JButton();
        addalbum.addActionListener(this);
        addalbum.setBounds(70, 500, 125, 40);
        addalbum.setText("Add album");
        addalbum.setFocusable(false);
        addalbum.setForeground(Color.BLACK);
        addalbum.setBackground(Color.YELLOW);
        addalbum.setFont(new Font(" ", Font.CENTER_BASELINE, 12));
        profile.add(addalbum);

        musictoalbum = new JButton();
        musictoalbum.addActionListener(this);
        musictoalbum.setBounds(70, 550, 125, 40);
        musictoalbum.setText("Add music to album");
        musictoalbum.setFocusable(false);
        musictoalbum.setForeground(Color.BLACK);
        musictoalbum.setBackground(Color.YELLOW);
        musictoalbum.setFont(new Font(" ", Font.CENTER_BASELINE, 9));
        profile.add(musictoalbum);

        showalbum = new JButton();
        showalbum.addActionListener(this);
        showalbum.setBounds(200, 500, 125, 40);
        showalbum.setText("Show album");
        showalbum.setFocusable(false);
        showalbum.setForeground(Color.BLACK);
        showalbum.setBackground(Color.YELLOW);
        showalbum.setFont(new Font(" ", Font.CENTER_BASELINE, 12));
        profile.add(showalbum);

        removealbum = new JButton();
        removealbum.addActionListener(this);
        removealbum.setBounds(200, 550, 125, 40);
        removealbum.setText("Remove album");
        removealbum.setFocusable(false);
        removealbum.setForeground(Color.BLACK);
        removealbum.setBackground(Color.yellow);
        removealbum.setFont(new Font(" ", Font.CENTER_BASELINE, 12));
        profile.add(removealbum);

        addMusicButton = new JButton("Add Music");
        addMusicButton.addActionListener(this);
        addMusicButton.setBounds(70, 600, 125, 40);
        addMusicButton.setFocusable(false);
        addMusicButton.setForeground(Color.BLACK);
        addMusicButton.setBackground(Color.YELLOW);
        addMusicButton.setFont(new Font(" ", Font.CENTER_BASELINE, 12));
        profile.add(addMusicButton);

        showMusicButton = new JButton("Show Music");
        showMusicButton.addActionListener(this);
        showMusicButton.setBounds(200, 600, 125, 40);
        showMusicButton.setFocusable(false);
        showMusicButton.setForeground(Color.BLACK);
        showMusicButton.setBackground(Color.YELLOW);
        showMusicButton.setFont(new Font(" ", Font.CENTER_BASELINE, 12));
        profile.add(showMusicButton);

        removeMusicButton = new JButton("Remove Music");
        removeMusicButton.addActionListener(this);
        removeMusicButton.setBounds(135, 650, 125, 40);
        removeMusicButton.setFocusable(false);
        removeMusicButton.setForeground(Color.BLACK);
        removeMusicButton.setBackground(Color.YELLOW);
        removeMusicButton.setFont(new Font(" ", Font.CENTER_BASELINE, 12));
        profile.add(removeMusicButton);

        play = new JButton();
        play.addActionListener(this);
        play.setBounds(115, 695, 160, 40);
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

        artisticshow = new JLabel();
        artisticshow.setFont(new Font(" ", Font.BOLD, 13));
        artisticshow.setForeground(Color.white);
        artisticshow.setBounds(165, 275, 200, 50);
        profile.add(artisticshow);

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




        profile.setSize(425, 820);

        //Read information from file and show them  in profile
        try {
            BufferedReader reader = new BufferedReader(new FileReader("user_database.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length >= 6) {
                    username = userData[0];
                    role = userData[3];
                    gender = userData[2];
                    dateOfBirth = userData[4];
                    artistic = userData[5];
                    artistic1 = userData[5];

                    displayUserDetails(); // Display details for each user
                }
            }
            reader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        loadUserMusic();
        loadUserAlbums();
        loadAlbumsToMusic();
    }
    JFrame art;
    JTextField namee;
    JButton set;

    //Set artistic name
    public void Artisticset(){
        art = new JFrame();
        art.setSize(250, 200);
        art.setLayout(null);
        art.setResizable(false);
        art.setVisible(true);
        art.getContentPane().setBackground(Color.black);
        art.setTitle("Set artistic name");

        namee = new JTextField();
        namee.setPreferredSize(new Dimension(50, 30));
        namee.setBounds(60,40, 120, 30);
        art.add(namee);

        set = new JButton();
        set.addActionListener(this);
        set.setBounds(75,90, 90, 25);
        set.setText("Set");
        set.setFocusable(false);
        set.setBackground(Color.GREEN);
        set.setFont(new Font(" ", Font.CENTER_BASELINE, 15));
        art.add(set);
        set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                artisticc = namee.getText();
                String filePath = "user_database.txt"; // Replace with the path to file
                String searchString = artistic1;
                String replacementString = artisticc;

                try {
                    BufferedReader reader = new BufferedReader(new FileReader(filePath));
                    StringBuilder content = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        line = line.replaceAll(searchString, replacementString);
                        content.append(line).append(System.lineSeparator());
                    }

                    reader.close();

                    BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                    writer.write(content.toString());
                    writer.close();

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                art.dispose();
            }
        });

    }
    //Change artistic name
    public void Artisticchange(){
        art = new JFrame();
        art.setSize(250, 200);
        art.setLayout(null);
        art.setResizable(false);
        art.setVisible(true);
        art.getContentPane().setBackground(Color.black);
        art.setTitle("Change artistic name");

        namee = new JTextField();
        namee.setPreferredSize(new Dimension(50, 30));
        namee.setBounds(60,40, 120, 30);
        art.add(namee);

        set = new JButton();
        set.addActionListener(this);
        set.setBounds(75,90, 100, 30);
        set.setText("Change");
        set.setFocusable(false);
        set.setBackground(Color.GREEN);
        set.setFont(new Font(" ", Font.CENTER_BASELINE, 13));
        art.add(set);
        set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                artisticc = namee.getText();
                String filePath = "user_database.txt";
                String searchString = artistic1;
                String replacementString = artisticc;

                try {
                    BufferedReader reader = new BufferedReader(new FileReader(filePath));
                    StringBuilder content = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        line = line.replaceAll(searchString, replacementString);
                        content.append(line).append(System.lineSeparator());
                    }

                    reader.close();

                    BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
                    writer.write(content.toString());
                    writer.close();

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                art.dispose();
            }

        });
    }
    private void displayUserDetails() {
        name.setText(username);
        genderr.setText(gender);
        date.setText(dateOfBirth);
        artisticshow.setText(artistic1);
        rolee.setText(role + ",");
    }
    // Load Artist music from the Artist.txt file
    private void loadUserMusic() {
        try {

            BufferedReader reader = new BufferedReader(new FileReader(username + ".Artist.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                userMusic.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Save Artist music to the Artist.txt file
    private void saveUserMusic() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(username + ".Artist.txt"));
            for (String music : userMusic) {
                writer.write(music);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        if(e.getSource()==artisticset){
            Artisticset();
        }
        if(e.getSource()==artisticchange){
            Artisticchange();
        }
        if (e.getSource() == addMusicButton) {
            addMusic();
        }
        if (e.getSource() == showMusicButton) {
            showMusic();
        }
        if (e.getSource() == removeMusicButton) {
            removeMusic();
        }
        if (e.getSource() == addalbum) {
            addAlbum();
        }
        if (e.getSource() == showalbum) {
            showAlbums();
        }
        if (e.getSource() == removealbum) {
            removeAlbum();
        }
        if (e.getSource() == musictoalbum) {
            addMusicToAlbum();
        }
    }
    // Allow the Artist to select and add music from the predefined list
    private void addMusic() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = fileChooser.getSelectedFiles();
            for (File file : selectedFiles) {
                String musicName = file.getName();
                if (isValidMusic(musicName)) {
                    userMusic.add(musicName);
                }
            }
        }
       saveUserMusic(); // Save the updated Artist music list
    }

    // Show the Artist music in a dialog
    private void showMusic() {
        StringBuilder musicList = new StringBuilder("Your Music:\n");
        for (String music : userMusic) {
            musicList.append(music).append("\n");
        }
        JOptionPane.showMessageDialog(this, musicList.toString(), "Your Music", JOptionPane.INFORMATION_MESSAGE);
    }

    //Introduce valid files
    private boolean isValidMusic(String musicName) {
        String[] validMusicFiles = {
                "ENGAR.wav", "505.wav", "Saaghi.wav", "Apocalypse.wav", "Be Masti.wav",
                "Bordi Az Yadam.wav", "illegal.wav", "CONCRETE JUNGLE.wav", "Creep.wav",
                "Gharibeh.wav", "I Wanna Be Yours.wav", "Neyaz.wav", "Raaze Del.wav",
                "Red.wav", "bob divane.wav", "West-Coast.wav", "Sweater-Weather.wav",
                "Sometimes.wav", "Saghi.wav", "Anar Anar.wav"
        };
        for (String validMusic : validMusicFiles) {
            if (validMusic.equalsIgnoreCase(musicName)) {
                return true;
            }
        }
        return false;
    }
    // Show the Artist music in a dialog
    private void removeMusic() {
        String[] musicArray = userMusic.toArray(new String[0]);
        String selectedMusic = (String) JOptionPane.showInputDialog(
                this,
                "Select music to remove:",
                "Remove Music",
                JOptionPane.PLAIN_MESSAGE,
                null,
                musicArray,
                musicArray[0]
        );

        if (selectedMusic != null) {
            // Remove the selected music from the list
            userMusic.remove(selectedMusic);

            // Save the updated user's music list
            saveUserMusic();
        }
    }

    // Allow the user to input the album name to add
    private void addAlbum() {
        String albumName = JOptionPane.showInputDialog(this, "Enter the album name:", "Add Album", JOptionPane.PLAIN_MESSAGE);
        if (albumName != null && !albumName.isEmpty()) {
            userAlbums.add(albumName);
            saveUserAlbums(); // Save the updated user's albums list
        }
    }
    // Allow the user to remove an album
    private void removeAlbum() {
        if (userAlbums.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No albums to remove.", "Remove Album", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String[] albumArray = userAlbums.toArray(new String[0]);
        String selectedAlbum = (String) JOptionPane.showInputDialog(
                this,
                "Select an album to remove:",
                "Remove Album",
                JOptionPane.PLAIN_MESSAGE,
                null,
                albumArray,
                albumArray[0]
        );

        if (selectedAlbum != null) {
            userAlbums.remove(selectedAlbum);
            albumsToMusic.remove(selectedAlbum);
            saveUserAlbums(); // Save the updated user's albums list
            saveAlbumsToMusic(); // Save the updated music for albums
        }
    }

    // Load user's albums from a file
    private void loadUserAlbums() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(username + ".Albums.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                userAlbums.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save user's albums to a file
    private void saveUserAlbums() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(username + ".Albums.txt"));
            for (String album : userAlbums) {
                writer.write(album);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Show album in a dialog
    private void showAlbums() {
        StringBuilder albumList = new StringBuilder("Your Albums and Music:\n");
        for (Map.Entry<String, List<String>> entry : albumsToMusic.entrySet()) {
            String albumName = entry.getKey();
            List<String> musicList = entry.getValue();
            albumList.append(albumName).append(":\n");
            for (String music : musicList) {
                albumList.append("- ").append(music).append("\n");
            }
        }
        JOptionPane.showMessageDialog(this, albumList.toString(), "Your Albums and Music", JOptionPane.INFORMATION_MESSAGE);
    }

    // Allow the user to select an album and add music to it
    private void addMusicToAlbum() {
        String[] albumArray = userAlbums.toArray(new String[0]);
        String selectedAlbum = (String) JOptionPane.showInputDialog(
                this,
                "Select an album to add music to:",
                "Add Music to Album",
                JOptionPane.PLAIN_MESSAGE,
                null,
                albumArray,
                albumArray[0]
        );

        if (selectedAlbum != null) {
            // Allow the user to select and add music to the selected album
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setMultiSelectionEnabled(true);

            int result = fileChooser.showOpenDialog(this);

            if (result == JFileChooser.APPROVE_OPTION) {
                File[] selectedFiles = fileChooser.getSelectedFiles();
                for (File file : selectedFiles) {
                    String musicName = file.getName();
                    if (isValidMusic(musicName)) {
                        List<String> musicList = albumsToMusic.computeIfAbsent(selectedAlbum, k -> new ArrayList<>());
                        musicList.add(musicName);
                    }
                }
                saveAlbumsToMusic(); // Save the updated music for albums
            }
        }
    }

    private void saveAlbumsToMusic() {
        try (PrintWriter writer = new PrintWriter(username + "_Albums.txt")) {
            for (Map.Entry<String, List<String>> entry : albumsToMusic.entrySet()) {
                String albumName = entry.getKey();
                List<String> musicList = entry.getValue();
                writer.println(albumName);
                for (String music : musicList) {
                    writer.println("- " + music);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadAlbumsToMusic() {
        try (BufferedReader reader = new BufferedReader(new FileReader(username + "_Albums.txt"))) {
            String line;
            String currentAlbum = null;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("- ") && currentAlbum != null) {
                    albumsToMusic.computeIfAbsent(currentAlbum, k -> new ArrayList<>()).add(line.substring(2));
                } else {
                    currentAlbum = line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
