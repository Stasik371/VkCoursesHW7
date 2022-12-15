/*
 * This file is generated by jOOQ.
 */
package generated.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Integer userId;
    private final Integer roleId;

    public UserRoles(UserRoles value) {
        this.userId = value.userId;
        this.roleId = value.roleId;
    }

    public UserRoles(
        Integer userId,
        Integer roleId
    ) {
        this.userId = userId;
        this.roleId = roleId;
    }

    /**
     * Getter for <code>public.user_roles.user_id</code>.
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * Getter for <code>public.user_roles.role_id</code>.
     */
    public Integer getRoleId() {
        return this.roleId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final UserRoles other = (UserRoles) obj;
        if (this.userId == null) {
            if (other.userId != null)
                return false;
        }
        else if (!this.userId.equals(other.userId))
            return false;
        if (this.roleId == null) {
            if (other.roleId != null)
                return false;
        }
        else if (!this.roleId.equals(other.roleId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.userId == null) ? 0 : this.userId.hashCode());
        result = prime * result + ((this.roleId == null) ? 0 : this.roleId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UserRoles (");

        sb.append(userId);
        sb.append(", ").append(roleId);

        sb.append(")");
        return sb.toString();
    }
}
