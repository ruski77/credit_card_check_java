Narrative: Validate a list of credit cards upload by a user

Scenario: Validate a list of credit cards

Given I am on the welcome page
When I see a list of 8 credit cards
Then I should see 5 valid cards and 3 invalid cards