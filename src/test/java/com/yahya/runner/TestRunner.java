package com.yahya.runner;

import com.yahya.Day8.BaseAuthTest;
import com.yahya.Day8.LibraryLoginTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Smoke Test")
//@SelectPackages("com.yahya.Day8") // if you want to run a whole package
@SelectClasses(LibraryLoginTest.class) // If you just want to run 1 class
public class TestRunner {


}
