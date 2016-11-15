package Specs

import Common.BaseSpec
import Common.SQLController
import PageObjects.ExampleHomePage
import PageObjects.HelloWorldPage
import spock.lang.Issue
import spock.lang.Narrative
import spock.lang.Shared
import spock.lang.Unroll

@Narrative("Spec for walking thru the Hello World Example")
class HelloWorldSpec extends BaseSpec {


    @Shared
    sql = new SQLController()


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


    @Unroll ("Testing #firstName and #lastName")
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
        where: "Piping our data from a data table"
        firstName   | lastName
        "Firsty"    |  "McLastName"
        "Peter"     |  "Griffin"
        "Lois"      |  "Griffin"
        "Glen"      |  "Quagmire"
        "Bonnie"    |  "Swanson"
        "Cleveland" | "Brown"
    }

    @Unroll ("Testing #firstName and #lastName")
    @Issue("Hello World Example, but with spock data tables via data pipe")
    def HelloWorldExamplePageDataTableWithPipedDate() {
        when: "At the home page, click hello world link"
            at ExampleHomePage
            clickHelloWorldLink()
        then: "Verify at the Hello World Page"
            assert at(HelloWorldPage)
        when:"Enter names in first and last name field"
            setNameTextBoxValues(firstName, lastName)
        then:"Assert it takes"
            assert getLiveExampleResultText() == "Hello, "+firstName+" "+lastName+"!"
        where: "Piping our data from a database"
            [firstName, lastName] <<  sql.runQueryReturnData("select first_name, last_name from actor limit 5")
    }




}