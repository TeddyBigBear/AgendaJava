package com.itii.planning.gui;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.ScrollPane;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLayeredPane;

/**
 * 
 * @author Lï¿½a - Thï¿½odore - Groupe E 
 * TODO Fill javadoc
 */
public class MainWindow extends JFrame
{
    private static MainWindow instance = null;
    private JTextField textField;

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
        CreatePanels();
        CreateMenuBar();// la creation du menu bar doit se faire avant le initialize
        initialize();
    }

    // TODO Javadoc
    private void initialize()
    {
        this.setSize(737, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.validate();
        this.repaint();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // TODO javadoc
    private void CreateMenuBar()
    {
        setTitle("Menu");

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
        JMenuItem CreateAction = new JMenuItem("Crï¿½er");
        JMenuItem EditAction = new JMenuItem("Editer");
        JMenuItem MarkAction = new JMenuItem("Marquer");
        JMenuItem DuplicateAction = new JMenuItem("Dupliquer");
        JMenuItem DeleteAction = new JMenuItem("Supprimer");

        // what is in the "Vue" menu
        JMenuItem ListAction = new JMenuItem("Crï¿½er");
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
        
        getContentPane().setLayout(new BorderLayout()); // TODO put getContent plane in a name
        
        
        //Le panel principal
        JPanel panel_Left = new JPanel();
        getContentPane().add(panel_Left, BorderLayout.CENTER);
        panel_Left.setLayout(null);
        
        
        //Les elements du panel principal
        textField = new JTextField();
        textField.setBounds(20, 11, 358, 20);
        textField.setColumns(50);
        panel_Left.add(textField);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(419, 11, 205, 20);
        panel_Left.add(comboBox);
        

        //TODO ajouter les trois panel avec les trois vues differentes
        ScrollPane panel_Vue_Liste = new ScrollPane();
        panel_Vue_Liste.setBounds(20, 41, 604, 388);
        panel_Vue_Liste.setBackground(Color.blue);

        ScrollPane panel_Vue_Semaine = new ScrollPane();
        panel_Vue_Semaine.setBounds(20, 41, 604, 388);
        panel_Vue_Semaine.setBackground(Color.red);

        ScrollPane panel_Vue_Mois = new ScrollPane();
        panel_Vue_Mois.setBounds(20, 41, 604, 388);
        panel_Vue_Mois.setBackground(Color.black);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(20, 41, 604, 388);
        panel_Left.add(layeredPane);

        layeredPane.add(panel_Vue_Liste, new ScrollPane());
        layeredPane.add(panel_Vue_Mois, new ScrollPane());
        layeredPane.add(panel_Vue_Semaine, new ScrollPane());

        layeredPane.moveToFront(panel_Vue_Mois);

        JTextPane txtpnVue = new JTextPane();
        txtpnVue.setBackground(SystemColor.menu); // TODO Globalize color variable
        txtpnVue.setText("Vue :");
        txtpnVue.setBounds(378, 11, 42, 20);
        panel_Left.add(txtpnVue);
     
        
        //Le panel de droite
        JPanel panel_Button = new JPanel();
        getContentPane().add(panel_Button, BorderLayout.EAST);
        panel_Button.setLayout(new GridLayout(5, 1));

        
        //Les elements du panel de droite
        JButton btnCreate = new JButton("Créer");
        panel_Button.add(btnCreate);
        
        JButton btnEdit = new JButton("Editer");
        panel_Button.add(btnEdit);
        
        JButton btnMark = new JButton("Marquer");
        panel_Button.add(btnMark);
        
        JButton btnDuplicate = new JButton("Dupliquer");
        panel_Button.add(btnDuplicate);
        
        JButton btnDelete = new JButton("Supprimer");
        panel_Button.add(btnDelete);
        
    }
}
