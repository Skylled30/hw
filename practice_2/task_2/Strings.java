package com.company;

public class Strings {
    private String[] lines;
    private int length;

    public Strings() {
        this.lines = new String[100];
        this.length = 0;
    }

    public void add(String line){
        lines[length] = line;
        length += 1;
    }

    public String getMax(){
        String result = "";
        for (int i = 0; i < length; i++) {
            if (result.length() < lines[i].length()){
                result = lines[i];
            }
        }
        return result;
    }

    public double getAverage(){
        int count = 0;
        for (int i = 0; i < length; i++) {
            count += lines[i].length();
        }
        if (length > 0)
            return count / length;
        return 0;
    }
}
