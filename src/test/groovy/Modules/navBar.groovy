package Modules

import geb.Module

    class navBar extends Module {
        static content ={
            imgLogo                         {find("img.site-logo__img")}
            myAccountLink(required:false)   {find("div#signin-wrapper.user-container").children("a", text:"Your Account")}

        }
}
