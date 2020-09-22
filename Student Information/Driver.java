
/**
 * This driver is provided to test the implementation of the Section and Student classes.  However, this does not
 * guarantee full correctness of either class implementation.
 * 
 * @author Mrs. White 
 * @version Spring 2019
 */
public class Driver
{
    public static void main(String args[])
    {
        Section sec1 = new Section("CSIS", "120", "01");
        System.out.println("Section.getDepartment\nExpected:  CSIS\nReceived:  " + sec1.getDepartment());
        System.out.println("\nSection.getCourseNumber\nExpected:  120\nReceived:  " + sec1.getCourseNumber());
        System.out.println("\nSection.getSectionNumber\nExpected:  01\nReceived:  " + sec1.getSectionNumber());
        System.out.println("\nSection.getCourseName\nExpected:  CSIS-120-01\nReceived:  " + sec1.getSectionName());

        Student student = new Student("John", "Appleseed");
        System.out.println("\ngetFirstName\nExpected:  John\nReceived:  " + student.getFirstName());
        System.out.println("\ngetLastName\nExpected:  Appleseed\nReceived:  " + student.getLastName());

        student.addGrade(100);
        student.addGrade(80);
        student.addGrade(95);
        student.addGrade(0);
        student.addGrade(80);
        student.addGrade(65);
        System.out.println("\nStudent.toString\nExpected:  Appleseed, John:\n100 80 95 0 80 65\nReceived:  " + student.toString());
        System.out.println("\nStudent.getAverage\nExpected:  70.0\nReceived:  " + student.getAverage());

        student.removeGrade(80);
        student.dropLowestNotZero();
        System.out.println("\nStudent.toString\nExpected:  Appleseed, John:\n100 95 0 80\nReceived:  " + student.toString());
        System.out.println("\nStudent.getAverage\nExpected:  68.75\nReceived:  " + student.getAverage());
        student.getAverage();

        sec1.addStudent(student);

        student = new Student("Parker", "Grey");
        System.out.println("\ngetFirstName\nExpected:  Parker\nReceived:  " + student.getFirstName());
        System.out.println("\ngetLastName\nExpected:  Grey\nReceived:  " + student.getLastName());

        student.addGrade(80);
        student.addGrade(90);
        student.addGrade(100);
        student.addGrade(90);
        student.addGrade(100);
        student.addGrade(100);
        System.out.println("\nStudent.toString\nExpected:  Grey, Parler:\n80 90 100 90 100 100\nReceived:  " + student.toString());
        System.out.println("\nStudent.getAverage\nExpected:  93.33333333333333\nReceived:  " + student.getAverage());

        student.removeGrade(80);
        student.dropLowestNotZero();
        System.out.println("\nStudent.toString\nExpected:  Grey, Parker:\n100 90 100 100\nReceived:  " + student.toString());
        System.out.println("\nStudent.getAverage\nExpected:  97.5\nReceived:  " + student.getAverage());
        student.getAverage();

        sec1.addStudent(student);
        System.out.println("\nSection.toString\nExpected: CSIS-120-01\nAppleseed, John:\n100 95 0 80\nGrey, Parker:\n100 90 100 100\nReceived:  " + sec1.toString());

        System.out.println("Section.getClassAverage\nExpected: 83.125\nReceived:  " + sec1.getClassAverageGrade());

        sec1.dropStudent(sec1.getStudent("John", "Appleseed"));
        System.out.println("\nSection.toString\nExpected: CSIS-120-01\nGrey, Parker:\n100 90 100 100\nReceived:  " + sec1.toString());

        System.out.println("Section.getStudent\nExpected: null\nReceived:  " + sec1.getStudent("Pauline", "White"));
        student = new Student("Pauline", "White");
        System.out.println("\nSection.dropStudent\nExpected: null\nReceived:  " + sec1.dropStudent(student));

        sec1.dropStudent(sec1.getStudent("Parker", "Grey"));
        System.out.println("\nSection.toString\nExpected: CSIS-120-01\nReceived:  " + sec1.toString());        
    }
}
