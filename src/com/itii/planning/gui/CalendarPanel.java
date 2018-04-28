package com.itii.planning.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.plaf.synth.SynthSpinnerUI;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CalendarPanel extends JPanel
{
    DefaultTableModel model;
    Calendar cal = new GregorianCalendar();
    String[] columns = { "Di", "Lu", "Ma", "Me", "Je", "Ve", "Sa" };;
    JLabel label;

    public CalendarPanel()
    {
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 45, 200, 45, 0 };
        gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0,
                Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
        setLayout(gridBagLayout);

        JButton backButton = new JButton("<-");
        backButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cal.add(Calendar.MONTH, -1);
                model.getDataVector().removeAllElements();
                model.fireTableDataChanged();
                updateMonth();
            }
        });

        GridBagConstraints gbc_backButton = new GridBagConstraints();
        gbc_backButton.fill = GridBagConstraints.BOTH;
        gbc_backButton.insets = new Insets(0, 0, 5, 5);
        gbc_backButton.gridx = 0;
        gbc_backButton.gridy = 0;
        this.add(backButton, gbc_backButton);

        label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 1;
        gbc_label.gridy = 0;
        this.add(label, gbc_label);

        JButton nextButton = new JButton("->");
        nextButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cal.add(Calendar.MONTH, +1);
                model.getDataVector().removeAllElements();
                model.fireTableDataChanged();
                updateMonth();
            }
        });

        GridBagConstraints gbc_nextButton = new GridBagConstraints();
        gbc_nextButton.anchor = GridBagConstraints.WEST;
        gbc_nextButton.insets = new Insets(0, 0, 5, 0);
        gbc_nextButton.fill = GridBagConstraints.VERTICAL;
        gbc_nextButton.gridx = 2;
        gbc_nextButton.gridy = 0;
        this.add(nextButton, gbc_nextButton);

        model = new DefaultTableModel(null, columns)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                // all cells false
                return false;
            }
        };
        JTable table = new JTable(model);
        JScrollPane datePane = new JScrollPane(table);
        datePane.setPreferredSize(table.getPreferredSize());
        GridBagConstraints gbc_datePane = new GridBagConstraints();
        gbc_datePane.gridwidth = 3;
        gbc_datePane.insets = new Insets(0, 0, 0, 0);
        gbc_datePane.fill = GridBagConstraints.BOTH;
        gbc_datePane.gridx = 0;
        gbc_datePane.gridy = 1;
        this.add(datePane, gbc_datePane);

        this.updateMonth();
    }

    void updateMonth()
    {
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.setMinimalDaysInFirstWeek(1);
        cal.setFirstDayOfWeek(1);

        String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG,
                Locale.FRANCE);
        int year = cal.get(Calendar.YEAR);
        label.setText(month + " " + year);

        int startDay = cal.get(Calendar.DAY_OF_WEEK);

        int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
        System.out.println(weeks);
        
        model.setRowCount(0);
        model.setRowCount(weeks);
        
        int i = startDay - 1;
        for (int day = 1; day <= numberOfDays; day++)
        {
            model.setValueAt(day, i / 7, i % 7);
            i = i + 1;
        }
    }
}

