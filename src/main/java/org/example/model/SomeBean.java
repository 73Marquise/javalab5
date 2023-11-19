package org.example.model;

import org.example.interfaces.SomeInterface;
import org.example.interfaces.SomeOtherInterface;
import org.example.reflection.AutoInjectable;

public class SomeBean {

    @AutoInjectable
    private SomeInterface field1;
    @AutoInjectable
    private SomeOtherInterface field2;
    public void foo(){
        field1.doSomething();
        field2.doSomething();
    }
}
