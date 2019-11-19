# Java-Web-Dev
This is a basic test web application test. 


Your assignment will be to creates a java web application that will keep track of a user’s navigation history during a session using his web browser. Each time the user clicks a link to navigate to another page, the navigation history will be updated in the session object for the web application.
• Create the necessary java classes and pages that will encapsulate all necessary data about what the user will be clicking on the web application.
• The session history page will store up to only maximum of 10 session then rotate if it reach the maximum.
• Session history will be set to 5 minutes timeout.
◦ Whenthesessionhistorytimeoutthesessionhistorylistsectionwillreset.
• You will be updating the session in a separate history page that will include the print-out the navigation history of other pages.
• The history list page will be embedded in the homepage page to avoid repeating common code.


In the solution I have left out design related details such models, mappers, data access objects e.t.c since there is no db related component in the test.
I bassically have one view and three controllers. The appication is deployed with Tomcat 9.x


