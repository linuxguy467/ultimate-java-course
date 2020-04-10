package common;

import java.time.*;

public class Person {
    public static class Builder {
        String name;
        LocalDate dob;
        Gender gender;

        public Builder() {}

        public Builder(String name) {
            this.name = name;
        }

        public Builder(String name, LocalDate dob) {
            this.name = name;
            this.dob = dob;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDOB(Month month, int day) {
            MonthDay date = MonthDay.of(month, day);
            return withDOB(date.atYear(Year.MIN_VALUE));
        }

        public Builder withDOB(int year, Month month) {
            YearMonth date = YearMonth.of(year, month);
            return withDOB(date.atDay(0));
        }

//        public Builder withDOB(int year, int month) {
//            YearMonth date = YearMonth.of(year, month);
//            return withDOB(date.atDay(0));
//        }

        public Builder withDOB(int year, Month month, int dayOfMonth) {
            return withDOB(LocalDate.of(year, month, dayOfMonth));
        }

//        public Builder withDOB(int year, int month, int dayOfMonth) {
//            return withDOB(LocalDate.of(year, month, dayOfMonth));
//            if(dob.isAfter(LocalDate.now()))
//                throw new IllegalArgumentException("Birth Date cannot be in the future");
//
//            this.dob = dob;
//            return this;
//        }

        public Builder withDOB(LocalDate dob) {
            if(dob.isAfter(LocalDate.now()))
                throw new IllegalArgumentException("Birth Date cannot be in the future");

            this.dob = dob;
            return this;
        }

        public Builder withGender(Gender gender) {
            this.gender = gender;
            return this;
        }
    }
    private final String name;
    private final LocalDate dob;
    private final Gender gender;

    Person(Builder builder) {
        this.name = builder.name;
        this.gender = builder.gender;
        this.dob = builder.dob;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    public String getName() {
        return name;
    }

    public LocalDate getDOB() {
        return dob;
    }

    public Gender getGender() {
        return gender;
    }
}

