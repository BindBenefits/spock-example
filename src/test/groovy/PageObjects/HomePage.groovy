package PageObjects

import Common.BasePage

class homePage extends BasePage{

    static  at = {signInLink.isDisplayed()}
    static content ={
        navBarMod                               {module navBar}
        signInLink(wait:true)            {find("#yo")}
     }




    def clickSignInLink(){
        waitFor{
            signInLink.isDisplayed()
        }
        signInLink.click()
    }



}