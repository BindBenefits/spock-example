package Modules

import geb.Module

    class MainMenuBar extends Module {
        static content ={
            homeLink                {find("a", text:"Home")}
            downloadInstallLink     {find("a", text:"Download / Install")}
            tutorialsLink           {find("a", text:"Tutorials")}
            liveExamplesLink        {find("a", text:"Live examples")}
            documentationLink       {find("a", text:"Documentation")}
            forumLink               {find("a", text:"Forum")}
            sourceLink              {find("a", text:"Source")}
        }
}
