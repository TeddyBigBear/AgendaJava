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
        JMenuItem CreateAction = new JMenuItem("Créer");
        JMenuItem EditAction = new JMenuItem("Editer");
        JMenuItem MarkAction = new JMenuItem("Marquer");
        JMenuItem DuplicateAction = new JMenuItem("Dupliquer");
        JMenuItem DeleteAction = new JMenuItem("Supprimer");

        // what is in the "Vue" menu
        JMenuItem ListAction = new JMenuItem("Créer");
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
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        
        JPanel panel = new JPanel();
        panel.setAlignmentY(Component.TOP_ALIGNMENT);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(20, 5, 358, 20);
        panel.add(textField);
        textField.setColumns(44);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(400, 5, 28, 20);
        panel.add(comboBox);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(555, 62, -533, 367);
        panel.add(scrollPane);
        
        JPanel panel_1 = new JPanel();
        panel_1.setAlignmentY(Component.TOP_ALIGNMENT);
        getContentPane().add(panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
        
        JButton btnNewButton = new JButton("New button");
        panel_1.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("New button");
        panel_1.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("New button");
        panel_1.add(btnNewButton_2);
    }
}
