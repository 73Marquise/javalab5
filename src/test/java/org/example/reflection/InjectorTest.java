package org.example.reflection;

import org.example.model.SomeBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InjectorTest {

    @Test
    void inject() {
        SomeBean bean = (new Injector()).inject(new SomeBean());
        Assertions.assertDoesNotThrow(bean::foo);
    }
}
