package org.itstep.task04;

public class Fraction {
    private int numerator;//числитель
    private int denominator;//знаменатель

    public Fraction() {

    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public Fraction addition(Fraction value) {
        Fraction fractionAdd = new Fraction();
        fractionAdd.denominator = denominator * value.denominator;
        fractionAdd.numerator = numerator * value.denominator + value.numerator * denominator;
        fractionAdd.nod();
        return fractionAdd;
    }

    public Fraction subtraction(Fraction value) {
        Fraction fractionAdd = new Fraction();
        fractionAdd.denominator = denominator * value.denominator;
        fractionAdd.numerator = numerator * value.denominator - value.numerator * denominator;
        fractionAdd.nod();
        return fractionAdd;
    }

    public Fraction multiplication(Fraction value) {
        Fraction fractionAdd = new Fraction();
        fractionAdd.denominator = denominator * value.denominator;
        fractionAdd.numerator = numerator * value.numerator;
        fractionAdd.nod();
        return fractionAdd;
    }

    public Fraction division(Fraction value) {
        Fraction fractionAdd = new Fraction();
        fractionAdd.denominator = denominator * value.numerator;
        fractionAdd.numerator = numerator * value.denominator;
        fractionAdd.nod();
        return fractionAdd;
    }

    public void nod() {//наименьший общий делитель
        int a = numerator;
        int b = denominator;
        while (a != b) {
            if (a > b) a = a - b;
            else b = b - a;
        }
        numerator = numerator / a;
        denominator = denominator / a;
    }
}
