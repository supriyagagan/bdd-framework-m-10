package hooks;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks extends BaseTest{

	@Before
	public void beforeScenario() {
		setUp();
	}

	@After
	public void afterScenario() {
		tearDown();
	}
}
