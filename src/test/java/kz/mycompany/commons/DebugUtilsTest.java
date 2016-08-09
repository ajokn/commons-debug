package kz.mycompany.commons;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DebugUtilsTest {

    @Test
    public void testIsCausedFromMethod() throws Exception {
        // given
        String methodName = "testIsCausedFromMethod";

        // when
        boolean actual = DebugUtils.isCausedFromMethod(methodName);

        // then
        assertTrue("Is not invoked from a method - " + methodName, actual);
    }

    @Test
    public void testIsNotCausedFromMethod() throws Exception {
        // given
        String methodName = "isNotCausedFromMethod";

        // when
        boolean actual = DebugUtils.isCausedFromMethod(methodName);

        // then
        assertFalse("Invoked from a method - " + methodName, actual);
    }

    @Test
    public void testIsCausedFromClass() throws Exception {
        // given
        String className = DebugUtilsTest.class.getName();

        // when
        boolean actual = DebugUtils.isCausedFromClass(className);

        // then
        assertTrue("Is not invoked from a class - " + className, actual);
    }

    @Test
    public void testIsNotCausedFromClass() throws Exception {
        // given
        String className = Test.class.getName();

        // when
        boolean actual = DebugUtils.isCausedFromClass(className);

        // then
        assertFalse("Invoked from a class - " + className, actual);
    }

    @Test
    public void testIsMethodCalledFromClass() throws Exception {
        // given
        String className = DebugUtilsTest.class.getName();
        String methodName = "testIsMethodCalledFromClass";

        // when
        boolean actual = DebugUtils.isMethodCalledFromClass(className, methodName);

        // then
        assertTrue("Method do not called from class - " + className + "." + methodName, actual);
    }

    @Test
    public void testIsNotMethodCalledFromClass() throws Exception {
        // given
        String className = DebugUtilsTest.class.getName();
        String methodName = "testIsMethodCalledFromClass";

        // when
        boolean actual = DebugUtils.isMethodCalledFromClass(className, methodName);

        // then
        assertFalse("Method called from class - " + className + "." + methodName, actual);
    }

    @Test
    public void testIsCausedFromHierarchyClass() throws Exception {
        // given
        String className1 = DebugUtilsTest.class.getName();
        String className2 = DebugUtils.class.getName();

        // when
        boolean actual = DebugUtils.isCausedFromHierarchyClass(className1, className2);

        // then
        assertTrue("Is not invoked from hierarchy class - " + Arrays.asList(className1, className2), actual);
    }

    @Test
    public void testIsNotCausedFromHierarchyClass() throws Exception {
        // given
        String className1 = Thread.class.getName();
        String className2 = Test.class.getName();

        // when
        boolean actual = DebugUtils.isCausedFromHierarchyClass(className1, className2);

        // then
        assertFalse("Invoked from hierarchy class - " + Arrays.asList(className1, className2), actual);
    }
}
