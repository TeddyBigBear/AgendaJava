package com.itii.planning.gui;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.ScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;

/**
 * 
 * @author L�a - Th�odore - Groupe E 
 * TODO Fill javadoc
 */
public class MainWindow extends JFrame
{
    private static MainWindow instance = null;
    private JTextField textField;
    private static enum Views {Liste, Mois, Semaine}

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
        
        getContentPane().setLayout(new BorderLayout()); // TODO put getContent plane in a name
        
        
        //On construit le panel principal
        JPanel panel_Left = new JPanel();
        getContentPane().add(panel_Left, BorderLayout.CENTER);
        panel_Left.setLayout(null);
        
        //On remplis le panel principal
        fillLeftPanel(panel_Left);

        
        //On construit le panel de droite
        JPanel panel_Button = new JPanel();
        getContentPane().add(panel_Button, BorderLayout.EAST);
        panel_Button.setLayout(new GridLayout(5, 1));

        //On remplis le panel de droite
        rightPanelButtonFill(panel_Button);
        
    }
    
 

    private void fillLeftPanel(JPanel panel_Left)
    {
        //Create textField
        textField = new JTextField();
        textField.setBounds(20, 11, 358, 20);
        textField.setColumns(50);
        panel_Left.add(textField);
        
        
        //Create and fill Combobox
        JComboBox<Views> comboBoxView = new JComboBox<Views>(Views.values());
        comboBoxView.setBounds(419, 11, 205, 20);
        panel_Left.add(comboBoxView);
        
        
        
        JTextPane txtpnVue = new JTextPane();
        txtpnVue.setBackground(SystemColor.menu); // TODO Globalize color variable
        txtpnVue.setText("Vue :");
        txtpnVue.setBounds(378, 11, 42, 20);
        panel_Left.add(txtpnVue);
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(20, 41, 604, 388);
        panel_Left.add(layeredPane);
        
        
        
        ScrollPane panel_Vue_Liste = createVueListe(layeredPane);
        ScrollPane panel_Vue_Semaine = createVueSemaine(layeredPane);
        ScrollPane panel_Vue_Mois = createVueMois(layeredPane);

        
        //This is the default panel
        layeredPane.moveToFront(panel_Vue_Liste);
        
        comboBoxView.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent changedcomboboxItem) {
                
                switch (comboBoxView.getSelectedIndex())
                {
                case 0:
                    layeredPane.moveToFront(panel_Vue_Liste);
                    break;
                case 1:
                    layeredPane.moveToFront(panel_Vue_Semaine);
                    break;
                case 2:
                    layeredPane.moveToFront(panel_Vue_Mois);
                    break;

                default:
                    layeredPane.moveToFront(panel_Vue_Mois);
                    break;
                    
                }
                layeredPane.revalidate();
                layeredPane.repaint();
            }
        });
        
    }

    private ScrollPane createVueMois(JLayeredPane layeredPane)
    {
        ScrollPane panel_Vue_Mois = new ScrollPane();
        panel_Vue_Mois.setBounds(10, 10, 594, 378);
        panel_Vue_Mois.setBackground(Color.black);
        layeredPane.add(panel_Vue_Mois, new ScrollPane());
        return panel_Vue_Mois;
    }

    private ScrollPane createVueSemaine(JLayeredPane layeredPane)
    {
        ScrollPane panel_Vue_Semaine = new ScrollPane();
        panel_Vue_Semaine.setBounds(10, 10, 594, 378);
        panel_Vue_Semaine.setBackground(Color.red);
        layeredPane.add(panel_Vue_Semaine, new ScrollPane());
        return panel_Vue_Semaine;
    }

    private ScrollPane createVueListe(JLayeredPane layeredPane)
    {
        ScrollPane panel_Vue_Liste = new ScrollPane();
        panel_Vue_Liste.setBounds(10, 10, 594, 378);
        panel_Vue_Liste.setBackground(Color.blue);

        String[] columnNames = {"Nom de la t�che",
                "Date d�e",
                "D�tails"};
        
        //JList, list
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable list = new JTable(tableModel);

        Object[][] data = {
                {"TP #1", "04/05/2018", "terminer le TP"}
            };
        
        
        ((DefaultTableModel) list.getModel()).addRow(new Object[] {"TP #1", "04/05/2018", "terminer le TP"});
        ((DefaultTableModel) list.getModel()).addRow(new Object[] {"TP #2", "04/05/2018", "terminer le TP"});
        
        tableModel.removeRow(1);
        
        ((DefaultTableModel) list.getModel()).addRow(new Object[] {"TP #3", "04/05/2018", "terminer le TP"});

        
        //list properties
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.BLACK));
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //Add JScrollPane to list   [What I need help with, its not working]
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));

        //Setbounds, add list and repaint frame
        listScroller.setBounds(25, 25, 100, 100);
        panel_Vue_Liste.add(listScroller);

        layeredPane.add(panel_Vue_Liste, new ScrollPane());
        return panel_Vue_Liste;
    }

    private void rightPanelButtonFill(JPanel panel_Button)
    {
        JButton btnCreate = new JButton("Cr�er");
        btnCreate.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent clickedButton) {
				
				
			}
        	
        });
        panel_Button.add(btnCreate);
        
        JButton btnEdit = new JButton("Editer");
        panel_Button.add(btnEdit);
        
        JButton btnMark = new JButton("Marquer");
        btnCreate.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent clickedButton) {
				
			}
        	
        });
        panel_Button.add(btnMark);
        
        JButton btnDuplicate = new JButton("Dupliquer");
        btnCreate.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent clickedButton) {
				
			}
        	
        });
        panel_Button.add(btnDuplicate);
        
        JButton btnDelete = new JButton("Supprimer");
        btnCreate.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent clickedButton) {
				
			}
        	
        });
        panel_Button.add(btnDelete);
    }


}