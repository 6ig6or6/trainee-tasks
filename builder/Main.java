package org.example.gofpatterns.builder;

public class Main {
    public static void main(String[] args) {
        PersonalComputer computer1 = new PersonalComputer
                .Builder("Ryzen 5000", "Nvidia RTX 3060")
                .build();
        PersonalComputer computer2 = new PersonalComputer
                .Builder("Ryzen 3000", "Built-in graphics")
                .setSsdCapacity(250)
                .setHddCapacity(2000)
                .setGraphicsCardBuiltInProcessor(true)
                .build();
        System.out.println(computer1);
        System.out.println(computer2);
    }
}
