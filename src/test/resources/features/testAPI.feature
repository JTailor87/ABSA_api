Feature: API testing
  API testing using REST assured library and cucumber framework
  @DogAPI
  Scenario: ABSA-Task 1_API tests
    Given Base URI to test "https://dog.ceo/api"
    When Perform an API request to produce a list of all dog breeds "/breeds/list/all"
    Then Verify retriever breed is within the list of all dog breeds "/breeds/list/all"
    And Perform an API request to produce a list of sub-breeds for retriever "/breed/retriever/list"
    And Perform an API request to produce a random image link for the sub-breed golden "/breed/retriever/golden/images/random"