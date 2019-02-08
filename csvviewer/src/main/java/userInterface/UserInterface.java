package userInterface;


import csvData.DataEntity;
import csvData.Header;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public void showHeader(List<DataEntity> dataEntities) {
        addSpaces(dataEntities);
        int[] rowlengths = getRowLength(dataEntities);
        Header header = createHeader(rowlengths, dataEntities.get(0));
        String headerAsString = header.getValue1() + "|" + header.getValue2() + "|" + header.getValue3() + "|";
        System.out.println(headerAsString);
        String tableLining = headerAsString;
        tableLining = tableLining.toLowerCase();
        tableLining = tableLining.replaceAll( ("[0-9]|[a-z]"), "-");
        tableLining = tableLining.replaceAll( (" "), "-");
        tableLining = tableLining.replaceAll("[/|]", "+");
        System.out.println(tableLining);
    }

    private void addSpaces(List<DataEntity> dataentities) {
        int[] rowlengths = getRowLength(dataentities);
        for (DataEntity dataentity : dataentities) {
            if (dataentity.getValue1().length() < rowlengths[0]) {
                int spacescount = rowlengths[0] - dataentity.getValue1().length();
                String spaces = "";
                for (int i = 0; i < spacescount; i++) {
                    spaces = spaces + " ";
                }
                dataentity.setValue1(spaces + dataentity.getValue1());
            }
            if (dataentity.getValue2().length() < rowlengths[0]) {
                int spacescount = rowlengths[0] - dataentity.getValue2().length();
                String spaces = "";
                for (int i = 0; i < spacescount; i++) {
                    spaces = spaces + " ";
                }
                dataentity.setValue2(spaces + dataentity.getValue2());
            }
            if (dataentity.getValue3().length() < rowlengths[0]) {
                int spacescount = rowlengths[0] - dataentity.getValue3().length();
                String spaces = "";
                for (int i = 0; i < spacescount; i++) {
                    spaces = spaces + " ";
                }
                dataentity.setValue3(spaces + dataentity.getValue3());
            }
        }
    }


    private Header createHeader(int[] rowlengths, DataEntity dataEntity) {
        return new Header(rowlengths[0], rowlengths[1], rowlengths[2], dataEntity.getValue1(), dataEntity.getValue2(), dataEntity.getValue3());
    }

    private int[] getRowLength(List<DataEntity> dataEntities) {
        int column1 = 0;
        int column2 = 0;
        int column3 = 0;
        for (DataEntity dataEntity : dataEntities) {
            if (dataEntity.getValue1().length() > column1) {
                column1 = dataEntity.getValue1().length();
            }
            if (dataEntity.getValue2().length() > column2) {
                column2 = dataEntity.getValue2().length();
            }
            if (dataEntity.getValue3().length() > column3) {
                column3 = dataEntity.getValue3().length();
            }
        }
        int[] rowlength = new int[]{column1, column2, column3};
        return rowlength;
    }

    public String getUserInput() {
        System.out.println("N(ext page, P(revious page, F(irst page, L(ast page, eX(it");
        System.out.println("Enter your text: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void drawData(List<DataEntity> dataEntities){
        addSpaces(dataEntities);
        for(DataEntity dataEntity : dataEntities){
            System.out.println(dataEntity.getValue1() + "|" + dataEntity.getValue2() + "|" + dataEntity.getValue3() + "|");        }
    }
/*
    public void nextStep(String input) {
        if (input.equals("n")) {
            page.gotoNextPage();
        } else if (input.equals("p")) {
            page.gotoPreviousPage();
        } else if (input.equals("f")) {
            page.gotoFirstPage();
        } else if (input.equals("l")) {
            page.gotoLastPage();
        } else if (input.equals("x")) {
            System.exit(0);
        } else {
            System.out.println("Wrong input, try again");
            getUserInput();
        }
    }*/
}
