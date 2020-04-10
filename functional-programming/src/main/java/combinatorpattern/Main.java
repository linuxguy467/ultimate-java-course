package combinatorpattern;

import common.Customer;
import common.ValidationResult;

import static combinatorpattern.CustomerRegistrationValidator.*;
import static common.Gender.FEMALE;
import static java.time.Month.MARCH;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer.Builder("Alice")
                .withEmail("alice@gmail.com")
                .withGender(FEMALE)
                .withPhoneNumber("+087878787878")
                .withDOB(2000, MARCH, 4)
                .build();

//        System.out.println(new CustomerValidatorService().isValid(customer));

        // if valid we can store customer in db

        // Using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS)
            throw new IllegalStateException(result.name());
    }
}
