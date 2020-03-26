package com.ocr.anthony;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class OrderReader {
    public static void main(String[] args) {
        OrderReader or = new OrderReader();
        or.read();

    }

    public int giveCnumber(List cLine, int i, int j){
        try{
            return Integer.parseInt(((String)cLine.get(i)).split(",")[j]);
        }catch(NumberFormatException e) {
            System.out.println("Bad input for parseInt");
        }
        return 0;
    }


    public void read(){
        String[] menus = {"poulet", "boeuf", "végétarien"};
        String[] responsesAllSide = {"légumes frais", "frites", "riz"};
        String[] responsesOnlyRice = {"riz", "pas de riz"};
        String[] responsesDrink = {"eau plate", "eau gazeuse", "soda"};

        Path rPath = Paths.get("order.csv");
        List commandLine = null;

        try {
            commandLine = Files.readAllLines(rPath);
        } catch (IOException e) {
            System.out.println("Impossible de lire la commande");
        }

        for (int i = 1; i<commandLine.size(); i++){
            switch(giveCnumber(commandLine, i, 0)) {
                case 1:
                    System.out.println("Menu " +menus[giveCnumber(commandLine, i, 0)-1] + " avec " + responsesAllSide[giveCnumber(commandLine, i, 1 )-1] + " et " +responsesDrink[giveCnumber(commandLine, i, 2)-1] );
                    break;
                case 2:
                    System.out.println("Menu " +menus[giveCnumber(commandLine, i,0)-1] + " avec " + responsesAllSide[giveCnumber(commandLine, i, 1)-1]);
                    break;
                case 3:
                    System.out.println("Menu " + menus[giveCnumber(commandLine, i,0)-1] + " avec " + responsesOnlyRice[giveCnumber(commandLine, i, 1)-1] + " et " + responsesDrink[giveCnumber(commandLine, i, 2)-1] );
                    break;

                default:
                    System.out.println("No more orders!");
                    break;
            }
        }
    }
}
