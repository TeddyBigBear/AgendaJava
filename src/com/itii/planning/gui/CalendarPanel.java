package com.itii.planning.gui;
import java.util.Calendar;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


public class CalendarPanel extends Object
{
    private JDatePicker calendar;
    
 // Accessory calendar
    public JDatePicker getCalendar()
    {
    if (calendar == null)
    {
    UtilDateModel model = new UtilDateModel();
    Calendar cal = Calendar.getInstance();
    model.setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_WEEK));
    calendar = new JDatePicker(model,"dd-mm-yy");

    }
    return calendar;
    }
}  