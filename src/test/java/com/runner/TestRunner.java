package com.runner;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.constants.Constants;
import com.reports.ExtentReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/Login.feature"},glue= {"com.steps"},tags= "@tag1 or @tag2")
public class TestRunner {

	@BeforeClass
	public static void beforeClass() {
		ExtentReport.initialize();
	}

	@AfterClass
	public static void afterClass() throws IOException {
		ExtentReport.closeReports();

		File htmlFile = new File(Constants.EXTENTREPORTPATH);
		Desktop.getDesktop().browse(htmlFile.toURI());
	}


}
