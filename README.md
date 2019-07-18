
ClickBank coding-challenge
================

Thank you for taking the ClickBank Coding Challenge. We want to give you an opportunity to demonstrate your abilities while giving us a good sense of how you approach and address challenges. 

#### Create a REST API that will be used as the CRUD layer in your application. 
* Feel free to use something like Spring Boot, micronaut, Express, etc... to generate your application boilerplate. We use Material Design for UI components. Feel free to use that, or any other UI UI framework if you'd like. 
* Support the following routes
  * /user Generates a pageable list of users
  * /user/{userId} Gets user details on GET and update on PUT
  * /user Creates user
* Fetch some data from https://randomuser.me/api/?results=20 . This will give you an list of users to seed your database.

#### Create
* Display the main users list on the initial page. Include at least first, last, email, and profile image.  Provide a link to the full user profile in one of the columns. This link should take you a page or modal that displays the information available in /users/{userId}.
* The page or modal that results from clicking on a row should display all available information about a user as well as allow you to edit that information.

#### For an additional WOW factor, consider implementing the following:
* Use ReactJS for the client and 
g Boot as a backend for your solution. We have standardized on ReactJS and Spring Boot in all of our applications.
* Make the styles responsive to window changes. 
* Add any embellishments that allow you to show off your skills!

#### Submission
* Fork this repo, commit your work, issue a pull request.
* Please note, when the interview process has concluded you will be removed from the github team, which will also delete your fork of our private repo.
