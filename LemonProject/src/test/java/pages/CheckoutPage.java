package pages;

import java.util.NoSuchElementException;

public class CheckoutPage extends BasePage{

    private String nameField =                 "//*[@id='app']/div/div[2]/section[1]/div[3]/div[1]/form/div[1]/input";
    private String emailField =                "//*[@id='app']/div/div[2]/section[1]/div[3]/div[1]/form/div[2]/input";
    private String socialSecurityNumberField = "//*[@id='app']/div/div[2]/section[1]/div[3]/div[1]/form/div[3]/input";
    private String phoneNumberField =          "//*[@id='app']/div/div[2]/section[1]/div[3]/div[1]/form/div[4]/input";
    private String payNowButton =              "//*[@id='app']/div/div[2]/section[1]/div[3]/div[2]/div[7]/div/button";
    private String termsAndConditionsCheck =   "//*[@id='app']/div/div[2]/section[1]/div[3]/div[2]/div[5]/div/label/div"; 
    private String totalPriceText =            "//strong[contains(text(),'$')]";

   
    public CheckoutPage() {
        super(driver);
    }

    //NOTE: I decided not to reuse the same method for each entry, since there could be some particularity or validation to be applied.
    
    public void clickPayNowButton(){
        enabledPayNowButtonAndClick(payNowButton);
    }

    public void clickTermsAndConditions(){
        clickElement(termsAndConditionsCheck);
    }

    public float getTotalPrice(){
        float totalPrice;

        totalPrice  = stringToFloat(textForElement(totalPriceText));

       return totalPrice;
    }
    
    public void enterName(String text) throws InterruptedException{
        try{
        write(nameField, text);
        }catch(NoSuchElementException e){
            System.out.println("The web element search field couldn't be found.");
            e.printStackTrace();
        }
    }

    public void enterEmail(String text) throws InterruptedException{
        try{
        write(emailField, text);
        }catch(NoSuchElementException e){
            System.out.println("The web element search field couldn't be found.");
            e.printStackTrace();
        }
    }

    public void enterSocialSecurityNumber(String text) throws InterruptedException{
        try{
        write(socialSecurityNumberField, text);
        }catch(NoSuchElementException e){
            System.out.println("The web element search field couldn't be found.");
            e.printStackTrace();
        }
    }

    public void enterPhoneNumber(String text) throws InterruptedException{
        try{
        write(phoneNumberField, text);
        }catch(NoSuchElementException e){
            System.out.println("The web element search field couldn't be found.");
            e.printStackTrace();
        }
    }
    



}
