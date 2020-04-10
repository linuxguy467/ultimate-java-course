package common;

import java.util.HashSet;
import java.util.Set;

public final class CustomerItem {
    public static final class Builder {
        private long id;
        private String name;
        private CustomerItem.ListBuilder listBuilder;

        public Builder() {
            super();
        }

        public Builder(CustomerItem.ListBuilder listBuilder) {
            super();
            this.listBuilder = listBuilder;
        }

        public Builder withID(long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public CustomerItem build() {
            return new CustomerItem(this);
        }

        public CustomerItem.ListBuilder addToList() {
            this.listBuilder.addItem(build());
            return this.listBuilder;
        }
    }
    public static final class ListBuilder {
        private Set<CustomerItem> items = new HashSet<>();
        private Customer.Builder customerBuilder;

        public ListBuilder(Customer.Builder customerBuilder) {
            this.customerBuilder = customerBuilder;
        }

        public ListBuilder addItem(CustomerItem item) {
            this.items.add(item);
            return this;
        }

        public CustomerItem.Builder addItem() {
            return new CustomerItem.Builder(this);
        }

        public Customer.Builder buildItemList() {
            this.customerBuilder.setItems(items);
            return this.customerBuilder;
        }

        public Set<CustomerItem> getItems() {
            return items;
        }
    }

    private final long id;
    private final String name;

    private CustomerItem(CustomerItem.Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }
}
