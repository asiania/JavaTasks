package org.example;

public class ForTests {

    @BeforeSuite
    static void beforeSuiteMethod1(){
        System.out.println("BeforeSuiteMethod1");
    }

    static void beforeSuiteMethod2(){
        System.out.println("BeforeSuiteMethod2");
    }

    @AfterSuite
    static void afterSuiteMethod1(){
        System.out.println("AfterSuiteMethod1");
    }

    static void afterSuiteMethod2(){
        System.out.println("AfterSuiteMethod2");
    }

    @BeforeTest
    static void beforeTestMethod1(){
        System.out.println("BeforeTestMethod1");
    }

    @BeforeTest
    static void beforeTestMethod2(){
        System.out.println("BeforeTestMethod2");
    }

    @AfterTest
    static void afterTestMethod1(){
        System.out.println("AfterTestMethod1");
    }

    @AfterTest
    static void afterTestMethod2(){
        System.out.println("AfterTestMethod2");
    }

    @Test
    @CsvSource("10, Java, 20, true")
    static void testMethod1(int a, String b, int c, boolean d){
        System.out.println("testMethod1 a="+a+" b="+b+" c="+c+" d="+d);
    }

    @Test(priority=1)
    @CsvSource("false, 5, C++, 150")
    void testMethod2(boolean a, int b, String c, int d){
        System.out.println("testMethod2 a="+a+" b="+b+" c="+c+" d="+d);
    }


}
