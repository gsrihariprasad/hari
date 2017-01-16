package com.hcl.selenium.pageobjects;

import org.testng.annotations.Guice;

import com.google.inject.Inject;
@Guice(modules = ChildModule.class)
public class Foo {
    private final Bar bar;

    @Inject
    public Foo(final Bar bar) {
        this.bar = bar;
    }

    public Bar getBar() {
        return bar;
    }
}
