package org.example.stepdefs;

import io.cucumber.java.en.*;
import org.example.pages.postPage;
import org.testng.Assert;

public class testSteps {

    postPage Post = new postPage();

    @Given("User has a base URI to test {string}")
    public void user_has_a_endpoint_to_test(String baseUri) {
        Post.userHasBaseUri(baseUri);
    }
    @When("User send a post request {string}")
    public void user_send_a_post_request(String endPoint) {
        Post.sendPostRequest(endPoint);
    }
    @Then("User validate the status code {int}")
    public void user_validate_the_status_code(Integer statusCode) {
        Assert.assertEquals(Post.validateStatusCode(), statusCode);
    }
    @Then("User validate the response time les than {long} ms")
    public void user_validate_the_response_time_les_than_ms(Long responseTime) {
        Post.validateTheResponseTime(responseTime);
    }
    @Then("User validate the response header content length and content type")
    public void user_validate_the_response_header_content_length_and_content_type() {
        Post.validateHeaderContentType();
        Post.ValidateHeaderContentLength();
    }
    @Then("User validate the response json values")
    public void user_validate_the_response_json_values() {
        Post.validateResponseBody();
    }
}
