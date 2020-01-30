package com.company;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ArithmeticCodeing {
    public double lowerRange=0;
    public double higherRange=1;
    private ArrayList<Range>symbols;

    public double compression(String message)
    {
        Range curObj=null;
        for (int i=0;i<message.length();i++)
        {
            curObj=searchForSymbol(String.valueOf(message.charAt(i)));
            lowerRange=lowerRange+(higherRange-lowerRange)*curObj.getSymbolLowRange();
            higherRange=lowerRange+(higherRange-lowerRange)*curObj.getSymbolHighRange();
        }

        System.out.println("Lower in Compresion "+ lowerRange);
        System.out.println("Higher in Compression"+  higherRange);
        double compressionValue= lowerRange+Math.random() * (higherRange - lowerRange);
        try {
            Files.write(Paths.get("E:\\ArithmeticCoding\\compression.txt"),String.valueOf(compressionValue).getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return compressionValue;
    }
    public StringBuilder decompression(double compressionRange,int messageSize)
    {   double readedCompressionRange=0;
        try {
            Scanner readCompressedValue=new Scanner(new File("E:\\ArithmeticCoding\\compression.txt"));
            readedCompressionRange=readCompressedValue.nextDouble();
            readCompressedValue.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        lowerRange=0;
        higherRange=1;
        double code=((readedCompressionRange-lowerRange)/(higherRange-lowerRange));
        StringBuilder outputMessage=new StringBuilder();
        for(int j=0;j<messageSize;j++) {

            for (int i = 0; i < symbols.size(); i++) {

                if (code < symbols.get(i).getSymbolHighRange() && code > symbols.get(i).getSymbolLowRange()) {
                    outputMessage.append(symbols.get(i).getSymbol());

                    lowerRange = lowerRange + (higherRange - lowerRange) * symbols.get(i).getSymbolLowRange();
                    higherRange = lowerRange + (higherRange - lowerRange) * symbols.get(i).getSymbolHighRange();
                    code = ((readedCompressionRange - lowerRange) / (higherRange - lowerRange));
                    break;
                }
            }
        }
        return outputMessage;
    }
    public Range searchForSymbol(String symbol)
    {
        Range tempObj = null;
        for(int i=0;i<symbols.size();i++)
        {
            if(symbols.get(i).getSymbol().equals(symbol))
            {
                tempObj=new Range(symbols.get(i).getSymbol(),symbols.get(i).getSymbolLowRange(),symbols.get(i).getSymbolHighRange());
            }
        }
        return tempObj;
    }

    public ArrayList<Range> getSymbols() {
        return symbols;
    }

    public void setSymbols(ArrayList<Range> symbols) {
        this.symbols = symbols;
    }
}
