package PageObjects

import Common.BasePage
import Modules.MainMenuBar

class HelloWorldPage extends BasePage{

    static  at = {helloWorldHeader.isDisplayed()}
    static content ={
        menuBar                            {module MainMenuBar}
        helloWorldHeader(wait:true)          {find("h1", text:"Hello World example")}
     }

}
