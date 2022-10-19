package org.example.gofpatterns.visitor;

public class ElementVisitor implements Visitor {

    @Override
    public void visit(Element element) {
        System.out.println("processing a " + element.getClass().getSimpleName() + " element");
    }

}
