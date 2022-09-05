Hello All!

This is Project 0, where we built our first Console Line Application that utilizes both SQL databases and a remote Git repository.

For this project, I have created a simple app for users to file/request for a warranty from an outdoor goods brand Arc'teryx. 
They offer a Limited Lifetime warranty on most of their products, however there are guidelines in which they do follow.
Upon running the program, the first part of the App is a brief "Hello" to the user, as well as those guidelines - it tells the 
user roughly what is eligible for the warranty. It also gives the user a brief estimated time of when they will be recieveing a 
response back.

After that the user is presented: "Select Option for Warranty: Request - Status - Cancel - Exit":

   + Request: This is to file/request for a NEW warranty. It will prompt the user to enter their contact information (Name, Email
              and Phone Number)
  
  + Status: This is to check on the status of warranty that has alread been filed by the user. The user is asked to provide the 
            Warranty Number, the database uses that unique identifier to query and display the results for the user. It will show 
            the users: Name, Warranty Number, Brand, Product Type, Product Issue, and Status.
  
  + Cancel: This is to cancel a warranty, if the user decides they do not want to pursue a warranty claim. The user is asked to 
             provide the Warranty Number, the database uses that unique identifier to query and delete the data from our database.
           
  + Exit: This is to exit from the app, if the user no longer requires the services.

This is the Arc'teryx Warranty App. Thank you!
