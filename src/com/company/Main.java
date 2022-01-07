package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.println("Input a number of credit card: ");
       long number = input.nextLong();
        System.out.println(number+" is "+(isValid(number) ? "valid" : "invalid"));




    }
    public static boolean isValid (long number) {
        return (getSize(number) >= 13 && getSize(number)<=16 &&
                (prefixMatched(number,4) || prefixMatched(number,5)
                || prefixMatched(number, 37) || prefixMatched(number, 37)) &&
                ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 ==0)

        );
    }


    public static int getDigit(int number){
        if (number > 9)
            return number % 10 + number / 10;
        return number;

    }

    public static int getSize(long d) {
        String num = d + "";
        return num.length();
    }

    public static long getPrefix(long number, int k) {
        if (getSize(number) > k) {
            String num = number + "";
            return Long.parseLong(num.substring(0,k));
        }
        return number;
    }

    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }


    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number) - 2; i>=0; i-=2)
            sum+=getDigit(Integer.parseInt(num.charAt(i) + "")*2);

        return sum;

    }

    public static int sumOfOddPlace(long number) {
        int sum = 0;
        String num = number + "";
        for (int i = getSize(number)-1; i >= 0; i-=2)
            sum+=Integer.parseInt(num.charAt(i) + "");
        return sum;
    }





}
