package springmain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CredentialService {

    @Value("${URL}")
    private String url;

    @Value("${username}")
    private String user;

    @Value("${password}")
    private String pass;

    public void showCredentials() {
        System.out.println("URL: " + url);
        System.out.println("Username: " + user);
        System.out.println("Password: " + pass);
    }
}
