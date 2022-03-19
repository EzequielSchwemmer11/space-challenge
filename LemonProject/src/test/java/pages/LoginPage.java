package pages;

import java.util.NoSuchElementException;

public class LoginPage extends BasePage {

    private String emailTextField =     "//*[@id='login']/div[1]/input";
    private String passwordTextField =  "//*[@id='login']/div[2]/input"; 
    private String submitButton =       "//*[@id='app']/div/section[3]/div/div[2]/div/nav/button[2]";

    public LoginPage() {
        super(driver);
    }
 
     public void clickSubmitButton(){
         clickElement(submitButton);
     }

    public void enterEmail(String text) throws InterruptedException{
        try{
        write(emailTextField, text);
        }catch(NoSuchElementException e){
            System.out.println("The web element search field couldn't be found.");
            e.printStackTrace();
        }
    }

    public void enterPassword(String text) throws InterruptedException{
        try{
        write(passwordTextField, text);
        }catch(NoSuchElementException e){
            System.out.println("The web element search field couldn't be found.");
            e.printStackTrace();
        }
    }

    
}
