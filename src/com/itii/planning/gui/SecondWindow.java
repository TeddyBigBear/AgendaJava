package com.itii.planning.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import org.jdatepicker.JDatePicker;

//import de.wannawork.jcalendar.*;

/**
 * 
 * @author Lï¿½a - Thï¿½odore - Groupe E TODO Fill javadocsdfghjkjhgfds
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
        createPanelBis();
       // createCalendar();
        initialize();
  
    }

    // TODO Javadoc
    private void initialize()
    {

        this.setSize(550, 500);
        this.setLocationRelativeTo(null);
        this.setTitle("Nouvelle Tâche");
        this.setVisible(true);
        this.validate();
        this.repaint();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    private void createPanelBis() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        JTextPane label=new JTextPane();
        label.setBackground(SystemColor.menu);
        label.setFont(new Font("Sylfaen", Font.PLAIN,22));
        label.setBackground(Color.WHITE);
        label.setText("Nom de la tâche : ");
        add(label);
        JTextField textField = new JTextField();
        textField.setBackground(Color.CYAN);
        textField.setPreferredSize(new Dimension(335,40));
        textField.setFont(new Font("Sylfaen", Font.PLAIN,22));
        add(textField);
        
        JTextPane label2=new JTextPane();
        label2.setBackground(Color.RED);
        label2.setFont(new Font("Sylfaen", Font.PLAIN,22));
        label2.setPreferredSize(new Dimension(90,250));
        label2.setText("Détails : ");
        add(label2);
        JTextArea textArea = new JTextArea();
        textArea.setBackground(Color.CYAN);
        textArea.setPreferredSize(new Dimension(418,250));
        add(textArea);
        
        JTextPane label3=new JTextPane();
        label3.setBackground(Color.YELLOW);
        label3.setFont(new Font("Sylfaen", Font.PLAIN,22));
        label3.setPreferredSize(new Dimension(110,40));
        label3.setText("Date dûe : ");
        add(label3);
        JDatePicker calendar = CalendarPanel.getCalendar();
        add(calendar);
        
        JTextPane label4=new JTextPane();
        label4.setBackground(Color.PINK);
        label4.setFont(new Font("Sylfaen", Font.PLAIN,22));
        label4.setPreferredSize(new Dimension(200,40));
        label4.setText("");
        add(label4);
        JTextPane label5=new JTextPane();
        label5.setBackground(Color.PINK);
        label5.setFont(new Font("Sylfaen", Font.PLAIN,22));
        label5.setPreferredSize(new Dimension(600,40));
        label5.setText("");
        add(label5);
        JTextPane label6=new JTextPane();
        label6.setBackground(Color.PINK);
        label6.setFont(new Font("Sylfaen", Font.PLAIN,22));
        label6.setPreferredSize(new Dimension(150,40));
        label6.setText("");
        add(label6);
        JButton btnCancel = new JButton("Annuler");
        btnCancel.setPreferredSize(new Dimension(100,40));
        add(btnCancel);
        JButton btnOk = new JButton("OK");
        btnOk.setPreferredSize(new Dimension(100,40));
        add(btnOk);        

        
        
    }
    private void createPanel() {
        getContentPane().setLayout(new GridLayout(1,1));
        JPanel panel_Left = new JPanel();
        JTextPane label=new JTextPane();
        label.setBackground(SystemColor.menu);
        label.setFont(new Font("Sylfaen", Font.PLAIN,22));
        label.setText("Nom de la tâche : ");
        label.setBounds(5, 50, 200, 40);
        panel_Left.add(label);
        textField = new JTextField();
        textField.setFont(new Font("Sylfaen", Font.PLAIN,22));
        textField.setBounds(200, 50, 200, 40);
        panel_Left.add(textField);
        
        JTextPane label2=new JTextPane();
        label2.setBackground(SystemColor.menu);
        label2.setFont(new Font("Sylfaen", Font.PLAIN,22));
        label2.setText("Détails : ");
        label2.setBounds(5, 100, 200, 40);
        panel_Left.add(label2);
        JTextField textField2 = new JTextField();
        textField2.setFont(new Font("Sylfaen", Font.PLAIN,22));
        textField2.setBounds(200, 100, 400, 250);
        panel_Left.add(textField2);
       
        
        panel_Left.setAlignmentY(Component.TOP_ALIGNMENT);
        panel_Left.setLayout(null);
        textField = new JTextField();
        textField.setFont(new Font("Sylfaen", Font.PLAIN,22));
        textField.setBounds(200, 50, 400, 40);
        panel_Left.add(textField);
        panel_Left.revalidate();
        
        getContentPane().add(panel_Left);
    }


   private void createCalendar(){
       getContentPane().setLayout(new GridLayout(1,1));
       JPanel RightPanel=new JPanel();
       RightPanel.setSize(200,20);
       
      RightPanel.setBackground(Color.RED);
       JTextPane label1=new JTextPane();
       label1.setBackground(SystemColor.menu);
       label1.setFont(new Font("Sylfaen", Font.PLAIN,22));
       label1.setText("Date dûe : ");
       label1.setBounds(10, 50, 200, 40);
       RightPanel.add(label1);
       //RightPanel.setLayout(null);
       RightPanel.add(CalendarPanel.getCalendar());

       
       
       RightPanel.setAlignmentY(Component.RIGHT_ALIGNMENT);
       RightPanel.setBounds(600,200,200,200);
       
       
       getContentPane().add(RightPanel);      
    }
    
}
