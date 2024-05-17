package com.yahya.runner;

import com.yahya.Day8.BaseAuthTest;
import com.yahya.Day8.LibraryLoginTest;
import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("Smoke Test")
//@SelectPackages("com.yahya.Day8") // if you want to run a whole package
//@SelectPackages("com.yahya.Day9")
//@SelectClasses(LibraryLoginTest.class) // If you just want to run 1 class
@SelectPackages("com.yahya.Day9")
@IncludeTags("smokeAll")
public class TestRunner {


}
