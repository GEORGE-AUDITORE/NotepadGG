package notepadgg;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Help extends JFrame implements ActionListener{
    
    Help() {
        setBounds(400, 100, 600, 500);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("notepadgg/icons/win11.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 60, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel headerIcon = new JLabel(i3);
        headerIcon.setBounds(70, 40, 400, 80);
        add(headerIcon);
        
        ImageIcon i4 = new ImageIcon (ClassLoader.getSystemResource("notepadgg/icons/Notepad-icon.png"));
        Image i5 = i4.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        
        JLabel icon = new JLabel(i6);
        icon.setBounds(50, 180, 70, 70);
        add(icon);
        
        JLabel text = new JLabel("<html>Code for Personal Use<br>Test Version 2024<br>2024 Personal Project.<br>All rights reserved<br><br>NotepadGG is a simple text editor for basic text-editing, <br> which enables users to create txt documents.</html>");
        text.setBounds(150, 100, 500, 300);
        text.setFont(new Font("SAN SERIF", Font.PLAIN, 16));
        add(text);
        
        JButton b1 = new JButton("OK");
        b1.setBounds(150, 350, 120, 25);
        b1.addActionListener(this);
        add(b1);
        
        setVisible(true);
    }
    
    public static void main(String[] args){
        new Help();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }
}
