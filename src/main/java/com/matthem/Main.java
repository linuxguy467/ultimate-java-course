package com.matthem;

import com.matthem.generics.GenericList;
import com.matthem.generics.Instructor;
import com.matthem.generics.User;
import com.matthem.generics.Utils;

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
//        int principal = (int) Console.readNumber("Principal ($1K - $1M): ", 1000, 1_000_000);
//        float annualInterest = (float) Console.readNumber("Annual Interest Rate: ", 1, 30);
//        byte years = (byte) Console.readNumber("Period (Years): ", 1, 30);
//
//        var calculator = new MortgageCalculator(principal, annualInterest, years);
//
//        var report = new MortgageReport(calculator);
//        report.printMortgage();
//        report.printPaymentSchedule();
        ///////////////////////////

        //////// Inheritance ///////////
//        var control = new TextBox();
//        control.disable();
//        System.out.println(control.isEnabled());
//        var box1 = new TextBox();
//        System.out.println(box1.toString());
//        var textBox = new TextBox();
//        textBox.setText("Hello World");
//        System.out.println(textBox);
//        var control = new UIControl(true);
//        var textBox = new TextBox();
//        show(control);
//        var point1 = new Point(1, 2);
//        var point2 = new Point(1, 2);
//        System.out.println(point1.hashCode());
//        System.out.println(point2.hashCode());
        ///////// Polymorphism //////////
//        UIControl[] controls = { new TextBox(), new CheckBox() };
//        for (var control : controls)
//            control.render();
        ///////////////////////////////
        ///////////////////////////////
        //////// Interfaces /////////////
//        var calculator = new TaxCalculator2018(100_000);
//        var report = new TaxReport();
//        report.show(calculator);

//        report.setCalculator(new TaxCalculator2019());
//        report.show(new TaxCalculator2019());
        ////////////////////////////////
        ///////////// MyTube ///////////////
//        var video = new Video();
//        video.setFileName("birthday.mp4");
//        video.setTitle("Jennifer's birthday");
//        video.setUser(new User("john@domain.com"));
//
//        var processor = new VideoProcessor(
//                new XVideoEncoder(),
//                new SqlVideoDatabase(),
//                new EmailService()
//        );
//        processor.process(video);
        ////////////////////////////////////
        ///////// Exceptions ///////////////
//        try {
//            ExceptionsDemo.show();
//        } catch (Throwable e) {
//            System.out.println("An unexpected error occurred.");
//        }
        ///////////////////////////////////
        ///////// Generics ///////////////
//        var list = new List();
//        list.add(1);
//        list.add("1");
//        list.add(new User());
//
//        int number = (int)list.get(1);

//        var list = new GenericList<Integer>();
//        list.add(1);
//        var number = list.get(0);
/*
        // int -> Integer
        // float -> Float
        // boolean -> Boolean

        GenericList<Float> numbers = new GenericList<>();
        numbers.add(1.2f); // Boxing
        float number = numbers.get(0); // Unboxing*/

//        new GenericList<User>();
//        var user1 = new User(10);
//        var user2 = new User(20);
//        if(user1.compareTo(user2) < 0)
//            System.out.println("user1 < user2");
//        else if(user1.compareTo(user2) == 0)
//            System.out.println("user1 == user2");
//        else System.out.println("user1 > user2");
//        var max = Utils.max(new User(10), new User(20));
//        System.out.println(max);
//        Utils.print(1, 10);
//        User user = new Instructor(10);
//        Utils.printUser(new Instructor(10));
        var instructors = new GenericList<Instructor>();
        Utils.printUsers(instructors);
        Utils.printUsers(new GenericList<User>());
        /////////////////////////////////
    }

//    public static void show(UIControl control) {
//        if(control instanceof TextBox textBox) {
//            textBox.setText("Hello World");
//        }
//        System.out.println(control);
//    }

//    public static int calculateWage(
//            int baseSalary,
//            int extraHours,
//            int hourlyRate
//    ) {
//        return baseSalary + (extraHours * hourlyRate);
//    }
}
