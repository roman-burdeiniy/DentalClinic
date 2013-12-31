package ua.com.dentalclinic.vo.base;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 12/30/13
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "user_roles", schema = "", catalog = "dentalclinicdb")
@Entity
public class UserRolesVO {
    private String username;

    @javax.persistence.Column(name = "username")
    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRolesVO that = (UserRolesVO) o;

        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return username != null ? username.hashCode() : 0;
    }

    private RolesVO rolesByRolename;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "rolename", referencedColumnName = "rolename")
    public RolesVO getRolesByRolename() {
        return rolesByRolename;
    }

    public void setRolesByRolename(RolesVO rolesByRolename) {
        this.rolesByRolename = rolesByRolename;
    }
}
