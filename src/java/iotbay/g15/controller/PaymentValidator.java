package iotbay.g15.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Isha Yokhanna
 */


public class PaymentValidator {
    // Validates street number
    public String validateStreetNo(String streetNo){
        // Street number regex pattern
        String pattern = "^\\d{1,4}$";
        
        // Removing whitespaces
        streetNo = streetNo.replaceAll(" ", "");
        
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(streetNo);
        
        if(match.matches())
            return null;
        
        return "Please enter a valid street number";
    }
    
    // Validates street name
    public String validateStreetName(String streetName){
        // Street name regex pattern
        String pattern = "^\\d+(\\.\\d+)?";
        
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(streetName);
        
        if(!match.matches())
            return null;
        
        return "Please enter a valid street name: e.g. Sussex";
    }
    
    // Validates street type
    public String validateStreetType(String streetType){
        // Street type regex pattern
        String pattern = "^\\d+(\\.\\d+)?";
        
        // Removing whitespaces
        streetType = streetType.replaceAll(" ", "");
        
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(streetType);
        
        if(!match.matches())
            return null;
        
        return "Please enter a valid street type: e.g. St or Street";
    }
    
    // Validates suburb name
    public String validateSuburb(String suburb){
        // Suburb reegex pattern
        String pattern = "^\\d+(\\.\\d+)?";
        
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(suburb);
        
        if(!match.matches())
            return null;
        
        return "Please enter a valid suburb name: e.g. CBD or Central business district";
    }
    
    // Validates state input
    public String validateState(String state){
        // State regex pattern
        String pattern = "^\\d+(\\.\\d+)?";
        
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(state);
        
        if(!match.matches())
            return null;
        
        return "Please enter a valid state name: e.g. NSW or New South Wales";
    }
    
    // Validates postcode
    public String validatePostcode(String postcode){
        // postcode regex pattern
        String pattern = "^\\d{4}$";
        
        // Removing white spaces
        postcode = postcode.replaceAll(" ", "");
        
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(postcode);
        
        if(match.matches())
            return null;
        
        return "Please enter a valid postcode: e.g. 2000";
    }
    
    // Validates country name
    public String validateCountry(String country){
        // Country regex pattern
        String pattern = "^\\d+(\\.\\d+)?";
        
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(country);
        
        if(!match.matches())
            return null;
        
        return "Please enter a valid country name: e.g. Au or Australia";
    }
    
    
    // Validates if full name is valid
    public String validateCardHolderName(String cardHolderName){
        // Full name regex pattern
        String pattern = "^[a-zA-Z\\s]+";
        
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(cardHolderName);
        
        if(match.matches())
            return null;
        
        return "Please enter a valid name: e.g. John Smith";
    }
    
    // Validates if card number meets Mastercard standards
    public String validateCardNumber(String cardNumber){
        // Mastercard regex pattern
        String pattern = "^5[1-5][0-9]{14}|^(222[1-9]|22[3-9]\\\\d|2[3-6]\\\\d{2}|27[0-1]\\\\d|2720)[0-9]{12}$";
        
        // Removing white spaces
        cardNumber = cardNumber.replaceAll(" ", "");
        
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(cardNumber);
        
        if(match.matches())
            return null;
        
        return "Please enter a valid mastercard number (Tak a lok at the Anatomy of a Master Cards): e.g. xxxx xxxx xxxx xxxx";
    }
    
    // Validates if the card expiry date input matches the format MM/YYYY
    public String validateCardExpiryDate(String cardExpiryDate){
        // Card expiry date regex pattern
        String pattern = "^(0[1-9]|1[0-2])\\/?([0-9]{4})$";
        
        // Removing white spaces
        cardExpiryDate = cardExpiryDate.replaceAll(" ", "");
        
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(cardExpiryDate);
        
        if(match.matches())
            return null;
        
        return "Your card expiry date is invalid, the format must be MM/YYYY";
    }
    
    // Validates if card security code meets standard format
    public String validateCardCVC(String cardCVC){
        // Card security code regex pattern
        String pattern = "^[0-9]{3,4}$";
        
        // Removing white space from string
        cardCVC = cardCVC.replaceAll(" ", "");
        
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(cardCVC);       

        if(match.matches())
            return null;
        
        return "Your card CVC must be a valid 3-digit number: e.g. 000";
    }
    
    //  Validates if payment id that's in the search input is only a number
    public String validatePaymentIDSearchInput(String paymentID){
        // Removing white spaces if any before converting to int
        paymentID = paymentID.replaceAll(" ", "");
        
        try{
            int pID = Integer.parseInt(paymentID);
        }catch(NumberFormatException ex){
            return "Please enter a valid payment ID";
        }
        
        return null;
    }
    
}
