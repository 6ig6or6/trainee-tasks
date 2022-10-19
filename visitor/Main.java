package org.example.gofpatterns.visitor;

public class Main {
    public static void main(String[] args) {
        Visitor visitor = new ElementVisitor();

        Document document = new Document();
        document.elements.add(new JsonElement());
        document.elements.add(new JsonElement());
        document.elements.add(new XmlElement());

        document.accept(visitor);
    }
}
