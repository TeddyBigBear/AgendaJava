package com.itii.planning.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;

/**
 * 
 * @author L�a - Th�odore - Groupe E TODO Fill javadoc
 */
public class MainWindow extends JFrame
{
    private static MainWindow instance = null;

    public static MainWindow getInstance()
    {
        if (instance == null)
        {
            instance = new MainWindow();
        }
        return instance;
    }

    // TODO JavaDoc
    private MainWindow()
    {
        CreatePanels();//TOOD Remove this
        CreateMenuBar();// la creation du menu bar doit se faire avant le initialize
        initialize();
    }

    // TODO Javadoc
    private void initialize()
    {

        this.setSize(900, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.validate();
        this.repaint();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // TODO javadoc
    private void CreateMenuBar()
    {
        setTitle("Menu Example");

        // Creates a menubar for a JFrame
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Define and add two drop down menu to the menubar
        JMenu fileMenu = new JMenu("Fichier");
        JMenu editMenu = new JMenu("Edition");
        JMenu ViewMenu = new JMenu("Vue");
        JMenu helpMenu = new JMenu("Aide");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(ViewMenu);
        menuBar.add(helpMenu);

        // Create and add simple menu item to one of the drop down menu
        // what is in the "Fichier" menu
        JMenuItem QuitAction = new JMenuItem("Quitter");

        // what is in the "Edition" menu
        JMenuItem CreateAction = new JMenuItem("Cr�er");
        JMenuItem EditAction = new JMenuItem("Editer");
        JMenuItem MarkAction = new JMenuItem("Marquer");
        JMenuItem DuplicateAction = new JMenuItem("Dupliquer");
        JMenuItem DeleteAction = new JMenuItem("Supprimer");

        // what is in the "Vue" menu
        JMenuItem ListAction = new JMenuItem("Cr�er");
        JMenuItem WeeksAction = new JMenuItem("Editer");
        JMenuItem MonthAction = new JMenuItem("Marquer");

        // what is in the "Fichier" menu
        fileMenu.add(QuitAction);

        // what is in the "Edition" menu
        editMenu.add(CreateAction);
        editMenu.add(EditAction);
        editMenu.add(MarkAction);
        editMenu.add(DuplicateAction);
        editMenu.add(DeleteAction);

        // what is in the "Vue" menu
        ViewMenu.add(ListAction);
        ViewMenu.add(WeeksAction);
        ViewMenu.add(MonthAction);

    }

    // TODO Javadoc
    private void CreatePanels()
    {
        // these are the components we need.

        JPanel LeftPanel; // container panel for the bottom
        JPanel RightPanel; // container panel for the top

        JButton button;

        RightPanel = new JPanel(); // our top component
        LeftPanel = new JPanel(); // our bottom component

        button = new JButton("C'est un bouton"); // and a button at the right, to send the

        setPreferredSize(new Dimension(200, 200)); // let's open the window with
        getContentPane().setLayout(new GridLayout()); // the default GridLayout

        RightPanel.setSize(200, 40);
        RightPanel.setLayout(new GridLayout(5, 1)); // BoxLayout.Y_AXIS
        RightPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        
        LeftPanel.setLayout(new GridLayout(1, 1)); // BoxLayout.Y_AXIS
        LeftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        
        RightPanel.add(button);
        
        //RightPanel.setBackground(Color.ORANGE);   
        //LeftPanel.setBackground(Color.RED);
        
        getContentPane().add(LeftPanel);   
        getContentPane().add(RightPanel); 
        
        /*setSize(500,400);
        setVisible(true);

    //declaration container
        getContentPane();
    
    
        JPanel menu =new JPanel();
        JPanel MessageList =new JPanel();
        JPanel about=new JPanel();
    
        menu.setBackground(Color.blue);
        MessageList.setBackground(Color.cyan);
        about.setBackground(Color.cyan);
        
        //--------Button---------------------
        JButton button1=new JButton("button1");
        JButton button2=new JButton("Button2");
    
        menu.add(button1);
        menu.add(button2);*/
      
    }
}
