package pojo;

public class Role {
    private int roleId;
    private String roleName;
    private int roleSex;
    private String rolePhone;
    private String roleAddress;
    private String note;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleSex() {
        return roleSex;
    }

    public void setRoleSex(int roleSex) {
        this.roleSex = roleSex;
    }

    public String getRolePhone() {
        return rolePhone;
    }

    public void setRolePhone(String rolePhone) {
        this.rolePhone = rolePhone;
    }

    public String getRoleAddress() {
        return roleAddress;
    }

    public void setRoleAddress(String roleAddress) {
        this.roleAddress = roleAddress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleSex=" + roleSex +
                ", rolePhone='" + rolePhone + '\'' +
                ", roleAddress='" + roleAddress + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
