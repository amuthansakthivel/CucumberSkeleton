package com.steps;


import java.io.PrintStream;
import java.io.StringWriter;
import java.util.ArrayList;

import org.apache.commons.io.output.WriterOutputStream;

import com.reports.ExtentManager;
import com.reports.ExtentReport;
import com.reports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CommonSteps {

	protected StringWriter writer;
	protected PrintStream captor;

	@Before
	public void setUp(Scenario scenario) {


		System.out.println(scenario.getId() + "-->"+ scenario.getName() +"--->"+scenario.getLine()+"-->"+scenario.getSourceTagNames());
		writer = new StringWriter();
		captor = new PrintStream(new WriterOutputStream(writer), true);


		ExtentManager.setExtentTest(ExtentReport.extent.createTest(scenario.getName()));
		//ExtentManager.getExtTest().createNode(scenario.getId());

	}

	@After
	public void tearDown(Scenario scenario) {
		System.out.println("after");
		if(scenario.getStatus().toString().equalsIgnoreCase("passed")) {
			LogStatus.pass(scenario.getName()+" is passed");
		}
		else {
			LogStatus.fail( scenario.getName()+" is failed");
		}
		//ExtentReport.extent.endTest(ExtentManager.getExtTest());

	}


	public void writeRequestAndResponseInReport(String request,String response) {

		LogStatus.info("---- Request ---");
		formatAPIAndLogInReport(request);
		LogStatus.info("---- Response ---");
		formatAPIAndLogInReport(response);
	}

	/*
	 * Format the api string and log in Extent Report
	 * @author : Amuthan Sakthivel
	 * @param  : apicontent
	 */
	protected void formatAPIAndLogInReport(String content) {

		String prettyPrint = content.replace("\n", "<br>");
		LogStatus.info("<pre>" + prettyPrint + "</pre>");

	}

}
