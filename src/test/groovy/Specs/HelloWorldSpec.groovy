package Specs

import Common.BaseSpec
import PageObjects.ExampleHomePage
import PageObjects.HelloWorldPage
import spock.lang.Issue
import spock.lang.Narrative
import spock.lang.Unroll

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
        when:"Enter names in first and last name field"
            setNameTextBoxValues("Firsty", "McLastName")
        then:"Assert it takes"
            assert getLiveExampleResultText() == "Hello, Firsty McLastName!"
    }


    @Unroll
    @Issue("Hello World Example, but with spock data tables")
    def HelloWorldExamplePageDataTable() {
        when: "At the home page, click hello world link"
            at ExampleHomePage
            clickHelloWorldLink()
        then: "Verify at the Hello World Page"
            assert at(HelloWorldPage)
        when:"Enter names in first and last name field"
            setNameTextBoxValues(firstName, lastName)
        then:"Assert it takes"
            assert getLiveExampleResultText() == "Hello, "+firstName+" "+lastName+"!"
        where:
        firstName   | lastName
        "Firsty"    |  "McLastName"
        "Peter"     |  "Griffin"
        "Lois"      |  "Griffin"
        "Glen"      |  "Quagmire"
        "Bonnie"    |  "Swanson"
        "Cleveland" | "Brown"

    }



}