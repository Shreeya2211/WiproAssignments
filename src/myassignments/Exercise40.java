/* 40.Create a class called CD whose attributes are Title and singer.  Arrange the CDs in ascending 
order based on the singer name.(Use Comparable)
*/
package myassignments;

import java.util.*;

// CD class implementing Comparable
class CD implements Comparable<CD> {
    private String title;
    private String singer;

    public CD(String title, String singer) {
        this.title = title;
        this.singer = singer;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    // Sorting based on singer name in ascending order
    @Override
    public int compareTo(CD other) {
        return this.singer.compareToIgnoreCase(other.singer);
    }

    @Override
    public String toString() {
        return "CD [Title=" + title + ", Singer=" + singer + "]";
    }
}

public class Exercise40
{
    public static void main(String[] args)
    {
        List<CD> cdList = new ArrayList<>();
        cdList.add(new CD("Echoes", "Pink Floyd"));
        cdList.add(new CD("Thriller", "Michael Jackson"));
        cdList.add(new CD("25", "Adele"));
        cdList.add(new CD("Divide", "Ed Sheeran"));

        // Sort using Comparable (based on singer)
        Collections.sort(cdList);

        System.out.println("CDs sorted by Singer (Ascending):");
        for (CD cd : cdList)
        {
            System.out.println(cd);
        }
    }
}
/*
 * CDs sorted by Singer (Ascending):
CD [Title=25, Singer=Adele]
CD [Title=Divide, Singer=Ed Sheeran]
CD [Title=Thriller, Singer=Michael Jackson]
CD [Title=Echoes, Singer=Pink Floyd]
*/
