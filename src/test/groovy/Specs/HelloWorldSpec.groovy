package Specs

import Common.BaseSpec
import PageObjects.ExampleHomePage
import PageObjects.HelloWorldPage
import spock.lang.Issue
import spock.lang.Narrative

@Narrative("Spec for walking thru the Hello World Example")
class HelloWorldSpec extends BaseSpec {



    def setupTest() {
        to ExampleHomePage
    }

    @Issue("Hello World Example")
    def HelloWorldExamplePageLoads() {
        when: "At the home page, click hello world link"
            at ExampleHomePage
            clickHelloWorldLink()
        then: "Verify at the Hello World Page"
            assert at(HelloWorldPage)
    /*    when:"Enter a value in the first name field"
            enterFirstNameText("yo dawg")
        then:"Assert it takes"
            assert getFirstNameTextValue() == "yo dawg"     */
    }
}