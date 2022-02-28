package com.company;

public class Orc extends Actor implements Attack{
    private int dmg = 1;

    public Orc() {
        super();
    }

    @Override
    public boolean isAlive() {
        return getHp() > 0;
    }

    public Orc(String name, int hp, int dmg) {
        super(name, hp);
        this.dmg = dmg;
    }

    @Override
    public void toAttack(HP hp) {
        hp.setHp(hp.getHp() - dmg);
    }
}
