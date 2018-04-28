package com.itii.planning.gui;


import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import javax.swing.JTextField;
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
        initialize();
    }

    // TODO Javadoc
    private void initialize()
    {

        this.setSize(1000, 1000);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.validate();
        this.repaint();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
}
