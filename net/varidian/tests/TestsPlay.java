package net.varidian.tests;

import net.varidian.junit.*;

import org.junit.*;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class TestsPlay {

    @Test
    public void testPrivate() {
        PersonBean aPersonBean = new PersonBean("Luke");
        Field theNameField = null;

        try {
           theNameField = PersonBean.class.getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        theNameField.setAccessible(true);

        String aName = null;
        try {
            aName = (String)theNameField.get(aPersonBean);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        assertEquals("Luke", aName);
        //aName = "Luke2";

    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("This should be executed first");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("This should be executed last");
    }

    @Test
    public void checkTrueTest() throws Exception {
        JunitMethodsPlay tests1 = new JunitMethodsPlay();
        boolean test = tests1.checkTrue(5, 6);
        assertTrue(test);
    }

    @After
    public void checkFalseTest() throws Exception {
        JunitMethodsPlay tests2 = new JunitMethodsPlay();
        boolean test = tests2.checkFalse(5, 6);
        assertFalse(test);
        System.out.println("this should be second after testadd()");
    }

    @Test
    public void checkNotNull() throws Exception {
        JunitMethodsPlay tests3 = new JunitMethodsPlay();
        String test = tests3.notNull("test");
        assertNotNull(test);
    }

    @Test
    public void checkIsNull() throws Exception {
        JunitMethodsPlay tests4 = new JunitMethodsPlay();
        String test = tests4.isNull(null);
        assertNull(test);
    }

    @Test
    public void checkSameCheck() throws Exception {
        JunitMethodsPlay tests5 = new JunitMethodsPlay();
        String test = tests5.sameCheck("test");
        assertSame(test, "test");
    }

    @Ignore
    public void checkNotSameCheck() throws Exception {
        //JunitMethodsPlay tests6 = new JunitMethodsPlay();
        String test = "test";
        String f = "test2";
        assertNotSame(test, f);
    }

    @Test
    public void checkArrayCheck() throws Exception {
        JunitMethodsPlay tests7 = new JunitMethodsPlay();
        String[] expected = {"test1", "test2"};
        String[] test = tests7.arrayCheck(expected);
        String[] expected2 = {"test1", "test2"};
        assertArrayEquals(test, expected2);
    }

    @After
    public void testAdd() throws Exception {
        JunitMethodsPlay tests8 = new JunitMethodsPlay();
        int output = tests8.add(5);
        assertEquals(10, output);
        System.out.println("testAdd() ran first before anything else");
    }

}