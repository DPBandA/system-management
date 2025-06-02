/*
Business Entity Library (BEL) - A foundational library for JSF web applications 
Copyright (C) 2024  D P Bennett & Associates Limited

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

Email: info@dpbennett.com.jm
 */
package jm.com.dpbennett.sm.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.faces.model.SelectItem;

/**
 *
 * @author Desmond Bennett <info@dpbennett.com.jm at http//dpbennett.com.jm>
 */
public class DateUtils {

    public static ArrayList getJobDateSearchFields() {
        ArrayList dateSearchFields = new ArrayList();

        dateSearchFields.add(new SelectItem("dateAndTimeEntered", "Date entered"));
        dateSearchFields.add(new SelectItem("dateSubmitted", "Date submitted"));
        dateSearchFields.add(new SelectItem("expectedDateOfCompletion", "Exp'ted date of completion"));
        dateSearchFields.add(new SelectItem("dateCostingApproved", "Date costing approved"));
        dateSearchFields.add(new SelectItem("dateCostingInvoiced", "Date job invoiced"));
        dateSearchFields.add(new SelectItem("dateOfCompletion", "Date completed"));
        dateSearchFields.add(new SelectItem("dateSamplesCollected", "Date sample(s) collected"));
        dateSearchFields.add(new SelectItem("dateDocumentCollected", "Date document(s) collected"));

        return dateSearchFields;
    }

    public static ArrayList getProformaDateSearchFields() {
        ArrayList dateSearchFields = new ArrayList();

        dateSearchFields.add(new SelectItem("dateAndTimeEntered", "Date entered"));
        dateSearchFields.add(new SelectItem("dateCostingApproved", "Date costing approved"));
        dateSearchFields.add(new SelectItem("dateOfCompletion", "Date completed"));

        return dateSearchFields;
    }

    public static ArrayList getDateSearchFields(String category) {
        ArrayList dateSearchFields = new ArrayList();

        switch (category) {
            case "Job":
                return getJobDateSearchFields();
            case "Legal":
                dateSearchFields.add(new SelectItem("dateReceived", "Date received"));
                dateSearchFields.add(new SelectItem("dateOfCompletion", "Date delivered"));
                dateSearchFields.add(new SelectItem("expectedDateOfCompletion", "Agreed delivery date"));
                break;
            case "All":
                return getJobDateSearchFields();
            default:
                return getJobDateSearchFields();
        }

        return dateSearchFields;
    }

    public static String formatDateAndTime(Date date) {
        String dateAndTime;
        Calendar c = Calendar.getInstance();
        String year;
        String month;
        String day;
        String hour;
        String min;
        String sec;

        c.setTime(date);

        // Year
        year = "" + c.get(Calendar.YEAR);
        // Month        
        int month_int = c.get(Calendar.MONTH) + 1;
        if (month_int < 10) {
            month = "0" + month_int;
        } else {
            month = "" + month_int;
        }
        // Day
        int day_int = c.get(Calendar.DAY_OF_MONTH);
        if (day_int < 10) {
            day = "0" + day_int;
        } else {
            day = "" + day_int;
        }
        // Hour
        int hour_int = c.get(Calendar.HOUR_OF_DAY);
        if (hour_int < 10) {
            hour = "0" + hour_int;
        } else {
            hour = "" + hour_int;
        }
        // Min
        int min_int = c.get(Calendar.MINUTE);
        if (min_int < 10) {
            min = "0" + min_int;
        } else {
            min = "" + min_int;
        }
        // Sec
        int sec_int = c.get(Calendar.SECOND);
        if (sec_int < 10) {
            sec = "0" + sec_int;
        } else {
            sec = "" + sec_int;
        }

        dateAndTime = year + "-" + month + "-" + day + " "
                + hour + ":" + min + ":" + sec;

        return dateAndTime;
    }

    public static String formatDate(Date date) {
        DateFormat dateFormatter = new SimpleDateFormat("MMM dd, yyyy");

        return dateFormatter.format(date);

    }
}
