package com.matthem.mortgage;

import com.matthem.Console;

import java.text.NumberFormat;

public class MortgageReport {
    private MortgageCalculator calculator;
    private final NumberFormat currency;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = currency.format(mortgage);

        var buffer =  new StringBuffer()
                .append("\nMORTGAGE")
                .append("\n--------")
                .append("\nMonthly Payments: ")
                .append(mortgageFormatted);
        Console.writeString(buffer.toString());
    }

    public void printPaymentSchedule() {
        var buffer =  new StringBuffer()
                .append("\nPAYMENT SCHEDULE")
                .append("\n----------------")
                .append("\n");

        for (double balance : calculator.getRemainingBalances())
            buffer.append(currency.format(balance)).append("\n");

        Console.writeString(buffer.toString());
    }
}
