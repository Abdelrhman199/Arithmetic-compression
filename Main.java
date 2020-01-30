package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String inputMessage = null,symbol;
        double inputProb;
        int nChar;
        ArrayList<Symbol>inputSymbols = new ArrayList<>();
        try {
            Scanner readFromFile= new Scanner(new File("E:\\ArithmeticCoding\\src\\com\\company\\inputMessage.txt"));
            inputMessage=readFromFile.nextLine();
            nChar=readFromFile.nextInt();
            for(int i=0;i<nChar;i++)
            {
                symbol=readFromFile.next();
                inputProb=readFromFile.nextDouble();
                inputSymbols.add(new Symbol(symbol,inputProb));
            }
        readFromFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }







        Range obj=new Range();

        ArithmeticCodeing codeObj=new ArithmeticCodeing();
        codeObj.setSymbols(obj.calcluateSymbolRange(inputSymbols));
        double compressedValue=codeObj.compression(inputMessage);
        System.out.println("compressed Value "+" "+compressedValue);
        System.out.println(" decompressed Message "+"  "+codeObj.decompression(compressedValue,inputMessage.length()));
    }
}
