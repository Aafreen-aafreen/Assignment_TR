Feature:Validate Dashboard Details

  Background:Launch the React App
    Given launching application & validate the title of the page

  Scenario:Book the Car
    And Click the Car  you want to book
    Then Validate the car details of in car details page
    Then Click on Book Now
    Then Validate the car details of selected car on booking page
    Then Enter the name in username textbox on Booking page
    Then Enter the Contact No in contact number texbox on Booking page
    Then Enter the City in city textbox on Booking page
    Then Check the terms and conditions
    Then Click on Submit button
    Then Validate the booking is successful