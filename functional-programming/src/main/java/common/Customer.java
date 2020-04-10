package common;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
import java.util.Set;

public final class Customer extends Person {
    public static final class Builder extends Person.Builder {
        //        private String name;
//        private Gender gender;
        private String phoneNumber;
        private String email;
        private Set<CustomerItem> items;
        //private CustomerItem.ListBuilder itemListBuilder;

        public Builder() {
            super();
        }

        public Builder(String name) {
            super(name);
        }

        public Builder(String name, LocalDate dob) {
            super(name, dob);
        }

        @Override
        public Builder withDOB(int year, Month month, int dayOfMonth) {
            super.withDOB(year, month, dayOfMonth);
            return this;
        }

        @Override
        public Builder withDOB(LocalDate dob) {
            super.withDOB(dob);
            return this;
        }

        @Override
        public Builder withName(String name) {
            super.withName(name);
            return this;
        }

        @Override
        public Builder withGender(Gender gender) {
            super.withGender(gender);
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder withItems(Set<CustomerItem> items) {
            if (items.isEmpty())
                throw new IllegalArgumentException("Order needs to have at least 1 item");

            CustomerItem.ListBuilder itemListBuilder = new CustomerItem.ListBuilder(this);
            this.items = itemListBuilder.getItems();
            return this;
        }

        public CustomerItem.ListBuilder withItems() {
            return new CustomerItem.ListBuilder(this);
        }

        public Customer build() {
            return new Customer(this);
        }

        public void setItems(Set<CustomerItem> items) {
            this.items = items;
        }
    }

    private final Optional<String> email;
    private final String phoneNumber;
    private final Optional<Set<CustomerItem>> items;
    private boolean showPhoneNum = true;

    private Customer(Builder builder) {
        super(builder);
        this.email = Optional.ofNullable(builder.email);
        this.phoneNumber = builder.phoneNumber;
        this.items = Optional.ofNullable(builder.items);
    }

    public String getPhoneNumber() {
        return (showPhoneNum ? phoneNumber : "************");
    }

    public Optional<Set<CustomerItem>> getItems() {
        return items;
    }

    public Optional<String> getEmailOptional() {
        return email;
    }

    public String getEmail() {
        return email.orElse("email is not provided");
    }

    public void toggleShowPhoneNum() {
        showPhoneNum = !showPhoneNum;
    }
}