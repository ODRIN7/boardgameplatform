package hu.odrin7.bga.domain.user;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.List;
//todo notUsed
public class User {

    @NotNull
    @Length(min = 3, max = 20)
    private String username;

    @NotNull
    @Length(min = 6, max = 40)
    private String password;

    private List<Role> authority;

    public User() {
    }

    public User(String username, String password, List<Role> authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getAuthority() {
        return authority;
    }

    public void setAuthority(List<Role> authority) {
        this.authority = authority;
    }
}
