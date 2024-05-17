package com.yahya.runner;

import com.yahya.tests.Day8.BaseAuthTest;
import com.yahya.tests.Day8.LibraryLoginTest;
import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Smoke Test")
//@SelectPackages("com.yahya.tests.Day8") // if you want to run a whole package
//@SelectPackages("com.yahya.tests.Day9")
//@SelectClasses(LibraryLoginTest.class) // If you just want to run 1 class
//@SelectPackages("com.yahya.tests.Day9")
//@IncludeTags("smokeAll")
//@ExcludeTags("smoke2")
@SelectPackages("com.yahya.tests")
@IncludeTags({"smoke1", "tc1"})
public class TestRunner {

}
