package myjavademos;

/* 13. Create a class called Worker. Write classes DailyWorker and SalariedWorker that inherit from
Worker. Every worker has a name and a salaryrate. Write method Pay (int hours) to compute 
the week pay of every worker.  A Daily worker is paid on the basis of the number of days 
she/he works. The salaried worker gets paid the wage for 40 hours a week no matter what the
actual hours are.  Test this program to calculate the pay of workers. 
    */
// Base class
class Worker
{
    protected String name;
    protected double salaryRate;

    public Worker(String name, double rate)
    {
        this.name = name;
        this.salaryRate = rate;
    }

    public double pay(int hours)
    {
        return 0; // to be overridden in subclasses
    }

    public void displayPay(int hours)
    {
        System.out.println("Name: " + name);
        System.out.println("Pay for the week: ₹" + pay(hours));
        System.out.println();
    }
}

// Subclass for daily worker
class DailyWorker extends Worker
{
    public DailyWorker(String name, double rate)
    {
        super(name, rate);
    }

    public double pay(int hours)
    {
        return salaryRate * hours;
    }
}

// Subclass for salaried worker
class SalariedWorker extends Worker
{
    public SalariedWorker(String name, double rate)
    {
        super(name, rate);
    }

    public double pay(int hours)
    {
        return salaryRate * 40; // fixed 40-hour pay
    }
}


public class Exercise13
{
    public static void main(String[] args)
    {
        
        DailyWorker daily = new DailyWorker("Ravi", 500);
        SalariedWorker salaried = new SalariedWorker("Anita", 400);

       
        daily.displayPay(45);     // worked 45 hours
        salaried.displayPay(30);  // worked 30 hours, still paid for 40
    }
}
/*
Name: Ravi
Pay for the week: ₹22500.0

Name: Anita
Pay for the week: ₹16000.0
*/