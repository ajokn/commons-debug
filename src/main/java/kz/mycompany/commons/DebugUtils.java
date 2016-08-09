package kz.mycompany.commons;

public class DebugUtils {

    public static boolean isCausedFromMethod(String methodName) {
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            if (element.getMethodName().equals(methodName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCausedFromClass(String className) {
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            if (element.getClassName().equals(className)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMethodCalledFromClass(String className, String methodName) {
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            if (element.getClassName().equals(className) && element.getMethodName().equals(methodName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCausedFromHierarchyClass(String... classesName) {
        int index = 0;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = stackTrace.length - 1; i > 0; i--) {
            StackTraceElement element = stackTrace[i];
            if (element.getClassName().equals(classesName[index])) {
                index++;
                if (index == classesName.length) {
                    return true;
                }
            }
        }
        return false;
    }
}