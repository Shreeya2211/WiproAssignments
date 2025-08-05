/* 36.Create a class called Tank that can be filled and emptied, and has a
termination condition that it must be releaseTank when the object is cleaned up. Write a
finalize( ) that verifies this termination condition. In main( ), test the possible scenarios
that can occur when your Tank is used.
*/
package myassignments;

class Tank {
    private boolean isFull = false;
    private boolean isReleased = false;

    // Fill the tank
    public void fillTank()
    {
        if (!isFull)
        {
            isFull = true;
            System.out.println("Tank is filled.");
        } else
        {
            System.out.println("Tank is already full.");
        }
    }

    // Empty the tank
    public void emptyTank() {
        if (isFull) {
            isFull = false;
            System.out.println("Tank is emptied.");
        } else {
            System.out.println("Tank is already empty.");
        }
    }

    // Release resources (termination condition)
    public void releaseTank()
    {
        isReleased = true;
        System.out.println("Tank is released properly.");
    }

    @SuppressWarnings("removal")
	@Override
    protected void finalize() throws Throwable
    {
        if (!isReleased)
        {
            System.out.println("Warning: Tank was not released before garbage collection!");
        } else {
            System.out.println("Tank finalized safely.");
        }
        super.finalize();
    }
}

public class Exercise36
{
    public static void main(String[] args)
    {
        // Case 1: Proper usage
        Tank t1 = new Tank();
        t1.fillTank();
        t1.emptyTank();
        t1.releaseTank();

        // Case 2: Tank not released before object becomes unreachable
        Tank t2 = new Tank();
        t2.fillTank();

        t2 = null;  // Eligible for GC

        // Suggest garbage collection (no guarantee it runs immediately)
        System.gc();

        
    }
}
/*
Tank is filled.
Tank is emptied.
Tank is released properly.
Tank is filled.
Warning: Tank was not released before garbage collection!
*/