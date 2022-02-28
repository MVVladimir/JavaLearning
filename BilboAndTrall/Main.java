package com.company;

public class Main {

    public static void main(String[] args) {
        Gnome bilbo = new Gnome("Bilbo", 100, 10);
        Orc trall = new Orc("Trall", 110, 8);
        while (bilbo.isAlive() && trall.isAlive()) {
            bilbo.toAttack(trall);
            trall.toAttack(bilbo);
            System.out.println(trall + "\t\t" + bilbo);
        }
    }
}
