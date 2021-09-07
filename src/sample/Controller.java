package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utility.Utilities;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    TextField inpDD, inpMM, inpYY;

    @FXML
    Label lblNextDate1, lblNextDate2, lblPrevDate1, lblPrevDate2,
            lblPrevMM1, lblPrevMM2, lblNextMM1, lblNextMM2, lblPrevYear1, lblPrevYear2, lblNextYear1, lblNextYear2;

    @FXML
    Button btnDone;

    ArrayList<String> months;
    ArrayList<Integer> years;
    ArrayList<Integer> dates;

    Date date;

    int intSelDate, intSelMonth, intSelYear;
    int next1, next2, prev1, prev2;

    int nextMM1, nextMM2, prevMM1, prevMM2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        intSelDate = Calendar.getInstance().get(Calendar.DATE);
        intSelMonth = Calendar.getInstance().get(Calendar.MONTH);


        months = new ArrayList<>();
        dates = new ArrayList<>();
        years = new ArrayList<>();

        months.addAll(Utilities.getMonthsByName());
        dates.addAll(Utilities.getAllDates(intSelMonth, intSelYear));
        years.addAll(Utilities.getAllYears());
        intSelYear = years.indexOf(Calendar.getInstance().get(Calendar.YEAR));

        System.out.println("Select Year Index->" + intSelYear + " Total Size->" + years.size());

        inpMM.setText(months.get(Integer.parseInt(Utilities.getCurrentMonth()) - 1));
        inpDD.setText(String.valueOf(Calendar.getInstance().get(Calendar.DATE)));
        inpYY.setText(String.valueOf(years.get(intSelYear)));

        next1 = intSelDate - 1;
        next2 = intSelDate - 2;
        lblNextDate1.setText("" + next1);
        lblNextDate2.setText("" + next2);

        prev1 = intSelDate + 1;
        prev2 = intSelDate + 2;
        lblPrevDate1.setText("" + prev1);
        lblPrevDate2.setText("" + prev2);

        nextMM1 = intSelMonth - 1;
        nextMM2 = intSelMonth - 2;
        lblNextMM1.setText(months.get(nextMM1));
        lblNextMM2.setText(months.get(nextMM2));

        prevMM1 = intSelMonth + 1;
        prevMM2 = intSelMonth + 2;
        lblPrevMM1.setText(months.get(prevMM1));
        lblPrevMM2.setText(months.get(prevMM2));

        lblNextYear1.setText("");
        lblNextYear2.setText("");

        lblPrevYear1.setText("" + years.get(intSelYear - 1));
        lblPrevYear2.setText("" + years.get(intSelYear - 2));


        dates.clear();
        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
        intSelDate = dates.get(dates.size() - 1);
        inpDD.setText("" + intSelDate);

        lblPrevDate1.setText("");
        lblPrevDate2.setText("");
        lblNextDate1.setText("" + (intSelDate - 1));
        lblNextDate2.setText("" + (intSelDate - 2));


        inpDD.setOnScroll(mouseEvent -> {
            if (mouseEvent.getDeltaY() < 0) {
                switch (intSelMonth + 1) {
                    default:
                        if (intSelDate > 1) {
                            intSelDate = intSelDate - 1;
                        }
                        switch (intSelDate) {
                            case 1:
                                inpDD.setText("" + intSelDate);
                                lblPrevDate1.setText("" + (intSelDate + 1));
                                lblPrevDate2.setText("" + (intSelDate + 2));

                                lblNextDate1.setText("");
                                lblNextDate2.setText("");
                                break;
                            case 2:
                                inpDD.setText("" + intSelDate);
                                lblPrevDate1.setText("" + (intSelDate + 1));
                                lblPrevDate2.setText("" + (intSelDate + 1));

                                lblNextDate1.setText("" + (intSelDate - 1));
                                lblNextDate2.setText("");
                                break;
                            default:
                                if (intSelDate == dates.get(dates.size() - 1)) {
                                    inpDD.setText("" + intSelDate);
                                    lblPrevDate1.setText("");
                                    lblPrevDate2.setText("");

                                    lblNextDate1.setText("" + (intSelDate - 1));
                                    lblNextDate2.setText("" + (intSelDate - 2));
                                } else if (intSelDate == dates.get(dates.size() - 2)) {
                                    inpDD.setText("" + intSelDate);
                                    lblPrevDate1.setText("" + (intSelDate + 1));
                                    lblPrevDate2.setText("");

                                    lblNextDate1.setText("" + (intSelDate - 1));
                                    lblNextDate2.setText("" + (intSelDate - 2));
                                } else {
                                    inpDD.setText("" + intSelDate);
                                    lblPrevDate1.setText("" + (intSelDate + 1));
                                    lblPrevDate2.setText("" + (intSelDate + 2));

                                    lblNextDate1.setText("" + (intSelDate - 1));
                                    lblNextDate2.setText("" + (intSelDate - 2));
                                }
                                break;

                        }
                        break;
                }
                System.out.println("Delta Down" + mouseEvent.getDeltaY());
                System.out.println("Down");
            } else {

                switch (intSelMonth + 1) {
                    default:
                        if (intSelDate < dates.get(dates.size() - 1)) {
                            intSelDate = intSelDate + 1;
                        }
                        switch (intSelDate) {
                            case 1:
                                inpDD.setText("" + intSelDate);
                                lblPrevDate1.setText("" + (intSelDate + 1));
                                lblPrevDate2.setText("" + (intSelDate + 2));

                                lblNextDate1.setText("");
                                lblNextDate2.setText("");
                                break;
                            case 2:
                                inpDD.setText("" + intSelDate);
                                lblPrevDate1.setText("" + (intSelDate + 1));
                                lblPrevDate2.setText("" + (intSelDate + 1));

                                lblNextDate1.setText("" + (intSelDate - 1));
                                lblNextDate2.setText("");
                                break;
                            default:
                                if (intSelDate == dates.get(dates.size() - 1)) {
                                    inpDD.setText("" + intSelDate);
                                    lblPrevDate1.setText("");
                                    lblPrevDate2.setText("");

                                    lblNextDate1.setText("" + (intSelDate - 1));
                                    lblNextDate2.setText("" + (intSelDate - 2));
                                } else if (intSelDate == dates.get(dates.size() - 2)) {
                                    inpDD.setText("" + intSelDate);
                                    lblPrevDate1.setText("" + (intSelDate + 1));
                                    lblPrevDate2.setText("");

                                    lblNextDate1.setText("" + (intSelDate - 1));
                                    lblNextDate2.setText("" + (intSelDate - 2));
                                } else {
                                    inpDD.setText("" + intSelDate);
                                    lblPrevDate1.setText("" + (intSelDate + 1));
                                    lblPrevDate2.setText("" + (intSelDate + 2));

                                    lblNextDate1.setText("" + (intSelDate - 1));
                                    lblNextDate2.setText("" + (intSelDate - 2));
                                }
                                break;
                        }
                        break;
                }
                System.out.println("Delta Up" + mouseEvent.getDeltaY());
                System.out.println("Up");
            }
        });

        inpMM.setOnScroll(scrollEvent -> {
            if (scrollEvent.getDeltaY() < 0) {
                if (intSelMonth > 0) {
                    intSelMonth = intSelMonth - 1;
                }
                System.out.println("DOWN Month->" + intSelMonth);
                switch (intSelMonth) {
                    case 0:
                        intSelMonth = 0;
                        inpMM.setText(months.get(intSelMonth));
                        lblNextMM1.setText("");
                        lblNextMM2.setText("");

                        lblPrevMM1.setText(months.get(intSelMonth + 1));
                        lblPrevMM2.setText(months.get(intSelMonth + 2));
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        break;
                    case 1:
                        inpMM.setText(months.get(intSelMonth));
                        lblNextMM1.setText(months.get(intSelMonth - 1));
                        lblNextMM2.setText("");

                        lblPrevMM1.setText(months.get(intSelMonth + 1));
                        lblPrevMM2.setText(months.get(intSelMonth + 2));
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        System.out.println("This is Feb");
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        inpMM.setText(months.get(intSelMonth));
                        lblNextMM1.setText(months.get(intSelMonth - 1));
                        lblNextMM2.setText(months.get(intSelMonth - 2));

                        lblPrevMM1.setText(months.get(intSelMonth + 1));
                        lblPrevMM2.setText(months.get(intSelMonth + 2));
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        break;
                    case 10:
                        inpMM.setText(months.get(intSelMonth));
                        lblNextMM1.setText(months.get(intSelMonth - 1));
                        lblNextMM2.setText(months.get(intSelMonth - 2));

                        lblPrevMM1.setText(months.get(intSelMonth + 1));
                        lblPrevMM2.setText("");
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        break;
                    case 11:
                        inpMM.setText(months.get(intSelMonth));
                        lblNextMM1.setText(months.get(intSelMonth - 1));
                        lblNextMM2.setText(months.get(intSelMonth - 2));

                        lblPrevMM1.setText("");
                        lblPrevMM2.setText("");
                        intSelMonth = 11;
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        break;
                }
            } else {
                if (intSelMonth < 11) {
                    intSelMonth = intSelMonth + 1;
                }
                System.out.println("UP Month->" + intSelMonth);
                switch (intSelMonth) {
                    case 0:
                        intSelMonth = 0;
                        inpMM.setText(months.get(intSelMonth));
                        lblNextMM1.setText("");
                        lblNextMM2.setText("");

                        lblPrevMM1.setText(months.get(intSelMonth + 1));
                        lblPrevMM2.setText(months.get(intSelMonth + 2));
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        break;
                    case 1:
                        inpMM.setText(months.get(intSelMonth));
                        lblNextMM1.setText(months.get(intSelMonth - 1));
                        lblNextMM2.setText("");

                        lblPrevMM1.setText(months.get(intSelMonth + 1));
                        lblPrevMM2.setText(months.get(intSelMonth + 2));

                        System.out.println("This is Feb");
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        inpMM.setText(months.get(intSelMonth));
                        lblNextMM1.setText(months.get(intSelMonth - 1));
                        lblNextMM2.setText(months.get(intSelMonth - 2));

                        lblPrevMM1.setText(months.get(intSelMonth + 1));
                        lblPrevMM2.setText(months.get(intSelMonth + 2));
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        break;
                    case 10:
                        inpMM.setText(months.get(intSelMonth));
                        lblNextMM1.setText(months.get(intSelMonth - 1));
                        lblNextMM2.setText(months.get(intSelMonth - 2));

                        lblPrevMM1.setText(months.get(intSelMonth + 1));
                        lblPrevMM2.setText("");
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        break;
                    case 11:
                        inpMM.setText(months.get(intSelMonth));
                        lblNextMM1.setText(months.get(intSelMonth - 1));
                        lblNextMM2.setText(months.get(intSelMonth - 2));

                        lblPrevMM1.setText("");
                        lblPrevMM2.setText("");
                        intSelMonth = 11;
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        break;
                }
            }
        });

        inpYY.setOnScroll(scrollEvent -> {
            if (scrollEvent.getDeltaY() < 0) {
                if (intSelYear < years.size() - 1) {
                    intSelYear += 1;
                    if (intSelYear <= 119) {
                        inpYY.setText("" + years.get(intSelYear));
                        lblNextYear1.setText("" + years.get(intSelYear + 1));
                        lblNextYear2.setText("" + years.get(intSelYear + 2));
                    }

                    if (intSelYear >= 2) {
                        inpYY.setText("" + years.get(intSelYear));
                        lblPrevYear1.setText("" + years.get(intSelYear - 1));
                        lblPrevYear2.setText("" + years.get(intSelYear - 2));
                    }
                    System.out.println("Down Year->" + intSelYear);
                    dates.clear();
                    System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                    dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                    intSelDate = dates.get(dates.size() - 1);
                    inpDD.setText("" + intSelDate);
                    lblPrevDate1.setText("");
                    lblPrevDate2.setText("");
                    lblNextDate1.setText("" + (intSelDate - 1));
                    lblNextDate2.setText("" + (intSelDate - 2));
                }
                switch (intSelYear) {
                    case 0:
                        intSelYear = 0;
                        inpYY.setText("" + years.get(intSelYear));
                        lblPrevYear1.setText("");
                        lblPrevYear2.setText("");
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        break;
                    case 1:
                        inpYY.setText("" + years.get(intSelYear));
                        lblNextYear1.setText("" + years.get(intSelYear + 1));
                        lblNextYear2.setText("" + years.get(intSelYear + 2));

                        lblPrevYear1.setText("" + years.get(intSelYear - 1));
                        lblPrevYear2.setText("");
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        break;
                    case 2:
                    case 119:
                        lblNextYear1.setText("" + years.get(intSelYear + 1));
                        lblNextYear2.setText("" + years.get(intSelYear + 2));

                        lblPrevYear1.setText("" + years.get(intSelYear - 1));
                        lblPrevYear2.setText("" + years.get(intSelYear - 2));
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        break;
                    case 120:
                        inpYY.setText("" + years.get(intSelYear));
                        lblNextYear1.setText("" + years.get(intSelYear + 1));
                        lblNextYear2.setText("");

                        lblPrevYear1.setText("" + years.get(intSelYear - 1));
                        lblPrevYear2.setText("" + years.get(intSelYear - 2));
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        break;
                    case 121:
                        inpYY.setText("" + years.get(intSelYear));
                        intSelYear = 121;
                        lblNextYear1.setText("");
                        lblNextYear2.setText("");
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        break;
                }


            } else {
                if (intSelYear > 0) {
                    intSelYear -= 1;
                    if (intSelYear <= 119) {
                        inpYY.setText("" + years.get(intSelYear));
                        lblNextYear1.setText("" + years.get(intSelYear + 1));
                        lblNextYear2.setText("" + years.get(intSelYear + 2));
                    }
                    if (intSelYear >= 2) {
                        inpYY.setText("" + years.get(intSelYear));
                        lblPrevYear1.setText("" + years.get(intSelYear - 1));
                        lblPrevYear2.setText("" + years.get(intSelYear - 2));
                    }
                    System.out.println("UP Year->" + intSelYear);
                    dates.clear();
                    System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                    dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                    intSelDate = dates.get(dates.size() - 1);
                    inpDD.setText("" + intSelDate);
                    lblPrevDate1.setText("");
                    lblPrevDate2.setText("");
                    lblNextDate1.setText("" + (intSelDate - 1));
                    lblNextDate2.setText("" + (intSelDate - 2));
                }
                switch (intSelYear) {
                    case 0:
                        intSelYear = 0;
                        inpYY.setText("" + years.get(intSelYear));
                        lblPrevYear1.setText("");
                        lblPrevYear2.setText("");
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        break;
                    case 1:
                        inpYY.setText("" + years.get(intSelYear));
                        lblNextYear1.setText("" + years.get(intSelYear + 1));
                        lblNextYear2.setText("" + years.get(intSelYear + 2));

                        lblPrevYear1.setText("" + years.get(intSelYear - 1));
                        lblPrevYear2.setText("");
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        break;
                    case 2:
                    case 119:
                        lblNextYear1.setText("" + years.get(intSelYear + 1));
                        lblNextYear2.setText("" + years.get(intSelYear + 2));

                        lblPrevYear1.setText("" + years.get(intSelYear - 1));
                        lblPrevYear2.setText("" + years.get(intSelYear - 2));
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        break;
                    case 120:
                        inpYY.setText("" + years.get(intSelYear));
                        lblNextYear1.setText("" + years.get(intSelYear + 1));
                        lblNextYear2.setText("");

                        lblPrevYear1.setText("" + years.get(intSelYear - 1));
                        lblPrevYear2.setText("" + years.get(intSelYear - 2));
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        break;
                    case 121:
                        inpYY.setText("" + years.get(intSelYear));
                        intSelYear = 121;
                        lblNextYear1.setText("");
                        lblNextYear2.setText("");
                        dates.clear();
                        System.out.println("Month->" + intSelMonth + 1 + " Year->" + years.get(intSelYear));
                        dates.addAll(Utilities.getAllDates(intSelMonth + 1, years.get(intSelYear)));
                        intSelDate = dates.get(dates.size() - 1);
                        inpDD.setText("" + intSelDate);
                        lblPrevDate1.setText("");
                        lblPrevDate2.setText("");
                        lblNextDate1.setText("" + (intSelDate - 1));
                        lblNextDate2.setText("" + (intSelDate - 2));
                        break;
                }
            }
        });

        btnDone.setOnAction(actionEvent -> {
            String date = inpYY.getText() + "/" + Utilities.getMonth(inpMM.getText()) + "/" + inpDD.getText();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
            Date finalDate = null;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            try {
                alert.setTitle("Success");
                finalDate = formatter.parse(date);
                alert.setContentText("Selected date is-> " + finalDate);
            } catch (ParseException e) {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setTitle("Failure");
                alert.setContentText("Something went wrong -> " + e.getMessage());
                e.printStackTrace();
            }
            alert.show();
            System.out.println(finalDate);
        });

    }


}
