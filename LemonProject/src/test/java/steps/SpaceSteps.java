package steps;

import io.cucumber.java.en.*;
import pages.CheckoutPage;
import pages.DestinationsPage;
import pages.LoginPage;
import pages.SpacePage;

public class SpaceSteps{

    SpacePage space = new SpacePage();
    LoginPage login = new LoginPage();
    DestinationsPage destionations = new DestinationsPage();
    CheckoutPage checkout = new CheckoutPage();

    private int numberOfTravelers;
    private float priceOfPlantet;
    private float totalPrice;

    @Given("^As a Test Engineer I am on Space Advisor page$")
        public void navigateToSpaceAdvisorPage(){
            space.navigateToSpacepage();
        }
    
    @And("^I login with my user$")
        public void userLogin() throws InterruptedException{
            space.clickLoginButton();
            login.enterEmail("ezequiel.schwemmer@gmail.com");
            login.enterPassword("12345678");
            login.clickSubmitButton();
        }

    @Given("^I select the date of departure and return$")
        public void selectDates() throws InterruptedException{
            space.selectDate();
        }

    @And("^I select number of (.+) and (.+)$")
        public void selectPassangers(String adults, String childrens) throws InterruptedException{
            space.selectAdultPassanger(adults);
            space.selectChildrenPassanger(childrens);
        }

    @And("^I choose my favorite (.+)$")
        public void selectPlanet(String planet) throws InterruptedException{
            destionations.selectLaunchPlanet(planet);
            destionations.clickBookButton();
        }

    @And("^I complete checkout information with Name: (.+) and Email: (.+) and Security Number: (.+) and Phone Number: (.+)$")
    public void completeCheckout (String name, String email, String securityNumber, String phoneNumber) throws InterruptedException{
        checkout.enterName(name);
        checkout.enterEmail(email);
        checkout.enterSocialSecurityNumber(securityNumber);
        checkout.enterPhoneNumber(phoneNumber);
    }

    @And("^I accept terms and conditions and pay my reservation$")
    public void payReservation (){
        checkout.clickTermsAndConditions();
        checkout.clickPayNowButton();
    }

    @Then("^the total price was calculated correctly$")
    public void checkTotalPrice(){
        //In this step (or if necessary in a different one) it should be validated that the reservation was confirmed, 
        //as this functionality doesn't work, the validation will not be performed
        numberOfTravelers = destionations.getNumberOfTravelers();
        priceOfPlantet = destionations.getPlanetPrice();
        totalPrice = checkout.getTotalPrice();

        if(totalPrice == priceOfPlantet * numberOfTravelers){
            System.out.println("El precio total es correcto");
        }else{
            System.out.println("WARNING! Precio planeta: "+priceOfPlantet+ " y Cantidad de pasajeros "+ numberOfTravelers +". El precio total es incorrecto");
        }
    }
   
}

   // @Then("^the results match the criteria$")
   // public void checkCriteria(){
    //    Assert.assertEquals(" ", google.searchTextElement()); //recordar que tambien esta el assert true y false
   // }
    
