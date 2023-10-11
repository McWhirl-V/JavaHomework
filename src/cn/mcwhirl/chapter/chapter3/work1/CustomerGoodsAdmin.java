package cn.mcwhirl.chapter.chapter3.work1;

import java.util.ArrayList;
import java.util.List;

public class CustomerGoodsAdmin {
    private List<Customer> customers = new ArrayList<>();

    public void show() {
        // Implement the user interaction interface here.
        // For example, prompt the user to input customer info, or print customer info.
    }

    public void inputCustomerInfo() {
        // Implement the logic for inputting customer info here.
    }

    public void print() {
        customers.forEach(Customer::print);
    }

    // You may need to add other methods as well.
}
