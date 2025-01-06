package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        Employee employee1 = new Employee(123456789, "Atakan", "Kurnaz");
        Employee employee2 = new Employee(123456780, "Ahmet", "Kurnaz");
        Employee employee3 = new Employee(123456789, "Atakan", "Kurnaz");
        Employee employee4 = new Employee(123456781, "Mehmet", "Yılmaz");
        Employee employee5 = new Employee(123456782, "Ayşe", "Demir");

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        List<Employee> duplicates = findDuplicates(employees);
        System.out.println("Duplicates:");
        for (Employee employee : duplicates) {
            System.out.println(employee.getFirstname() + " " + employee.getLastname());
        }

        Map<Integer, Employee> uniqueMap = findUniques(employees);
        System.out.println("\nUnique Employees Map:");
        for (Map.Entry<Integer, Employee> entry : uniqueMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue().getFirstname() + " " + entry.getValue().getLastname());
        }

        List<Employee> nonDuplicates = removeDuplicates(employees);
        System.out.println("\nEmployees without duplicates:");
        for (Employee employee : nonDuplicates) {
            System.out.println(employee.getFirstname() + " " + employee.getLastname());
        }
    }

    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Employee> seen = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();

        for (Employee employee : list) {
            if (!seen.add(employee)) {
                duplicates.add(employee);
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> uniqueMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Employee employee : list) {
            if (employee != null) {
                countMap.put(employee.getId(), countMap.getOrDefault(employee.getId(), 0) + 1);
            }
        }

        for (Employee employee : list) {
            if (employee != null && countMap.get(employee.getId()) == 1) {
                uniqueMap.put(employee.getId(), employee);
            }
        }

        return uniqueMap;
    }




    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Employee> nonDuplicates = new LinkedList<>();

        for (Employee employee : list) {
            if (employee != null) {
                countMap.put(employee.getId(), countMap.getOrDefault(employee.getId(), 0) + 1);
            }
        }

        for (Employee employee : list) {
            if (employee != null && countMap.get(employee.getId()) == 1) {
                nonDuplicates.add(employee);
            }
        }

        return nonDuplicates;
    }
}
