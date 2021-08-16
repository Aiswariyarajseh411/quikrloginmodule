import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features = {"C:\\quikrsprint2\\src\\test\\resources\\features"},
glue = {"stepdefinition"},
tags = "@aishu",
plugin = {
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
)
public class testrunner extends AbstractTestNGCucumberTests
{
@Override
@DataProvider(parallel = false)
public Object[][] scenarios() {
return super.scenarios();
}
}