package AnnotateTest;

import java.lang.reflect.Method;
import IAnnotateTest.IAnnotate;
import AnnotateTest.TestAnnotate;

public class MyTest {

    public static void main(String[] args) {

    	TestAnnotate runner = new TestAnnotate();
        Method[] methods = runner.getClass().getMethods();

        for (Method method : methods) {
        	IAnnotate annos = method.getAnnotation(IAnnotate.class);
            if (annos != null) {
                try {
                    method.invoke(runner);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
} 