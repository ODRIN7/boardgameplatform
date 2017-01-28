package hu.odrin7.bga.domain;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Authority(Role role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role.name();
    }
}
