package com.itii.planning.gui;
import java.util.Calendar;
import org.jdatepicker.JDatePicker;
//import org.jdatepicker.JDatePickerImpl;
import org.jdatepicker.UtilDateModel;


public class CalendarPanel extends Object
{
    private static JDatePicker calendar;
    
 // Accessory calendar
    public static JDatePicker getCalendar()
    {
    if (calendar == null)
    {
    UtilDateModel model = new UtilDateModel();
    Calendar cal = Calendar.getInstance();
    model.setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_WEEK));
    calendar = new JDatePicker(model,"dd-MM-yy");
    
    }
    return calendar;
    }
}  