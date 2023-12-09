import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    JButton login;
    JButton signup;
    JButton Exit;
    JLabel sign;
    JLabel icon;
    Menu() {
        this.setSize(420, 600);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.black);
        this.setTitle("Spotify");


        ImageIcon image = new ImageIcon("download (1).png");
        icon = new JLabel();
        icon.setIcon(image);
        icon.setBounds(100,0,300,200);
        icon.setVisible(true);
        this.add(icon);


        sign = new JLabel("Login/Sign up");
        sign.setFont(new Font(" ",Font.BOLD,25));
        sign.setForeground(Color.white);
        sign.setBounds(115,140,200,50);
        this.add(sign);




        login = new JButton();
        login.addActionListener(this);
        login.setBounds(100,200,200,50);
        login.setText("Login");
        login.setFocusable(false);
        login.setBackground(Color.GREEN);
        login.setFont(new Font(" ",Font.CENTER_BASELINE,15));
        this.add(login);

        signup = new JButton();
        signup.addActionListener(this);
        signup.setBounds(100,260,200,50);
        signup.setText("Sign up");
        signup.setFocusable(false);
        signup.setBackground(Color.white);
        signup.setFont(new Font(" ",Font.CENTER_BASELINE,15));
        this.add(signup);

        Exit = new JButton();
        Exit.addActionListener(this);
        Exit.setBounds(100,320,200,50);
        Exit.setText("Exit");
        Exit.setFocusable(false);
        Exit.setBackground(Color.GRAY);
        Exit.setForeground(Color.white);
        Exit.setFont(new Font(" ",Font.CENTER_BASELINE,15));
        this.add(Exit);




        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(425 , 600);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){
            Loging jPanel = new Loging();
            this.dispose();

        }
        if(e.getSource()==signup){
            Signup jPanel = new Signup();
            this.dispose();
        }
        if(e.getSource()==Exit){
            System.exit(0);
        }
    }
}