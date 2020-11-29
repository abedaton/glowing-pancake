package parser;

import scanner.LexicalUnit;

import java.util.*;
import java.util.stream.IntStream;

public class ActionTable {
    private final String[] column = {"BEGINPROG", "PROGNAME", "ENDLINE", "ENDPROG", "(", ")", ":=", "+", "-", "*", "/", "VARNAME", "NUMBER", "IF", "THEN",
            "ELSE", "ENDIF", "=", ">", "WHILE", "DO", "ENDWHILE", "PRINT", "READ", "$"};

    private final String[] row = {"PROGRAM", "SPACE", "CODE", "INSTRUCTION", "ASSIGN", "EXPRARITH", "EXPRARITHBIS", "PROD", "PRODBIS", "ATOM",
            "IFVAR", "IFSEQ", "COND", "COMP", "WHILEVAR", "PRINTVAR", "READVAR"};

    private final Integer[][] data = new Integer[row.length][column.length];

    public ActionTable(){
        initData();
    }


    public int getColumnIndex(String name){
        OptionalInt index = IntStream.range(0, this.column.length).filter(i -> this.column[i].equals(name)).findFirst();
        if (index.isPresent()){
            return index.getAsInt();
        }
        return -1;
    }

    public int getRowIndex(String name){
        OptionalInt index = IntStream.range(0, this.row.length).filter(i -> this.row[i].equals(name)).findFirst();
        if (index.isPresent()){
            return index.getAsInt();
        }
        return -1;
    }

    public void insertIntoData(String rowName, String columnName, int value){
        int rowIndex = getRowIndex(rowName);
        if (rowIndex == -1){
            return;
        }
        int colIndex = getColumnIndex(columnName);
        if (colIndex == -1){
            return;
        }

        data[rowIndex][colIndex] = value;
    }

    public Integer getData(String rowName, String columnName){
        int rowIndex = getRowIndex(rowName);
        if (rowIndex == -1){
            return null;
        }
        int colIndex = getColumnIndex(columnName);
        if (colIndex == -1){
            return null;
        }

        return data[rowIndex][colIndex];
    }

    public Integer getData(Object rowName, Object columnName) {
        return getData(rowName.toString(), columnName.toString());
    }


    private void initData(){
        insertIntoData("PROGRAM", "ENDLINE", 1);
        insertIntoData("PROGRAM", "BEGINPROG", 1);

        insertIntoData("SPACE", "ENDLINE", 2);
        insertIntoData("SPACE", "BEGINPROG", 3);
        insertIntoData("SPACE", ":=", 3);
        insertIntoData("SPACE", "VARNAME", 3);
        insertIntoData("SPACE", "IF", 3);
        insertIntoData("SPACE", "ELSE", 3);
        insertIntoData("SPACE", "ENDIF", 3);
        insertIntoData("SPACE", "WHILE", 3);
        insertIntoData("SPACE", "ENDWHILE", 3);
        insertIntoData("SPACE", "PRINT", 3);
        insertIntoData("SPACE", "READ", 3);
        insertIntoData("SPACE", "$", 3);
        insertIntoData("SPACE", "ENDPROG", 3);


        insertIntoData("CODE", "VARNAME", 4);
        insertIntoData("CODE", "IF", 4);
        insertIntoData("CODE", "WHILE", 4);
        insertIntoData("CODE", "PRINT", 4);
        insertIntoData("CODE", "READ", 4);
        insertIntoData("CODE", "ENDPROG", 5);
        insertIntoData("CODE", "ELSE", 5);
        insertIntoData("CODE", "ENDIF", 5);
        insertIntoData("CODE", "ENDWHILE", 5);

        insertIntoData("INSTRUCTION", "VARNAME", 6);
        insertIntoData("INSTRUCTION", "IF", 7);
        insertIntoData("INSTRUCTION", "WHILE", 8);
        insertIntoData("INSTRUCTION", "PRINT", 9);
        insertIntoData("INSTRUCTION", "READ", 10);

        insertIntoData("ASSIGN", "VARNAME", 11);

        insertIntoData("EXPRARITH", "-", 12);
        insertIntoData("EXPRARITH", "VARNAME", 12);
        insertIntoData("EXPRARITH", "(", 12);
        insertIntoData("EXPRARITH", "NUMBER", 12);

        insertIntoData("EXPRARITHBIS", "+", 13);
        insertIntoData("EXPRARITHBIS", "-", 14);
        insertIntoData("EXPRARITHBIS", "ENDLINE", 15);
        insertIntoData("EXPRARITHBIS", "ENDPROG", 15);
        insertIntoData("EXPRARITHBIS", ")", 15);
        insertIntoData("EXPRARITHBIS", "VARNAME", 15);
        insertIntoData("EXPRARITHBIS", "", 15);
        insertIntoData("EXPRARITHBIS", "IF", 15);
        insertIntoData("EXPRARITHBIS", "ELSE", 15);
        insertIntoData("EXPRARITHBIS", "ENDIF", 15);
        insertIntoData("EXPRARITHBIS", "=", 15);
        insertIntoData("EXPRARITHBIS", ">", 15);
        insertIntoData("EXPRARITHBIS", "WHILE", 15);
        insertIntoData("EXPRARITHBIS", "ENDLINE", 15);
        insertIntoData("EXPRARITHBIS", "ENDWHILE", 15);
        insertIntoData("EXPRARITHBIS", "PRINT", 15);
        insertIntoData("EXPRARITHBIS", "READ", 15);


        insertIntoData("PROD", "(", 16);
        insertIntoData("PROD", "-", 16);
        insertIntoData("PROD", "VARNAME", 16);
        insertIntoData("PROD", "NUMBER", 16);

        insertIntoData("PRODBIS", "*", 17);
        insertIntoData("PRODBIS", "/", 18);
        insertIntoData("PRODBIS", "ENDLINE", 19);
        insertIntoData("PRODBIS", "ENDPROG", 19);
        insertIntoData("PRODBIS", ")", 19);
        insertIntoData("PRODBIS", "+", 19);
        insertIntoData("PRODBIS", "-", 19);
        insertIntoData("PRODBIS", "", 19);
        insertIntoData("PRODBIS", "VARNAME", 19);
        insertIntoData("PRODBIS", "IF", 19);
        insertIntoData("PRODBIS", "ELSE", 19);
        insertIntoData("PRODBIS", "ENDIF", 19);
        insertIntoData("PRODBIS", "=", 19);
        insertIntoData("PRODBIS", ">", 19);
        insertIntoData("PRODBIS", "WHILE", 19);
        insertIntoData("PRODBIS", "ENDWHILE", 19);
        insertIntoData("PRODBIS", "PRINT", 19);
        insertIntoData("PRODBIS", "READ", 19);


        insertIntoData("ATOM", "(", 23);
        insertIntoData("ATOM", "-", 20);
        insertIntoData("ATOM", "VARNAME", 21);
        insertIntoData("ATOM", "NUMBER", 22);

        insertIntoData("IFVAR", "IF", 24);

        insertIntoData("IFSEQ", "ELSE", 26);
        insertIntoData("IFSEQ", "ENDIF", 25);

        insertIntoData("COND", "(", 27);
        insertIntoData("COND", "-", 27);
        insertIntoData("COND", "VARNAME", 27);
        insertIntoData("COND", "NUMBER", 27);

        insertIntoData("COMP", "=", 28);
        insertIntoData("COMP", ">", 29);

        insertIntoData("WHILEVAR", "WHILE", 30);

        insertIntoData("PRINTVAR", "PRINT", 31);

        insertIntoData("READVAR", "READ", 32);





    }
}
