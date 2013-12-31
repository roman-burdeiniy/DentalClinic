package ua.com.dentalclinic.vo.base;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 12/30/13
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "roles", schema = "", catalog = "dentalclinicdb")
@Entity
public class RolesVO {
    private String rolename;
    private Collection<UserRolesVO> userRolesesByRolename;

    @javax.persistence.Column(name = "rolename")
    @Id
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolesVO rolesVO = (RolesVO) o;

        if (rolename != null ? !rolename.equals(rolesVO.rolename) : rolesVO.rolename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return rolename != null ? rolename.hashCode() : 0;
    }

    @OneToMany(mappedBy = "rolesByRolename")
    public Collection<UserRolesVO> getUserRolesesByRolename() {
        return userRolesesByRolename;
    }

    public void setUserRolesesByRolename(Collection<UserRolesVO> userRolesesByRolename) {
        this.userRolesesByRolename = userRolesesByRolename;
    }
}
