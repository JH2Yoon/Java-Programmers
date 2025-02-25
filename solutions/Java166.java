// 166. Java Priority Queue

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;

class Student implements Comparable<Student> {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public int compareTo(Student other) {
        if (this.grade != other.grade) {
            return Double.compare(other.grade, this.grade); 
        }
        return this.name.compareTo(other.name);
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        List<Student> students = new ArrayList<>();
        
        for (String event : events) {
            String[] eventDetails = event.split(" ");
            if (eventDetails[0].equals("ENTER")) {
                String name = eventDetails[1];
                double grade = Double.parseDouble(eventDetails[2]);
                pq.add(new Student(name, grade)); 
            } else if (eventDetails[0].equals("SERVED")) {
                if (!pq.isEmpty()) {
                    pq.poll();
                }
            }
        }
        
        while (!pq.isEmpty()) {
            students.add(pq.poll());
        }
        
        return students;
    }
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}