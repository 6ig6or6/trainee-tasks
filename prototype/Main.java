package org.example.gofpatterns.prototype;

public class Main {
    public static void main(String[] args) {
        Skyscraper firstSkyscraper = new Skyscraper(400, 150, "New York");
        Skyscraper second = (Skyscraper) firstSkyscraper.clone("Minsk");
        Hovel firstHovel = new Hovel(4, 1, "Middle of nowhere");
        Hovel secondHovel = (Hovel) firstHovel.clone("The center of the city");
    }
}
