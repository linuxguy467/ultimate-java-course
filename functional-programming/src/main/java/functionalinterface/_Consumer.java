package functionalinterface;

import common.Customer;

import java.time.LocalDate;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer maria = new Customer.Builder()
                .withDOB(LocalDate.now())
                .withName("Maria")
                .withPhoneNumber("99999")
                .withItems()
                    .addItem().withID(1).withName("Pringles").addToList()
                    .addItem().withID(2).withName("Lays").addToList()
                    .buildItemList()
                .build();

        maria.toggleShowPhoneNum();

        // Java Method
        greetCustomer(maria);
        greetCustomerV2(maria, false);

        // Consumer Functional Interface
        greetCustomerConsumer.accept(maria);

        greetCustomerConsumerV2.accept(maria, false);
    }

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNum) ->
            System.out.println("Hello " + customer.getName() +
                    ", thanks for registering phone number "
                    + customer.getPhoneNumber());

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.getName() +
                    ", thanks for registering phone number "
                    + customer.getPhoneNumber());

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.getName() +
                ", thanks for registering phone number "
                + customer.getPhoneNumber());
    }

    static void greetCustomerV2(Customer customer, boolean showPhoneNum) {
        System.out.println("Hello " + customer.getName() +
                ", thanks for registering phone number "
                + customer.getPhoneNumber());
    }
}
