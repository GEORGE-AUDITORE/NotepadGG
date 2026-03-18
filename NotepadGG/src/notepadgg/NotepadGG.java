
package notepadgg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;


public class NotepadGG extends JFrame implements ActionListener {
    
    JTextArea area;
    String text;
    
    NotepadGG() {
        setTitle("NotepadGG");
        ImageIcon notepadIcon = new ImageIcon(ClassLoader.getSystemResource("notepadgg/icons/Notepad-icon.png"));
        Image icon = notepadIcon.getImage();
        setIconImage(icon);
        
        java.net.URL url = ClassLoader.getSystemResource("notepadgg/icons/Notepad-icon.png");

        
        JMenuBar menubar = new JMenuBar();
        menubar.setBackground(Color.LIGHT_GRAY);
        JMenu file = new JMenu("File");
        file.setFont(new Font ("ARIAL", Font.PLAIN, 14));
        
        JMenuItem newdoc = new JMenuItem("New");
        newdoc.addActionListener(this);
        newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        
        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(this);
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(this);
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        
        JMenuItem print = new JMenuItem("Print");
        print.addActionListener(this);
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, ActionEvent.CTRL_MASK));
        
        file.add(newdoc);
        file.add(open);
        file.add(save);
        file.add(print);
        file.add(exit);
        
        menubar.add(file);
        
        JMenu edit = new JMenu("Edit");
        edit.setFont(new Font ("ARIAL", Font.PLAIN, 14));
        
        JMenuItem copy = new JMenuItem("Copy");
        copy.addActionListener(this);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        
        JMenuItem paste = new JMenuItem("Paste");
        paste.addActionListener(this);
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        
        JMenuItem cut = new JMenuItem("Cut");
        cut.addActionListener(this);
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        
        JMenuItem selectall = new JMenuItem("Select All");
        selectall.addActionListener(this);
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        
        edit.add(copy);
        edit.add(paste);
        edit.add(cut);
        edit.add(selectall);
        
        menubar.add(edit);
        
        JMenu helpmenu = new JMenu("Help");
        helpmenu.setFont(new Font ("ARIAL", Font.PLAIN, 14));
        
        JMenuItem help = new JMenuItem("Help");
        help.addActionListener(this);
        help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        
        helpmenu.add(help);
        menubar.add(helpmenu);
        
        setJMenuBar(menubar);
        
        area = new JTextArea();
        area.setFont(new Font ("SAN_SERIF", Font.PLAIN, 18));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        add(area);
        
        JScrollPane pane = new JScrollPane(area);
        pane.setBorder(BorderFactory.createEmptyBorder());
        add(pane);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(600, 400)); 

        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("New")){
        area.setText(""); 
    } else if (e.getActionCommand().equals("Open")){
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files" , "txt");
        chooser.addChoosableFileFilter(restrict);
        
        int action = chooser.showOpenDialog(this);
        
        if(action != JFileChooser.APPROVE_OPTION) {
            return;
        }
        
        File file = chooser.getSelectedFile();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            area.read(reader, null);
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    } else if (e.getActionCommand().equals("Save")) {
        JFileChooser saveas = new JFileChooser();
        saveas.setApproveButtonText("Save");
        int action = saveas.showOpenDialog(this);
        if(action != JFileChooser.APPROVE_OPTION) {
            return;
        }
        
        File filename = new File(saveas.getSelectedFile() + ".txt");
        BufferedWriter outFile = null;
        try {
            outFile = new BufferedWriter(new FileWriter(filename));
            area.write(outFile);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        
    } else if (e.getActionCommand().equals("Print")){
        try{
            area.print();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    } else if (e.getActionCommand().equals("Exit")) {
        System.exit(0);
    } else if (e.getActionCommand().equals("Copy")) {
        text = area.getSelectedText();
    } else if (e.getActionCommand().equals("Paste")){
        area.insert(text, area.getCaretPosition());
    } else if (e.getActionCommand().equals("Cut")) {
        text = area.getSelectedText();
        area.replaceRange("", area.getSelectionStart(), area.getSelectionEnd());
    } else if (e.getActionCommand().equals("Select All")) {
        area.selectAll();
    } else if (e.getActionCommand().equals("Help")) {
        new Help().setVisible(true);
    }
       
    
}

       
    
    public static void main(String[] args) {
        new NotepadGG();
    }
}
    
