package com.company;

import java.util.ArrayList;

public class Range {
    private String symbol;
    private double symbolLowRange;
    private double symbolHighRange;
    public Range(String  symbol,double symbolLowRange,double symbolHighRange)
    {
        this.symbol=symbol;
        this.symbolLowRange=symbolLowRange;
        this.symbolHighRange=symbolHighRange;
    }

    public Range() {

    }


    public ArrayList<Range> calcluateSymbolRange(ArrayList<Symbol>symbols)
    {
        double higher=0;
    ArrayList<Range>symbolsRange=new ArrayList<>();
    double symbolLowRange=0;
    double symbolHighRange=0;
    for (int i=0;i<symbols.size();i++)
    {
        symbolLowRange=higher;
        higher+=symbols.get(i).getProb();
        symbolHighRange=higher;
        symbolsRange.add(new Range(symbols.get(i).getSymbol(),symbolLowRange,symbolHighRange));

    }
    for(int i=0;i<symbolsRange.size();i++) {

       System.out.println(symbolsRange.get(i).getSymbol()+"  "+symbolsRange.get(i).getSymbolLowRange()+ "  "+symbolsRange.get(i).getSymbolHighRange());
    }
    return symbolsRange;

    }
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getSymbolLowRange() {
        return symbolLowRange;
    }

    public void setSymbolLowRange(double symbolLowRange) {
        this.symbolLowRange = symbolLowRange;
    }

    public double getSymbolHighRange() {
        return symbolHighRange;
    }

    public void setSymbolHighRange(double symbolHighRange) {
        this.symbolHighRange = symbolHighRange;
    }
}
