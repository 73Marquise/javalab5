package org.example;

import org.example.model.SomeBean;
import org.example.reflection.Injector;

public class Main {
    public static void main(String[] args) {
        SomeBean bean = (new Injector()).inject(new SomeBean());
        bean.foo();
    }
}