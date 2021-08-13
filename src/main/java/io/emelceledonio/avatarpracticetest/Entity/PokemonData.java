package io.emelceledonio.avatarpracticetest.Entity;

import java.util.ArrayList;

public class PokemonData {

    int count;
    String next;
    String previous;
    ArrayList<Pokemon> result;

    public PokemonData() {
    }

    public PokemonData(int count, String next, String previous, ArrayList<Pokemon> result) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public ArrayList<Pokemon> getResult() {
        return result;
    }

    public void setResult(ArrayList<Pokemon> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Detalle{" +
                "count=" + count +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", result=" + result +
                '}';
    }
}
