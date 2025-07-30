package myjavademos;
/* 12.Create a class called Student with the following details: RollNo, StudName, MarksInEng, 
 MarksInMaths and MarksInScience. Write getters and setters for the all variables. RollNo should be automatically generated whenever a new student is added.
Create a class called Standard with 8 students’ details and write separate method for each of 
the following tasks and invoke the same.
1. To display the entire roll no and the name of the students in the class in the ascending order of roll no.
2. To display the roll no and the name of the student who has got the highest percentage.
3. To display the roll no and the name of the student who scored highest mark 
in mathematics.
4. To display the roll no and the name of the student in the ascending order of the total marks in mathematics and science alone.
5. To display the roll no, name, total marks, percentage and rank of all the students in the descending order of rank.
 */
class Student {
    private static int rollCounter = 1;

    private int rollNo;
    private String studName;
    private int marksInEng;
    private int marksInMaths;
    private int marksInScience;

    public Student(String name, int eng, int maths, int science) {
        this.rollNo = rollCounter++;
        this.studName = name;
        this.marksInEng = eng;
        this.marksInMaths = maths;
        this.marksInScience = science;
    }

    // Getters
    public int getRollNo() 
    { 
    	return rollNo;
    }
    public String getStudName() 
    { 
    	return studName; 
    }
    public int getMarksInEng() 
    { 
    	return marksInEng; 
    }
    public int getMarksInMaths() 
    { 
    	return marksInMaths; 
    }
    public int getMarksInScience() 
    { 
    	return marksInScience;
    }

    public int getTotalMarks()
    {
        return marksInEng + marksInMaths + marksInScience;
    }

    public double getPercentage()
    {
        return getTotalMarks() / 3.0;
    }
}

class Standard 
{
    Student[] students = new Student[8];
    int index = 0;

    public void addStudent(Student s)
    {
        if (index < 8)
        {
            students[index++] = s;
        }
    }

    // 1. Display all students in ascending order of roll no
    public void displayByRollNo()
    {
        System.out.println("1. Students by Roll No:");
        for (int i = 0; i < index - 1; i++)
        {
            for (int j = i + 1; j < index; j++)
            {
                if (students[i].getRollNo() > students[j].getRollNo())
                {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        for (int i = 0; i < index; i++)
        {
            System.out.println("Roll No: " + students[i].getRollNo() + ", Name: " + students[i].getStudName());
        }
    }

    // 2. Student with highest percentage
    public void displayTopperByPercentage()
    {
        double max = 0;
        int pos = 0;
        for (int i = 0; i < index; i++)
        {
            if (students[i].getPercentage() > max)
            {
                max = students[i].getPercentage();
                pos = i;
            }
        }
        System.out.println("2. Topper by Percentage: Roll No: " + students[pos].getRollNo() + ", Name: " + students[pos].getStudName());
    }

    // 3. Student with highest maths mark
    public void displayTopperInMaths()
    {
        int max = 0;
        int pos = 0;
        for (int i = 0; i < index; i++)
        {
            if (students[i].getMarksInMaths() > max)
            {
                max = students[i].getMarksInMaths();
                pos = i;
            }
        }
        System.out.println("3. Topper in Maths: Roll No: " + students[pos].getRollNo() + ", Name: " + students[pos].getStudName());
    }

    // 4. Sort by (Maths + Science)
    public void displayByMathsAndScience()
    {
        System.out.println("4. Students sorted by Maths + Science:");
        for (int i = 0; i < index - 1; i++)
        {
            for (int j = i + 1; j < index; j++)
            {
                int total1 = students[i].getMarksInMaths() + students[i].getMarksInScience();
                int total2 = students[j].getMarksInMaths() + students[j].getMarksInScience();
                if (total1 > total2)
                {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        for (int i = 0; i < index; i++)
        {
            System.out.println("Roll No: " + students[i].getRollNo() + ", Name: " + students[i].getStudName());
        }
    }

    // 5. Display rank list (descending by total marks)
    public void displayRankList() {
        System.out.println("5. Rank List:");
        for (int i = 0; i < index - 1; i++)
        {
            for (int j = i + 1; j < index; j++)
            {
                if (students[i].getTotalMarks() < students[j].getTotalMarks())
                {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        for (int i = 0; i < index; i++)
        {
            System.out.printf("Rank %d: Roll No: %d, Name: %s, Total: %d, Percentage: %.2f%%\n",
                i + 1,
                students[i].getRollNo(),
                students[i].getStudName(),
                students[i].getTotalMarks(),
                students[i].getPercentage());
        }
    }
}

public class Exercise12
{
    public static void main(String[] args)
    {
        Standard std = new Standard();

        std.addStudent(new Student("Alice", 80, 90, 85));
        std.addStudent(new Student("Bob", 75, 85, 78));
        std.addStudent(new Student("Charlie", 92, 89, 93));
        std.addStudent(new Student("David", 60, 65, 58));
        std.addStudent(new Student("Eve", 88, 72, 84));
        std.addStudent(new Student("Frank", 70, 67, 69));
        std.addStudent(new Student("Grace", 91, 95, 94));
        std.addStudent(new Student("Hannah", 94, 98, 96));

        System.out.println();
        std.displayByRollNo();

        System.out.println();
        std.displayTopperByPercentage();

        System.out.println();
        std.displayTopperInMaths();

        System.out.println();
        std.displayByMathsAndScience();

        System.out.println();
        std.displayRankList();
    }
}
/*

1. Students by Roll No:
Roll No: 1, Name: Alice
Roll No: 2, Name: Bob
Roll No: 3, Name: Charlie
Roll No: 4, Name: David
Roll No: 5, Name: Eve
Roll No: 6, Name: Frank
Roll No: 7, Name: Grace
Roll No: 8, Name: Hannah

2. Topper by Percentage: Roll No: 8, Name: Hannah

3. Topper in Maths: Roll No: 8, Name: Hannah

4. Students sorted by Maths + Science:
Roll No: 4, Name: David
Roll No: 6, Name: Frank
Roll No: 5, Name: Eve
Roll No: 2, Name: Bob
Roll No: 1, Name: Alice
Roll No: 3, Name: Charlie
Roll No: 7, Name: Grace
Roll No: 8, Name: Hannah

5. Rank List:
Rank 1: Roll No: 8, Name: Hannah, Total: 288, Percentage: 96.00%
Rank 2: Roll No: 7, Name: Grace, Total: 280, Percentage: 93.33%
Rank 3: Roll No: 3, Name: Charlie, Total: 274, Percentage: 91.33%
Rank 4: Roll No: 1, Name: Alice, Total: 255, Percentage: 85.00%
Rank 5: Roll No: 5, Name: Eve, Total: 244, Percentage: 81.33%
Rank 6: Roll No: 2, Name: Bob, Total: 238, Percentage: 79.33%
Rank 7: Roll No: 6, Name: Frank, Total: 206, Percentage: 68.67%
Rank 8: Roll No: 4, Name: David, Total: 183, Percentage: 61.00%
*/