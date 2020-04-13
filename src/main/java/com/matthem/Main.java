package com.matthem;

import com.matthem.mortgage.MortgageCalculator;
import com.matthem.mortgage.MortgageReport;

public class Main {
    public static void main(String[] args) {

        ////// Creating Objects ///////////
//        var textBox1 = new TextBox();
//        textBox1.setText("Box 1");
//        System.out.println(textBox1.text.toUpperCase());
//
//        var textBox2 = new TextBox();
//        textBox2.setText("Box 2");
//        System.out.println(textBox2.text);
        /////////////////////////////////////

        /////// Memory Allocation ///////////
//        var textBox1 = new TextBox();
//        var textBox2 = textBox1;
//        textBox2.setText("Hello World");
//        System.out.println(textBox1.text);
        /////////////////////////////////////

        //////// Procedural Programming ///////
//        int baseSalary = 50_000;
//        int extraHours = 10;
//        int hourlyRate = 20;
//
//        int wage = calculateWage(baseSalary, extraHours, hourlyRate);
//        System.out.println(wage);
        ///////////////////////////////////////

//        var employee = new Employee(
//                50_000, 20);
//        Employee.printNumberOfEmployees();
//        employee.setBaseSalary(50_0000);
//        employee.setHourlyRate(20);
//        System.out.println(employee.getBaseSalary());
//        int wage = employee.calculateWage(0);
//        System.out.println(wage);

        //////// Mortgage ////////
        int principal = (int) Console.readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);

        var calculator = new MortgageCalculator(principal, annualInterest, years);

        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
        /////////////////////////
    }

//    public static int calculateWage(
//            int baseSalary,
//            int extraHours,
//            int hourlyRate
//    ) {
//        return baseSalary + (extraHours * hourlyRate);
//    }
}
