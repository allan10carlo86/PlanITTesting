package TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import TestCases.TESTCASE1_ContactPage;
import TestCases.TESTCASE2_ContactPage2;
import TestCases.TESTCASE3_StartShopping1;
import TestCases.TESTCASE4_StartShopping2;		

@RunWith(Suite.class)				
@Suite.SuiteClasses({				
  TESTCASE1_ContactPage.class,
  TESTCASE2_ContactPage2.class,
  TESTCASE3_StartShopping1.class,
  TESTCASE4_StartShopping2.class
})


public class TestSuite1{
	
}