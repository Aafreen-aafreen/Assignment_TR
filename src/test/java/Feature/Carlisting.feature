Feature:Validate Dashboard Details

Background:Launch the React App
    Given launching application & validate the title of the page
@Test1
Scenario:Validate Cars Listing Page
    Then click on view all cars button on dashboard
    And validate if all cars are listed on car listing page
 @Test1
Scenario: Validate the total number of cars in View All page
    When the users clicks on View All page
    Then count the total numbers of cars in each section