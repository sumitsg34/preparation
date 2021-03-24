package org.learn.preparation.theory;


//Used when there are a lot parameters to be initialized
class Employee {
    private int id;
    private String name;
    // ..
    // ..
    // a lot of parameters

    private Employee(EmployeeBuilder employeeBuilder) {
        this.id = employeeBuilder.id;
        this.name = employeeBuilder.name;
    }

    public static class EmployeeBuilder {
        // keep all the params here as well
        private int id;
        private String name;

        public EmployeeBuilder id(int id) {
            this.id = id;
            return this;
        }

        public EmployeeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}

public class BuilderPattern {
}
