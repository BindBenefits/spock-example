package Specs

import Common.BaseSpec
import Data.UserData
import spock.lang.Issue
import spock.lang.Narrative

@Narrative("Spec for checking login functionality")
class LoginSpec extends BaseSpec {

    def userName = UserData.admin.userName
    def userPw = UserData.admin.userPw

    def setupTest() {
        to homePage
    }

    @Issue("Login Regression")
    def LoginWithValidUser() {
        when: "At the home page"
        at homePage
        then: "Verify account link isn't present"
        assert isMyAccountLinkPresent() == false
        when: "Click sign in, enter a valid user"
        clickSignInLink()
        at signInModalPage
        loginAsUser(userName, userPw)
        then: "Verify successful login"
        assert at(homePage)
        assert isMyAccountLinkPresent() == true

    }
}