package Common

import geb.spock.GebReportingSpec

@Retry
class BaseSpec extends GebReportingSpec {

    def setupTest() {
    }

    def final setup() {
        browser.go(baseUrl)
        setupTest()
    }

    def cleanupTest() {
        driver.close()
    }

    def final cleanup() {
        cleanupTest()
        // make this == null if you want to close the browser after each test without setting a sys prop
        if (System.properties['cacheBrowser'] != null) {
            //driver.quit()
            Iterator<String> iterator = driver.getWindowHandles().iterator();
            while (iterator.hasNext()) {
                driver.switchTo().window(iterator.next());
                browser.close()
            }

        }
        driver.quit()
    }
}