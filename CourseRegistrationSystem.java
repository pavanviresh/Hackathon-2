import java.util.Scanner;

class Student {
    private String studentName;
    private String rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;
    public Student(String studentName, String rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    public boolean checkEligibility() {
        return marks >= 50.0;
    }

    public double calculateFee() {
        return courseCredits * 1500.0;
    }

    public double calculateScholarship(double totalFee) {
        if (marks >= 85.0) {
            return totalFee * 0.20; // 20% scholarship
        } else if (marks >= 70.0 && marks <= 84.99) {
            return totalFee * 0.10; // 10% scholarship
        } else {
            return 0.0; // No scholarship
        }
    }

    public double calculateFinalFee() {
        double totalFee = calculateFee();
        double scholarship = calculateScholarship(totalFee);
        return totalFee - scholarship;
    }

    public void displayDetails() {
        System.out.println("\n--- Student Registration Details ---");
        System.out.println("Student Name   : " + studentName);
        System.out.println("Roll Number    : " + rollNumber);
        System.out.println("Marks Obtained : " + marks);
        System.out.println("Course Name    : " + courseName);
        System.out.println("Course Credits : " + courseCredits);
        
        boolean eligible = checkEligibility();
        System.out.println("Eligibility    : " + (eligible ? "Eligible" : "Not Eligible"));
        
        if (eligible) {
            double totalFee = calculateFee();
            double scholarship = calculateScholarship(totalFee);
            double finalFee = calculateFinalFee();
            
            System.out.println("Total Course Fee : Rs. " + totalFee);
            System.out.println("Scholarship Amt  : Rs. " + scholarship);
            System.out.println("Final Payable Fee: Rs. " + finalFee);
        }
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        String rollNumber = scanner.nextLine();

        System.out.print("Enter Marks Obtained (out of 100): ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter Course Credits: ");
        int courseCredits = scanner.nextInt();
        Student student = new Student(studentName, rollNumber, marks, courseName, courseCredits);
        if (student.checkEligibility()) {
            System.out.println("\n[Success] Student is eligible for course registration.");
            // Display details and fees using class methods
            student.displayDetails();
        } else {
            System.out.println("\n[Denied] Student is NOT eligible for course registration. Minimum required marks is 50.");
        }

        scanner.close();
    }
}