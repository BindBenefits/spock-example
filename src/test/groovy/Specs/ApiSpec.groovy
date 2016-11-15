package Specs


import Common.APIHelper

import geb.spock.GebSpec
import groovy.json.JsonSlurper
import spock.lang.Issue
import spock.lang.Narrative

@Narrative("Spec for demo'ing API")
class ApiSpec extends GebSpec {


    @Issue("Example of an API call")
    def testingAGet() {
        when: "Test a GET call to jsonplaceholder"
            def returnStatus = APIHelper.getAPIResponse("/posts/1")
        then: "Assert return status 200"
            returnStatus ==  200
    }



}