package com.example.workshop6;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

public class Validation {

    //did the user input a date in the DatePicker
    public static boolean datePickerHasValue (DatePicker dp) {
        boolean hasDate = false;
        if(dp.getValue() != null) {
            hasDate = true;
        }

        return hasDate;
    }

    //Did the User Input a String where it is required
    public static boolean textFieldisText(TextField tf) {
        boolean hasText = true;
        if(tf.getText().equals(""))
        {
            hasText = false;
        }
        return hasText;
    }
    public static boolean textFieldisInt(TextField tf) {
        boolean isInt = true;
        try {
            Integer.parseInt(tf.getText());
        }
        catch(NumberFormatException e){
            isInt = false;
        }
        return isInt;
    }

    public static boolean textFieldisDouble(TextField tf) {
        boolean isDouble = true;
        try {
            Double.parseDouble(tf.getText());
        }
        catch(NumberFormatException e){
            isDouble = false;
        }
        return isDouble;
    }

    //https://howtodoinjava.com/java/regex/java-regex-validate-email-address/
    public boolean textFieldIsEmail(TextField tf){
        boolean isEmail = true;
        if(!tf.getText().matches("^[A-Za-z0-9+_.-]+@(.+)$"))
        {
            isEmail = false;
        }
        return isEmail;
    }

    public boolean textFieldisPhone(TextField tf){
        boolean isPhone = true;
        if (!tf.getText().matches("\\+\\d{1,3}[-][()\\d\\s-]+"))
        {
            isPhone = false;
        }
        return isPhone;
    }

    public boolean textFieldisPostal(TextField tf){
        boolean isPostal = true;
        if (!tf.getText().matches("^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$"))
        {
            isPostal = false;
        }
        return isPostal;
    }
}
