package org.example.gofpatterns.visitor;

public class JsonElement extends Element{
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
