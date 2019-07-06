package runner;

import cucumber.api.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features="src/test/java/features", glue= {"steps"}
, plugin={"pretty", "html:target/cuccmber-html-report"})
public class TestRunner extends TestBase
{

}
