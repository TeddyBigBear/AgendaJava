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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;
import javax.swing.JList;

/**
 * 
 * @author L�a - Th�odore - Groupe E 
 * TODO Fill javadoc dffghjklkjhgfd
 */
public class MainWindow extends JFrame
{ 
    private static MainWindow instance = null;
    private JTextField textField;
    private static enum Views {Liste, Mois, Semaine}
    public static JTable list = createList();

    // TODO Javadoc
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
        this.setResizable(false);
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
        QuitAction.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent clickedButton) {
                //TODO This is probably where the data about the new task will get retreived
                dispose();
            }
        });
        // what is in the "Edition" menu
        JMenuItem CreateAction = new JMenuItem("Cr�er");
        CreateAction.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent clickedButton) {
                //TODO This is probably where the data about the new task will get retreived
                SecondWindow.getInstance().setVisible(true);
            }
        });
        JMenuItem EditAction = new JMenuItem("Editer");
        EditAction.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent clickedButton) {
                ThirdWindow.getInstance().setVisible(true);
            }
        });
        JMenuItem MarkAction = new JMenuItem("Marquer");
        JMenuItem DuplicateAction = new JMenuItem("Dupliquer");
        JMenuItem DeleteAction = new JMenuItem("Supprimer");

        // what is in the "Vue" menu
        JMenuItem ListAction = new JMenuItem("Liste");
        JMenuItem WeeksAction = new JMenuItem("Semaine");
        JMenuItem MonthAction = new JMenuItem("Mois");

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
        
        //On remplit le panel principal
        fillLeftPanel(panel_Left);
        
        //On construit le panel de droite
        JPanel panel_Button = new JPanel();
        getContentPane().add(panel_Button, BorderLayout.EAST);
        panel_Button.setLayout(new GridLayout(5, 1));

        //On remplis le panel de droite
        rightPanelButtonFill(panel_Button);
        
    }
 
    // TODO Javadoc
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
        
        //add the "Vue :" before the combobox
        JTextPane txtpnVue = new JTextPane();
        txtpnVue.setBackground(SystemColor.menu); // TODO Globalize color variable
        txtpnVue.setText("Vue :");
        txtpnVue.setBounds(378, 11, 42, 20);
        panel_Left.add(txtpnVue);
        
        //Create the layered plane
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(20, 41, 604, 388);
        panel_Left.add(layeredPane);
        
        
        //Create and add all three panels
        ScrollPane panel_Vue_Liste = createVueListe(layeredPane);
        ScrollPane panel_Vue_Semaine = createVueSemaine(layeredPane);
        ScrollPane panel_Vue_Mois = createVueMois(layeredPane);

        
        //This is the default panel
        layeredPane.moveToFront(panel_Vue_Liste);
        
        addActionToButton(comboBoxView, layeredPane, panel_Vue_Liste, panel_Vue_Semaine, panel_Vue_Mois);
        
    }

	private void addActionToButton(JComboBox<Views> comboBoxView, JLayeredPane layeredPane, ScrollPane panel_Vue_Liste,
			ScrollPane panel_Vue_Semaine, ScrollPane panel_Vue_Mois) {
		comboBoxView.addActionListener(new ActionListener () {
            public void actionPerformed(ActionEvent changedcomboboxItem) {
                
                switch (comboBoxView.getSelectedIndex())
                {
                case 0:
                    layeredPane.moveToFront(panel_Vue_Liste);
                    break;
                case 1:
                    
                    layeredPane.moveToFront(panel_Vue_Mois);
                    break;
                case 2:
                	layeredPane.moveToFront(panel_Vue_Semaine);
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

    // TODO Javadoc
    private ScrollPane createVueMois(JLayeredPane layeredPane)
    {
        ScrollPane panel_Vue_Mois = new ScrollPane();
        panel_Vue_Mois.setBounds(10, 10, 594, 378);
        panel_Vue_Mois.setBackground(Color.black);
        
        JList<Object> list =  new JList<Object>();
        list.setPreferredSize(new Dimension(200, 200));
        
        panel_Vue_Mois.add(list, new JScrollPane());
        layeredPane.add(panel_Vue_Mois, new ScrollPane());
        return panel_Vue_Mois;
    }

    // TODO Javadoc
    private ScrollPane createVueSemaine(JLayeredPane layeredPane)
    {
        ScrollPane panel_Vue_Semaine = new ScrollPane();
        panel_Vue_Semaine.setBounds(10, 10, 594, 378);
        panel_Vue_Semaine.setBackground(Color.red);

        layeredPane.add(panel_Vue_Semaine, new ScrollPane());
        return panel_Vue_Semaine;
    }

    // TODO Javadoc
    private ScrollPane createVueListe(JLayeredPane layeredPane)
    {
        ScrollPane panel_Vue_Liste = new ScrollPane();
        panel_Vue_Liste.setBounds(10, 10, 594, 378);
        
        //Add JScrollPane to list   [What I need help with, its not working]
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));

        //Setbounds, add list and repaint frame
        listScroller.setBounds(25, 25, 100, 100);
        panel_Vue_Liste.add(listScroller);

        layeredPane.add(panel_Vue_Liste, new ScrollPane());
        return panel_Vue_Liste;
    }

    // TODO Javadoc
	private static JTable createList() {
		String[] columnNames = {"Nom de la t�che",
                "Date d�e",
                "D�tails"};
        
        //JList, list
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable list = new JTable(tableModel);
        
        //list properties
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0,Color.BLACK));
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		return list;
	}

	// TODO Javadoc
    private void rightPanelButtonFill(JPanel panel_Button)
    {
        JButton btnCreate = new JButton("Creer");
        btnCreate.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent clickedButton) {
				//TODO This is probably where the data about the new task will get retreived	    
				SecondWindow.getInstance().setVisible(true);
			}
        });
        panel_Button.add(btnCreate);
        
        JButton btnEdit = new JButton("Editer");
        btnEdit.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent clickedButton) {
				ThirdWindow.getInstance().setVisible(true);
			}
        });
        panel_Button.add(btnEdit);
        
        JButton btnMark = new JButton("Marquer");
        btnMark.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent clickedButton) {
				
			}
        });
        panel_Button.add(btnMark);
        
        JButton btnDuplicate = new JButton("Dupliquer");
        btnDuplicate.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent clickedButton) {
				//basicaly take the data and add the said data
				//as of now i only add data
				((DefaultTableModel) list.getModel()).addRow(new Object[] {"TP #2", "04/05/2018", "terminer le TP"}); 
			}
        });
        panel_Button.add(btnDuplicate);
        
        JButton btnDelete = new JButton("Supprimer");
        btnDelete.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent clickedButton) {
				//tableModel.removeRow();
				//list.remove(list.getSelectedRow());
				list.remove(1);
			}
        });
        panel_Button.add(btnDelete);
    }


}