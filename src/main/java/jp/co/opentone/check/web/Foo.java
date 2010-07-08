package jp.co.opentone.check.web;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Foo {

    public String name;
    public Foo() {}
    public Foo(String name) {
        this.name = name;
    }
}
