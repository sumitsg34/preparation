package org.learn.preparation.theory;

import java.util.*;

// Immutable classes are String and all wrapper classes
// e.g String, Integer, Long etc
// to make any class immutable, check below 7 points

//1. final class, so no child class will be created
final class Emp {

    private final int id; //2. making it final so that constructor makes it mandatory to init it
    private final Long salary;
    private final List<Integer> phones;

    //3. define a constructor, so that the default constructor will be overridden
    public Emp(int id, Long salary, List<Integer> inputPhones) {
        this.id = id;
        this.salary = salary;
        //4. here make a deep copy of the data members so that its value can't be update via reference
        List<Integer> copyOfPhones = new ArrayList<>();
        Collections.copy(copyOfPhones, inputPhones);
        // now, by changing the values of objects in inputPhones var, the values of inside object won't change
        this.phones = copyOfPhones;
    }

    public List<Integer> getPhones() {
        //5. never return the actual reference of the data memeber
        List<Integer> copyOfPhones = new ArrayList<>();
        Collections.copy(copyOfPhones, this.phones);
        return copyOfPhones;
    }

    //6. most importantly no setters at all


    //7. no need to deep copy immutable data members
    public Long getSalary() {
        return salary;
    }
}

public class ImmutableClasses {

    public static void main(String[] args) {

        Emp emp = new Emp(1, 10000l, new ArrayList<>());
        Long sal = emp.getSalary();
        sal = 20000l;
        System.out.println(sal == emp.getSalary());

        //Developer developer = new Developer(2, new ArrayList<>());
        String first = "first";
        String another = "first";

        System.out.println("first == another ? " + (first == another));

        // this will create two different string due to NEW operator
        String second = new String("second");
        String second_string = new String("second");

        System.out.println("second_string == second ? " + (second_string == second));

        Integer myInt = 5;
        Integer anotherInt = 5;

        System.out.println("myInt == anotherInt ? " + (myInt == anotherInt));

        Integer integer = new Integer(5);
        Integer oneMoreInt = new Integer(5);
        System.out.println("integer == oneMoreInt ? " + (integer == oneMoreInt));

    }

}
