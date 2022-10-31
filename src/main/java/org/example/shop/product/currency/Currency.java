package org.example.shop.product.currency;

public enum Currency {
    UAH(980, 1),
    USD(840, 0.0271),
    EUR(978, 0.0276),
    PLN(985, 0.1313);
    private final int internationalCode;
    private double course;
    Currency(int internationalCode, double course) {
        this.internationalCode = internationalCode;
        this.course = course;
    }

    public int getInternationalCode() {
        return internationalCode;
    }

    public double getCourse() {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }
}
