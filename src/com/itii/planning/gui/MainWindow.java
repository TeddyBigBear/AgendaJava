package com.itii.planning.gui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * 
 * @author Léa-Groupe E
 *
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

    private MainWindow()
    {
        CreateMenuBar();//la creation du menu bar doit se faire avant le initialize
        initialize();
    }

    private void initialize()
    {

        this.setSize(900, 500);
        this.setVisible(true);
        this.validate();
        this.repaint();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //TODO : create javadoc
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
        //what is in the "Fichier" menu
        JMenuItem QuitAction = new JMenuItem("Quitter");
        
        //what is in the "Edition" menu
        JMenuItem CreateAction = new JMenuItem("Créer");
        JMenuItem EditAction = new JMenuItem("Editer");
        JMenuItem MarkAction = new JMenuItem("Marquer");
        JMenuItem DuplicateAction = new JMenuItem("Dupliquer");
        JMenuItem DeleteAction = new JMenuItem("Supprimer");
        
        //what is in the "Vue" menu
        JMenuItem ListAction = new JMenuItem("Créer");
        JMenuItem WeeksAction = new JMenuItem("Editer");
        JMenuItem MonthAction = new JMenuItem("Marquer");

        //what is in the "Fichier" menu
        fileMenu.add(QuitAction);
        
        //what is in the "Edition" menu
        editMenu.add(CreateAction);
        editMenu.add(EditAction);
        editMenu.add(MarkAction);
        editMenu.add(DuplicateAction);
        editMenu.add(DeleteAction);

        //what is in the "Vue" menu
        ViewMenu.add(ListAction);
        ViewMenu.add(WeeksAction);
        ViewMenu.add(MonthAction);        
         
    }
}
