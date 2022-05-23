package org.example.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Operation {

    private long id;
    private String operation;
    private double num1;
    private double num2;
    private double result;
    private User user;

    public Operation(long id, String operation, double num1, double num2, double result, User user) {
        this.id = id;
        this.operation = operation;
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Operation)) return false;
        Operation operation1 = (Operation) o;
        return getId() == operation1.getId() && Double.compare(operation1.getNum1(), getNum1()) == 0 && Double.compare(operation1.getNum2(), getNum2()) == 0 && Double.compare(operation1.getResult(), getResult()) == 0 && getOperation().equals(operation1.getOperation()) && getUser().equals(operation1.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOperation(), getNum1(), getNum2(), getResult(), getUser());
    }
}
