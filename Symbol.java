package com.company;

public class Symbol {
    private String symbol;
    private double prob;

    public Symbol(String symbol,double prob)
    {
        this.symbol=symbol;
        this.prob=prob;
    }
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }
}
