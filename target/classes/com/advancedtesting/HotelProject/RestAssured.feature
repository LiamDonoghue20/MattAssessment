Feature: As an Admin,
I want to manage the details of owners in the system,
So that I can keep up to date information about all owners.

Scenario: getting an owner
Given the get user function
When I enter an owners last name
Then the status code 200 should be returned

Scenario: posting an owner
Given the post owner function
When I enter the correct details
Then the status code 201 should be returned

Scenario: deleting an owner
Given the delete function
When I enter an owners last name
Then the status code 200 should be returned
