package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features= {"src/test/resources/Login.feature"},glue= {"com.steps"},tags="@tag1 or @tag2")
public class TestNGRunner extends AbstractTestNGCucumberTests{
	

}
