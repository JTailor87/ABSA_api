package org.example.stepdefs;

import io.cucumber.java.en.*;
import org.example.pages.dogPage;

public class dogSteps {
    dogPage dog = new dogPage();

    @Given("Base URI to test {string}")
    public void base_uri_to_test(String baseUri) {
        dog.userHasBaseUri(baseUri);
    }
    @When("Perform an API request to produce a list of all dog breeds {string}")
    public void perform_an_api_request_to_produce_a_list_of_all_dog_breeds(String endPoint) {
        dog.retriveThelistOfAllDogBreeds(endPoint);
    }
    @Then("Verify retriever breed is within the list of all dog breeds {string}")
    public void verify_retriever_breed_is_within_the_list(String endpoint) {
        dog.verifyIsRetriverBreedPresent(endpoint);
    }
    @Then("Perform an API request to produce a list of sub-breeds for retriever {string}")
    public void perform_an_api_request_to_produce_a_list_of_sub_breeds_for_retriever(String endpoint) {
        dog.retriveThelistOfSubBreedOfRetriver(endpoint);
    }
    @Then("Perform an API request to produce a random image link for the sub-breed golden {string}")
    public void perform_an_api_request_to_produce_a_random_image_link_for_the_sub_breed_golden(String endpoint) {
        dog.retriveTheImageLinkOfSubBreedGolden(endpoint);
    }
}
