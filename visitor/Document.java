package org.example.gofpatterns.visitor;

import java.util.ArrayList;
import java.util.List;

public class Document extends Element {
    //document consists of xml and json parts
    List<Element> elements = new ArrayList<>();

    @Override
    public void accept(Visitor v) {
        elements.forEach(e -> e.accept(v));
    }
}
