package com.itii.planning.gui;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * 
 * @author L�a - Th�odore - Groupe E TODO Fill javadoc
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
        //getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        getContentPane().setLayout(new GridLayout(1, 2));
        
        JPanel panel_Left = new JPanel();
        panel_Left.setAlignmentY(Component.TOP_ALIGNMENT);
        getContentPane().add(panel_Left);
        panel_Left.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(20, 5, 358, 20);
        panel_Left.add(textField);
        textField.setColumns(44);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(400, 5, 28, 20);
        panel_Left.add(comboBox);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(555, 62, -533, 367);
        panel_Left.add(scrollPane);
        
        JPanel panel_Right = new JPanel();
        panel_Right.setAlignmentY(Component.TOP_ALIGNMENT);
        getContentPane().add(panel_Right);
        panel_Right.setLayout(new GridLayout(5, 1));
        //ButtonPanel.setLayout(new GridLayout(5, 1));
        
        JButton btnCreate = new JButton("Cr�e");
        panel_Right.add(btnCreate);
        
        JButton btnEdit = new JButton("Editer");
        panel_Right.add(btnEdit);
        
        JButton btnMark = new JButton("Marquer");
        panel_Right.add(btnMark);
        
        JButton btnDuplicate = new JButton("Dupliquer");
        panel_Right.add(btnDuplicate);
        
        JButton btnDelete = new JButton("Supprimer");
        panel_Right.add(btnDelete);
    }
}
