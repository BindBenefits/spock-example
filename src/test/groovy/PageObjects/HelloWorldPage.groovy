package PageObjects

import Common.BasePage
import Modules.MainMenuBar
import org.openqa.selenium.Keys

class HelloWorldPage extends BasePage{

    static  at = {helloWorldHeader.isDisplayed()}
    static content ={
        menuBar                                 {module MainMenuBar}
        helloWorldHeader(wait:true)             {$("h1", text:"Hello World example")}
        firstNameTextBox                        {$('*[data-bind="value: firstName"]')}
        lastNameTextBox                         {$('*[data-bind="value: lastName"]')}
        liveExampleText                         {$('div.liveExample > h2')}
     }

    def setNameTextBoxValues(ourValFirst, ourValLast){
        waitFor{
            firstNameTextBox
        }
        firstNameTextBox.value(ourValFirst)
        lastNameTextBox.value(ourValLast)
        lastNameTextBox << Keys.TAB
    }


    def getLiveExampleResultText(){
        waitFor {
            liveExampleText
        }
        return liveExampleText.getAttribute('textContent').toString()
    }






}
