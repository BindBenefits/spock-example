package PageObjects

import Common.BasePage
import Modules.MainMenuBar

class HelloWorldPage extends BasePage{

    static  at = {helloWorldHeader.isDisplayed()}
    static content ={
        menuBar                            {module MainMenuBar}
        helloWorldHeader(wait:true)          {$("h1", text:"Hello World example")}
        firstNameTextBox                     {$("input").@attribute("data-bind").value()=="value: firstName"}
     }

    def enterFirstNameText(ourVal){
        waitFor{
            firstNameTextBox
        }
        firstNameTextBox << ourVal
    }


    def getFirstNameTextValue(){
        return firstNameTextBox.value()
    }



}
