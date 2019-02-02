package src.cn.sunguolei.study.Java.RecursionTest;

import java.util.Date;

/**
 * @author GuoLei Sun
 * Date: 2018/11/27 10:09 AM
 */
public class ApiSystem {
    private int id;
    private String name;
    private Date createTime;

    // 系统权限组英文名，不入库，编辑后存入角色表
    private String systemRole;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSystemRole() {
        return systemRole;
    }

    public void setSystemRole(String systemRole) {
        this.systemRole = systemRole;
    }
}
