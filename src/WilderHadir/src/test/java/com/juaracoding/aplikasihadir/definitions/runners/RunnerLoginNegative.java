// package com.juaracoding.aplikasihadir.definitions.runners;

// import io.cucumber.testng.AbstractTestNGCucumberTests;
// import io.cucumber.testng.CucumberOptions;

// @CucumberOptions(
//         features = {"src/test/resources/features/Authentication.feature"},
//         glue = {
//             "com.juaracoding.aplikasihadir.definitions.authentication",
//             "com.juaracoding.aplikasihadir.utils" // TAMBAHKAN PACKAGE HOOK
//         },
//         tags = "@NegativeLogin",
//         plugin = {
//             "pretty",
//             "html:target/cucumber-reports.html",
//             "json:target/cucumber.json",
//             "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
//         }
// )
// public class RunnerLoginNegative extends AbstractTestNGCucumberTests {
// }