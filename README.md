# Refactor and Extension Exercise

There are two starter projects for the refactor and extension exercise: One for [Java Spring](./Spring) and one for [Javascript React](./React). Before you and your team can begin refactoring and extending the one of the applications you will need to perform the following steps:

- Filter out bad stories with INVEST criteria
- Story point each story
- Prioritize the user stories
- (Optional) Refine the items under the Specifications section

Once the stories have been properly refined your team will need to either fork this project into a new central repository, or copy the code in the App.js file into a new React template and post it to a central git repository.  This will serve as the starter project for the entire team.

After the starter project is posted, you and your team can begin refactoring the existing application and adding the functionality listed in the remaining user stories. Be sure to follow the practices and principles listed below. Also you and your team may use the architectural guidelines to help you decide how to organize the application.

## Practices & Principles

Use the following practices and principles during this exercise.

- Iteration Planning
- Automated Testing
- Test Driven Development
    - Red, Green, Refactor
    - 3 Laws Of TDD
    - N-ZOMBIES
- DRY (Rule of 3)
- SOLID
- Clean Code
- YAGNI
- Stateful and Stateless components
- Architect the solution into appropriate layers
- Paired Programming (Optional)
- Feature foldering (optional)

## Architectural Guidelines (Optional)

Use the following optional architectural guidelines while refactoring and implementing user stories:

- Use a centralized git repository (GitHub, GitLab, BitBucket, etc...)
- Use a CI/CD pipeline for your builds
- Use a RESTful API for business rules and storing to a persistence layer
- Organize your application into appropriate domains and slice it into micro services
- Use message queues, events, and services buses to pass information between services
- Run your services in Docker containers
- Deploy the master branch of your application to a cloud host

## Personas

Below you will find some personas of people who will be interacting with your application.  Use them to help in making your decisions about the User Stories.

* **Todd**
  * **Roles**: Customer, User
  * **Goals**: Sell my collection of cars for the best value.  Buy new or used cars to add to my collection at the best value.
  * **Potholes**: Uses his phone a lot. Prefers to talk to people directly instead of through automated systems. Middle aged and not fond of technology.

* **Mary**
  * **Roles**: Customer, Anonymous
  * **Goals**: Sell the car her ex-husband left her.
  * **Potholes**: Doesn't want to haggle. Only uses her cell phone to go online.

* **Laura**
  * **Roles**: Owner of the dealership
  * **Goals**: Add to her inventory of vehicles that have the best potential to make money.  Keep the lot stocked with enough vehicles to sell and draw in customers.
  * **Potholes**: Not very tech savvy.

## User Stories

Story point, prioritize, then complete these user stories:

#### User Stories

> **NOTE**: If being led by an instructor, use the first four stories to walk through INVEST, Story Pointing, and Prioritizing.

- As Todd I want to see a full inventory of vehicles the company owns so I can see if my car is already listed.

- As Todd I want to see a history of the cars I have submitted to the form so that I don't submit a vehicle a second time.

- As Laura I want to be able to create new model and year acceptance rules through the website so that I can accept more types of vehicles.

- As Laura I want to see the value of each vehicle in my inventory so I can price the vehicles on my lot.

- As Mary I want to see a message that tells me why a car is not valid so that I know why my submission is being rejected.

- As Todd I want to be able to see information about the company I am submitting the car information to so that I know it is a legitimate business.

- As Todd I want to be able to send the business owner a message so that I can ask a follow up question if my car is accepted or rejected.

- As Mary I want to be able to access the website from my phone so I can submit a vehicle while I'm away from home.

- As Mary I want my choices of vehicle makes, models, and years to be automatically populated so that I can easily pick my vehicle.

- As Laura I want to be able to accept specific models of vehicles along with their year and make so that I can accept a wider range of vehicles.

- As Laura I want to be able to know the colors of the vehicles being submitted to the form so that I can make better decisions about my inventory.

- As Laura I want to be able to remove acceptance rules so that I can stop accepting vehicles that are already in my inventory.

- As Laura I want to be able to see a list of email addresses of customers who use the website so that I can send them a newsletter.

- As Laura I want to be able to see a picture of the vehicle submitted by the customer so that I can manually reject a vehicle if it has damage.

#### Specifications (Optional)

Assume that someone has written the following specifications.  Determine if each item should be a practice for the team to implement, something that needs to be rewritten as a user story, or it is a technical task that should be associated with a user story.

- Use MySQL to manage the persisted data.
- As a developer I want to store a list of vehicles in a database so that my back end service can persist the vehicle data.
- The application shall allow users to attach pictures of their vehicles with their vehicle submissions.
- The VIN Audit API should be used to validate every vehicle VIN before accepting a user submission.
- Update the tests in the back end to ensure a minimum of 90% test coverage.
- The application shall allow users to export a list of vehicle inventory to Excel.
- The back end service should not take more than 1 second to respond to a request.
- When a user selects an date which their chosen vehicle wasn't made then the should get a message indicating their mistake.


## Helpful Resources

- [Project Board With Pre-written Stories](https://github.com/gSchool/refactor-and-extend-exercise/projects/1)
- [NHTSA Vehicle API](https://vpic.nhtsa.dot.gov/api/)
- [VIN Audit - Market Value API](https://www.vinaudit.com/vehicle-market-value-api)
