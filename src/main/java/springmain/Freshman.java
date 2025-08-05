package springmain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Freshman {

    private String name;

    // Option 1: Autowired directly
    // @Autowired
    // private DormRoom room;

    // Option 2: Autowired with Qualifier
    @Autowired
    @Qualifier("roomB")
    private DormRoom room;

    public Freshman()
    {
        this.name = "Arjun";
    }

    public void showInfo()
    {
        System.out.println("Freshman Name: " + name);
        System.out.println("Assigned Room: " + room.getLocation());
    }
}
