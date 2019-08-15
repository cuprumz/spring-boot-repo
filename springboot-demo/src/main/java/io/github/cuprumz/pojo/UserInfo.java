package io.github.cuprumz.pojo;

import javax.persistence.*;
import java.util.List;

/**
 * @author cuprumz
 * @date 2019/08/15
 */
@Entity
public class UserInfo implements java.io.Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue
    private Integer uid;
    @Column(unique = true)
    private String username;
    private String name;
    private String password;
    private String salt;
    private Byte state;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysUserRole", joinColumns = {@JoinColumn(name = "uid")}, inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> roleList;

    public UserInfo(String username, String name, String password, String salt, Byte state, List<SysRole> roleList) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.salt = salt;
        this.state = state;
        this.roleList = roleList;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }
}
