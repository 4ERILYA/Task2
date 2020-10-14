package com.company;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        double x1 = input("x1");
        double y1 = input("y1");
        double x2 = input("x2");
        double y2 = input("y2");
        double x3 = input("x3");
        double y3 = input("y3");
        double a = calculateSideLength(x1, x2, y1, y2);
        double b = calculateSideLength(x2, x3, y2, y3);
        double c = calculateSideLength(x1, x3, y1, y3);
        printData(a, b, c);
    }

    public static double calculateSideLength(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

    }

    public static String identifyTriangleType(double a, double c, double b) {
        if (compareLength(a, b, c)) {
            return "Equilateral Triangle";
        } else if (compareLengthV2(a, b, c)) {
            return "Isosceles Triangle";
        }
        return "Versatile Triangle";
    }

    private static boolean compareLength(double a, double c, double b) {
        return compareDouble(a, b) && compareDouble(a, c);
    }

    private static boolean compareLengthV2(double a, double c, double b) {
        return compareDouble(a, b) || compareDouble(a, c) || compareDouble(b, c);
    }

    public static boolean compareDouble(double a, double b) {
        return Math.abs(a - b) <= 0e-10;
    }

    public static double input(String value) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input your value " + value + " ");
        return scan.nextDouble();
    }

    public static String identifyAngleType(double a, double c, double b) {
        if (findCos(a, c, b) > 0) {
            return "Sharp angle";
        } else if (findCos(a, c, b) < 0) {
            return "Obtuse angle";
        }
        return "Right angle";
    }

    public static double findCos(double a, double b, double c) {
        return (Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / 2 * a * c;
    }

    public static String existsTriangle(double a, double b, double c) {
        if (noExistsTriangle(a, b, c)) {
            return "Triangle exists";
        }
        return "Triangle NaN";
    }

    private static boolean noExistsTriangle(double a, double b, double c) {
        return (a + b < c) || (a + c < b) || (b + c < a);
    }

    static void printData(double a, double b, double c) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(identifyTriangleType(a, c, b));
        System.out.println(identifyAngleType(a, c, b));
        System.out.println(existsTriangle(a, b, c));
    }
}
