package com.company;

public abstract class Actor implements HP {
    private String name;
    private int hp = 0;

    public Actor() {
        this.name = "NoName";
        this.hp = 1;
    }

    public Actor(String name, int hp) {
        this.name = name;
        setHp(hp);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp < 0)
            this.hp = 0;
        else
            this.hp = hp;
    }

    public abstract boolean isAlive();

    @Override
    public String toString() {
        return name + " " + hp;
    }
}
