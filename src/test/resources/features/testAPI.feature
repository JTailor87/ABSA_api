Feature: API testing
  API testing using REST assured library and cucumber framework
  @POST
  Scenario: Test POST call
    Given User has a base URI to test "https://jsonplaceholder.typicode.com"
    When User send a post request "/posts"
    Then User validate the status code 201
    And User validate the response time les than 3000 ms
    And User validate the response header content length and content type
    And User validate the response json values