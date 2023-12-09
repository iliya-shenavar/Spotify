import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPlayer extends JFrame {
    private JLabel songNameLabel;
    private JLabel artistNameLabel;
    private JLabel songImageLabel;
    private JProgressBar progressBar;
    private JButton playPauseButton;
    private JButton previousSongButton;
    private JButton nextSongButton;
    private JFrame player;

    JButton back;
    private Clip clip;
    private int currentSongIndex = 0; // Added to track the current song index
    private String[] songPaths = {
            "ENGAR.wav",
            "505.wav",
            "Saaghi.wav",
            "Apocalypse.wav",
            "Be Masti.wav",
            "Bordi Az Yadam.wav",
            "illegal.wav",
            "CONCRETE JUNGLE.wav",
            "Creep.wav",
            "Gharibeh.wav",
            "I Wanna Be Yours.wav",
            "Neyaz.wav",
            "Raaze Del.wav",
            "Red.wav",
            "bob divane.wav",
            "West-Coast.wav",
            "Sweater-Weather.wav",
            "Sometimes.wav",
            "Saghi.wav",
            "Anar Anar.wav"


    };
    private String[] songNames = {
            "ENGAR",
            "505",
            "Saaghi",
            "Apocalypse",
            "Be Masti",
            "Bordi Az Yadam",
            "illegal",
            "CONCRETE JUNGLE",
            "Creep",
            "Gharibeh",
            "I Wanna Be Yours",
            "Neyaz",
            "Raaze Del",
            "Red",
            "bob divane",
            "West Coast",
            "Sweater Weather",
            "Sometimes",
            "Saghi",
            "انار انار"

    };
    private String[] artistNames = {
            "Isam",
            "Arictic Monkeys",
            "The Don",
            "Cigarettes After Sex",
            "Sina Parsian",
            "Viguen",
            "Chvrsi",
            "Bad Omens",
            "Radiohead",
            "Shamaizadeh",
            "Arictic Monkeys",
            "Fereidoon Foroughi",
            "Hayede",
            "Santino Le Saint",
            "Spongebob",
            "Lana Del Rey",
            "The Neighbourhood",
            "Reamonn",
            "Hayede",
            "Adolf Hitler"

    };
    private String[] songImages = {
            "ENGAR.jpg",
            "505.jpg",
            "Saaghi.jpg",
            "Apocalypse.jpg",
            "Be Masti.jpg",
            "Bordi Az Yadam.jpg",
            "illegal.jpg",
            "CONCRETE JUNGLE.jpg",
            "Creep.jpg",
            "Gharibeh.jpg",
            "I Wanna Be Yours.jpg",
            "Neyaz.jpg",
            "Raaze Del.jpg",
            "Red.jpg",
            "bob divane.jpg",
            "West Coast.jpg",
            "Sweater Weather.jpg",
            "Sometimes.jpg",
            "Saghi.jpg",
            "Anar Anar.jpg"

    };

    public MusicPlayer() {


        songNameLabel = new JLabel();
        artistNameLabel = new JLabel();
        progressBar = new JProgressBar();
        progressBar.setBackground(Color.GRAY);
        progressBar.setForeground(Color.GREEN);
        progressBar.setBounds(55,380,300,20);
        progressBar.setMinimum(0);
        progressBar.setMaximum(100);
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font(" ",Font.TRUETYPE_FONT,0));
        progressBar.setBorderPainted(false);

        ImageIcon songImageIcon = new ImageIcon(songImages[currentSongIndex]); // Initialize with the first image
        artistNameLabel.setText(artistNames[currentSongIndex]); // Initialize with the first artist
        songNameLabel.setText(songNames[currentSongIndex]); // Initialize with the first name


        songImageLabel = new JLabel(songImageIcon);


        player = new JFrame();
        player.setSize(440, 600);
        player.setLayout(null);
        player.setResizable(false);
        player.setVisible(true);
        player.getContentPane().setBackground(Color.black);
        player.setTitle("Song Player");
        player.add(progressBar);

        player.add(songImageLabel);
        songImageLabel.setBounds(80,50,250,250);

        player.add(songNameLabel);
        songNameLabel.setBounds(165,290,200,60);
        songNameLabel.setForeground(Color.white);
        songNameLabel.setFont(new Font(" ",Font.BOLD,20));


        player.add(artistNameLabel);
        artistNameLabel.setBounds(160,315,200,60);
        artistNameLabel.setForeground(Color.lightGray);
        artistNameLabel.setFont(new Font(" ",Font.BOLD,14));


        back= new JButton();
        back.setBounds(5,5,50,50);
        ImageIcon backi = new ImageIcon("318504.png");
        back.setBackground(Color.black);
        back.setIcon(backi);
        back.setBorderPainted(false);
        back.setFocusable(false);
        player.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pauseSong();
                    if (Loging.rolee.equals("Listener")) {
                        Profile profile = new Profile(Loging.username, Loging.userGender, Loging.userDateOfBirth, Loging.selectedRole);
                    } else if (Loging.rolee.equals("Artist")) {
                        ProfileArt profileArt = new ProfileArt(Loging.username, Loging.userGender, Loging.userDateOfBirth, Loging.selectedRole,ProfileArt.artistic1);
                    }
                    player.dispose();
                }
        });


        ImageIcon previousSongButtonn = new ImageIcon("previous.jpg");
        previousSongButton = new JButton(previousSongButtonn);
        previousSongButton.setBounds(90,430,60,60);
        previousSongButton.setBorderPainted(false);
        previousSongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pauseSong();
                playPreviousSong();
            }
        });
        player.add(previousSongButton);

        ImageIcon playIcon = new ImageIcon("play.jpg");
        playPauseButton = new JButton(playIcon);
        playPauseButton.setBounds(170,430,60,60);
        playPauseButton.setBorderPainted(false);
        playPauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (clip != null && clip.isRunning()) {
                    pauseSong();
                } else {
                    playSong();
                }
            }
        });
        player.add(playPauseButton);

        ImageIcon nextSongButtonn = new ImageIcon("next.jpg");
        nextSongButton = new JButton(nextSongButtonn);
        nextSongButton.setBounds(250,430,60,60);
        nextSongButton.setBorderPainted(false);
        nextSongButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pauseSong();
                playNextSong();
            }
        });
        player.add(nextSongButton);

        setVisible(true);
        playSong();
    }

    private void playSong() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(songPaths[currentSongIndex]));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            updateProgressBar();
            ImageIcon playIcon = new ImageIcon("stop.jpg");
            updatePlayPauseButtonImage(playIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pauseSong() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            ImageIcon playIcon = new ImageIcon("play.jpg");
            updatePlayPauseButtonImage(playIcon);
        }
    }

    private void updatePlayPauseButtonImage(ImageIcon playIcon) {
        playPauseButton.setIcon(playIcon);
        playPauseButton.setBounds(170,430,60,60);
    }

    private void playNextSong() {

        currentSongIndex = (currentSongIndex + 1) % songPaths.length;
        updateSongInfo();
        playSong();
    }

    private void playPreviousSong() {

        currentSongIndex = (currentSongIndex - 1 + songPaths.length) % songPaths.length;
        updateSongInfo();
        playSong();
    }

    private void updateSongInfo() {
        songNameLabel.setText(songNames[currentSongIndex]);
        artistNameLabel.setText(artistNames[currentSongIndex]);
        ImageIcon songImageIcon = new ImageIcon(songImages[currentSongIndex]);
        songImageLabel.setIcon(songImageIcon);

    }

    private void updateProgressBar() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (clip != null && clip.isRunning()) {
                    int currentPosition = (int) clip.getMicrosecondPosition() / 1000000;
                    int total = (int) (clip.getMicrosecondLength() / 1000000);
                    progressBar.setValue((currentPosition * 100) / total);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
    }
}
