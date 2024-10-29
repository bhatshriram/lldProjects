package model;

public enum Symbol {

    X('X'), O('O'), EMPTY(' ');

    Symbol(char value) {
        this.value = value;
    }

    private char value;

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
