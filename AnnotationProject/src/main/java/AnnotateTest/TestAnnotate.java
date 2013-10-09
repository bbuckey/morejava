package AnnotateTest;

import java.lang.reflect.Method;
import IAnnotateTest.IAnnotate;

public class TestAnnotate {


    public void method1() {
        System.out.println("method1");
    }

    @IAnnotate
    public void method2() {
        System.out.println("method2");
    }

    @IAnnotate
    public void method3() {
        System.out.println("method3");
    }

    public void method4() {
        System.out.println("method4");
    }

    public void method5() {
        System.out.println("method5");
    }
	
}
