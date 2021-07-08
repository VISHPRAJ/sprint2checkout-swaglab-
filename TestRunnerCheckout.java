package runner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/CheckoutFeature/Checkout.feature",
                glue={"checkoutstepDefinions"},
                dryRun=false,
                monochrome=true)

public class TestRunnerCheckout {
}

