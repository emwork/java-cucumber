package stepdefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ca.skyline.model.Security;
import ca.skyline.service.FixdIncomeService;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;

public class EntityServiceSteps {
    private Security result;
    private FixdIncomeService service = new FixdIncomeService();

    private float oldRate;
    private Security securityToPrice;
    private String errorMessage;

    @DataTableType
    public Security securityEntry(Map<String, String> entry) {
        return Security.builder()
                .assetClass(entry.get("assetClass"))
                .description(entry.get("description"))
                .price(Float.parseFloat(entry.get("price")))
                .yield(Float.parseFloat(entry.get("yield")))
                .build();
    }

    @ParameterType("(.*)\\|(.*)\\|\\$(.*)\\|(.*)%") // regex for Bond|Canada-3-Year|$100|4.5%
    public Security security(String assetClass, String description, String price, String yield) {
        return Security.builder()
                .assetClass(assetClass)
                .description(description)
                .price(Float.parseFloat(price))
                .yield(Float.parseFloat(yield))
                .build();
    }

    @Given("interest rate is {float}%")
    public void getOldRate(float intRate) {
        oldRate = intRate;
    }
    @Given("{} {} price is ${}, yield is {}%")
    public void getSecurity(String description, String assetClass, float price, float yield) {
        securityToPrice = Security.builder()
                .assetClass(assetClass)
                .description(description)
                .price(price)
                .yield(yield)
                .build();
    }
    @Given("Security is {security}")
    public void getSecurity(Security security) {
        securityToPrice = security;
    }
    @Given("Bond is")
    public void getBonds(List<Security> securityList) {
        securityToPrice = securityList.get(0);
    }

    @When("interest rate changes to {float}%")
    public void ratesChange(float newRate) {
        try {
            result = service.recalcPrice(securityToPrice, oldRate, newRate);
        } catch (Exception e) {
            errorMessage = e.getMessage();
        }
    }

    @Then("Bond price is ${float}")
    public void thePriceShouldBe(float expectedPrice) {
        assertEquals(expectedPrice, result.getPrice());
    }
    @Then("Bond yield is {float}%")
    public void theYieldShouldBe(float expectedYield) {
        assertEquals(expectedYield, result.getYield());
    }
    @Then("Exception is thrown {string}")
    public void exceptionThrown(String expectedError) {
        assertEquals(expectedError, errorMessage);
    }

}

