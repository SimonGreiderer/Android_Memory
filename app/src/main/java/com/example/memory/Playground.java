package com.example.memory;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Playground {

    private Card[][] cards;
    // TODO: User kann Anzahl an Spielern noch nicht eingeben (selber schreiben!)
    private int whosOnTurn;
    private int[] score;

    public Playground(int x, int y) {
        cards = new Card[x][y];
        score = new int[5];
        init();
    }

    public void init() {
        List<Integer> liste = new ArrayList<Integer>();
        int zaehler = 0;
        int count = cards.length * cards[0].length;
        for(int i=0; i < count; i = i + 2) {
            liste.add(zaehler);
            liste.add(zaehler);
            zaehler++;
        }

        Collections.shuffle(liste);

        for(int i=0; i < cards.length;i++){
            for(int j=0; j < cards[i].length; j++) {
                cards[i][j] = new Card();
                int value = liste.get(0);
                liste.remove(0);
                cards[i][j].setValue(value);
            }
        }

    }

    // TODO: was macht diese Methode?
    public Card play(Position position) {

        return getCard(position);
    }

    public boolean finished() {
        for(int i=0; i< cards.length;i++){
            for(int j=0; j<cards[i].length; j++){
                if(!cards[i][j].isVisible()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPair(Position pos1, Position pos2) {
        if(getCard(pos1).getValue() == getCard(pos2).getValue()) {
            score[whosOnTurn] = score[whosOnTurn] + 1;
            getCard(pos1).setVisible(true);
            getCard(pos2).setVisible(true);
            return true;
        }
        return false;

    }

    public Card getCard(Position position) {
        return cards[position.x][position.y];
    }

    @Override
    public String toString() {
        return "Playground{" +
                "cards=" + Arrays.toString(cards) +
                ", whosOnTurn=" + whosOnTurn +
                ", score=" + Arrays.toString(score) +
                '}';
    }
}
