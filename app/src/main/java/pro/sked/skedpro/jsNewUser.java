package pro.sked.skedpro;

/**
 * Created by Bondint on 23.10.2016.
 */

public class jsNewUser {
    String login, password, email, name;

    public jsNewUser(String login, String password, String email, String name){
        super();
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }

}
