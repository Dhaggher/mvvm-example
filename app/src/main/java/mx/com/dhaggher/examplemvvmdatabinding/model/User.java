package mx.com.dhaggher.examplemvvmdatabinding.model;

/**
 * Created by Gerardo Ramon on 3/17/19.
 */
public class User {
    private String email;
    private String pass;

    public User(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
