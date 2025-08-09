package springbootassi1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ClassKLM {

    @Autowired
    @Qualifier("classABC")  // or "classXYZ" if you want the other implementation
    InterfacePQR pqr;

    public void show() {
        pqr.display();
    }
}
