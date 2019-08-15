package io.github.cuprumz.pojo;

import javax.persistence.*;
import java.util.List;

/**
 * @author cuprumz
 * @date 2019/08/15
 */
@Entity
public class SysRole {
    @Id
    @GeneratedValue
    private Integer id;
    private String role;
    private String description;
    private Boolean available = Boolean.FALSE;

    @ManyToMany
    @JoinTable(name = "SysPermission", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private List<SysPermission> permissionList;

    @ManyToMany
    @JoinTable(name = "UserInfo", joinColumns = {@JoinColumn(name = "roleId")}, inverseJoinColumns = {@JoinColumn(name = "uid")})
    private List<UserInfo> userInfoList;

    public SysRole(String role, String description, Boolean available, List<SysPermission> permissionList, List<UserInfo> userInfoList) {
        this.role = role;
        this.description = description;
        this.available = available;
        this.permissionList = permissionList;
        this.userInfoList = userInfoList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<SysPermission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<SysPermission> permissionList) {
        this.permissionList = permissionList;
    }

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }
}
