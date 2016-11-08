package PageObjects

import Common.BasePage
import Modules.MainMenuBar

class ExampleHomePage extends BasePage{

    static  at = {knockoutHeader.isDisplayed()}
    static content ={
        menuBar                            {module MainMenuBar}
        knockoutHeader(wait:true)          {find("h1", text:"Live examples")}
        helloWorldLink                     {find("a", href:"http://knockoutjs.com/examples/helloWorld.html")}
     }



    def clickHelloWorldLink(){
        helloWorldLink.click()
    }


}
