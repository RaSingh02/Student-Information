import java.util.ArrayList;

/**
 * This class represents a student in a class.
 * 
 * @author Randeep Singh
 * @version CS120 Lab 8
 */
public class Student
{
    //Student's first name
    private String firstName;

    //Student's last name
    private String lastName;

    //Student's grades in the class
    private ArrayList<Integer> grades;

    /**
     * Construct a new Student object with the input first and last name.
     * Creates the student's grade list, with no grades.
     * 
     * @param firstName The student's first name.
     * @param lastName The student's last name.
     */
    public Student(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        grades = new ArrayList<Integer>();
    }

    /**
     * Returns the student's first name.
     * 
     * @return The student's first name.
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Returns the student's last name.
     * 
     * @return The student's last name.
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Adds the grade to the student's list of grades.
     * 
     * @param grade An integer in [0, 100].  Sorry, no bonus points.
     */
    public void addGrade(Integer grade)
    {
        if (grade >= 0 && grade <= 100)
        {
            grades.add(grade);
        }
        else 
        {
            System.out.println("Input a grade that is within [0,100]");
        }
    }

    /**
     * Removes the first occurance of the grade in the student's list
     * of grades.
     * 
     * @param grade The grade to be removed.
     * @return True if the grade was found and removed and false otherwise.
     */
    public boolean removeGrade(Integer grade)
    {
        if (grades.contains(grade))
        {
            grades.remove(grade);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * This method removes the student's lowest grade for his or her
     * list of grades.  However, grades of zero are not removed.
     * 
     * @return The grade removed or -1 if no grade was removed.
     */
    public int dropLowestNotZero()
    {
        int minGrade = 101;
        for (Integer grade : grades)
        {
            if (grade < minGrade && grade != 0)
            {
                minGrade = grade;
            }
        }
        if (minGrade != 101){
            grades.remove(grades.indexOf(minGrade));
            return minGrade;
        }
        else
        {   
            return -1;
        }

    }

    /**
     * This method returns the average of the student's grades.
     * 
     * @return The average of the student's grades.  If the student
     *         has no grades, -1 is returned.
     */
    public double getAverage()

    {
        double avg = 0;
        double count = 0;
        if (grades.size() == 0)
        {
            return -1;   
        }
        for (Integer grade : grades)
        {
            avg = avg + grade;
            count++;
        }   
        avg = avg / count;
        return avg;
    }

    /**
     * This method retuns a description of the student in the format
     * 
     * last name, first name:
     * list of grades separated by spaces
     * 
     * @return A description of the student including name and grade list.
     */
    @Override
    public String toString()
    {
        String student= lastName + ", " + firstName + ":\n";

        for (Integer grade : grades){
            student += (grade + " " );
        }
        return student;   
    }

}

