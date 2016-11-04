package Common

import geb.Page


    class BasePage extends Page {

        static content= {
            navBar { module NavBarModule }

        }


        protected void switchToMainWindow() {
            Iterator<String> iterator = driver.getWindowHandles().iterator();
            driver.switchTo().window(iterator.next());
        }


        protected void switchToPopupWindow() {
            Iterator<String> iterator = driver.getWindowHandles().iterator();
            iterator.next();
            driver.switchTo().window(iterator.next());
        }

    }
