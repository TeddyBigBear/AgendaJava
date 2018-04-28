package com.itii.planning.gui;
import com.itii.planning.gui.CalendarPanel;


import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JEditorPane;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

/**
 * 
 * @author Léa - Théodore - Groupe E TODO Fill javadoc
 */
public class SecondWindow extends JFrame
{
    private static SecondWindow instance = null;
    private JTextField textField;

    public static SecondWindow getInstance()
    {
        if (instance == null)
        {
            instance = new SecondWindow();
        }
        return instance;
    }
    
    private SecondWindow()
    {
        createPanel();
        createCalendar();
        initialize();
  
    }

    // TODO Javadoc
    private void initialize()
    {

        this.setSize(1000, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Nouvelle Tâche");
        this.setVisible(true);
        this.validate();
        this.repaint();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    private void createPanel() {
        getContentPane().setLayout(new GridLayout(1,1));
        
        JPanel panel_Left = new JPanel();
        
        
        JTextPane label=new JTextPane();
        label.setBackground(SystemColor.menu);
        label.setFont(new Font("Sylfaen", Font.PLAIN,22));
        label.setText("Nouvelle Tâche : ");
        label.setBounds(5, 50, 200, 40);
        panel_Left.add(label);
        textField = new JTextField();
        textField.setFont(new Font("Sylfaen", Font.PLAIN,22));
        textField.setBounds(200, 50, 400, 40);
        panel_Left.add(textField);
        
        JTextPane label1=new JTextPane();
        label1.setBackground(SystemColor.menu);
        label1.setFont(new Font("Sylfaen", Font.PLAIN,22));
        label1.setText("Date dûe : ");
        label1.setBounds(5, 100, 200, 40);
        panel_Left.add(label1);
        
        JTextPane label2=new JTextPane();
        label2.setBackground(SystemColor.menu);
        label2.setFont(new Font("Sylfaen", Font.PLAIN,22));
        label2.setText("Détails : ");
        label2.setBounds(5, 150, 200, 40);
        panel_Left.add(label2);
       
        
        panel_Left.setAlignmentY(Component.TOP_ALIGNMENT);
        getContentPane().add(panel_Left);
        panel_Left.setLayout(null);
        textField = new JTextField();
        textField.setFont(new Font("Sylfaen", Font.PLAIN,22));
        textField.setBounds(200, 50, 400, 40);
        panel_Left.add(textField);
    }


    private void createCalendar(){
    
        CalendarPanel calendar= new CalendarPanel();
        calendar.setBounds(500, 50, 20, 40);
        getContentPane().setLayout(new GridLayout(1,1));
        JPanel panel_Right = new JPanel();
        panel_Right.setAlignmentY(Component.TOP_ALIGNMENT);
        getContentPane().add(panel_Right);
        panel_Right.add(calendar);
        
        
    }
}
