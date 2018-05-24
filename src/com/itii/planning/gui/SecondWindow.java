package com.itii.planning.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.JDatePicker;

//import de.wannawork.jcalendar.*;

/**
 * 
 * @author Lï¿½a - Thï¿½odore - Groupe E TODO Fill javadocsdfghjkjhgfds
 */
public class SecondWindow extends JFrame
{
    private static SecondWindow instance = null;
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
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //TODO make sure the second window can be reopened
    }
    
    //TODO Javadoc
    private void createPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        JTextPane label=new JTextPane();
        label.setBackground(SystemColor.menu);
        label.setFont(new Font("Sylfaen", Font.PLAIN,22));
        label.setText("Nom de la tâche : ");
        label.setEditable(false);
        add(label);
        JTextField textField = new JTextField();
        textField.setBackground(SystemColor.menu);
        textField.setPreferredSize(new Dimension(335,40));
        textField.setFont(new Font("Sylfaen", Font.PLAIN,22));
        add(textField);
        
        JTextPane label2=new JTextPane();
        label2.setBackground(SystemColor.menu);
        label2.setFont(new Font("Sylfaen", Font.PLAIN,22));
        label2.setPreferredSize(new Dimension(90,250));
        label2.setText("Détails : ");
        label2.setEditable(false);
        add(label2);
        JTextArea textArea = new JTextArea();
        textArea.setBackground(Color.WHITE);
        textArea.setPreferredSize(new Dimension(418,250));
        add(textArea);
        
        JTextPane label3=new JTextPane();
        label3.setBackground(SystemColor.menu);
        label3.setFont(new Font("Sylfaen", Font.PLAIN,22));
        label3.setPreferredSize(new Dimension(110,40));
        label3.setText("Date dûe : ");
        label3.setEditable(false);
        add(label3);
        
        
        JDatePicker calendar = CalendarPanel.getCalendar();
        add(calendar);
        
        JTextPane label4=new JTextPane();
        label4.setBackground(SystemColor.menu);
        label4.setFont(new Font("Sylfaen", Font.PLAIN,22));
        label4.setPreferredSize(new Dimension(200,40));
        label4.setEditable(false);
        add(label4);
        JTextPane label5=new JTextPane();
        label5.setBackground(SystemColor.menu);
        label5.setFont(new Font("Sylfaen", Font.PLAIN,22));
        label5.setPreferredSize(new Dimension(600,40));
        label5.setEditable(false);
        add(label5);
        JTextPane label6=new JTextPane();
        label6.setBackground(SystemColor.menu);
        label6.setFont(new Font("Sylfaen", Font.PLAIN,22));
        label6.setPreferredSize(new Dimension(150,40));
        label6.setEditable(false);
        add(label6);
        
       
        //The buttons
        JButton btnCancel = new JButton("Annuler");
        btnCancel.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent clickedButton) {
				dispose();
			}
        });
        btnCancel.setPreferredSize(new Dimension(100,40));
        add(btnCancel);
        
        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent clickedButton) {
				((DefaultTableModel) MainWindow.list.getModel()).addRow(
						new Object[] {
								textField.getText(), 
								calendar.getFormattedTextField().getText(), 
								textArea.getText()
								}
						);
			}
        });
        btnOk.setPreferredSize(new Dimension(100,40));
        add(btnOk);        

    }
    
}
