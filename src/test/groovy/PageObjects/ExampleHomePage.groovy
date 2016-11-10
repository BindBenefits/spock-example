package PageObjects

import Common.BasePage
import Modules.MainMenuBar

class ExampleHomePage extends BasePage{

    static  at = {knockoutHeader.isDisplayed()}

    static content = {
        menuBar                            {module MainMenuBar}
        knockoutHeader(wait:true)          {$("h1", text:"Live examples")}
        helloWorldLink                     {$("a", text:"the ‘Hello World’ example")}
     }



    def clickHelloWorldLink(){
        helloWorldLink.click()
    }


}
