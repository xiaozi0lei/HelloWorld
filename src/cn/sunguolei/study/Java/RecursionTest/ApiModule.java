package src.cn.sunguolei.study.Java.RecursionTest;

import java.util.Date;

/**
 * @author GuoLei Sun
 * Date: 2018/11/27 10:08 AM
 */
public class ApiModule {
    private int id;
    private String name;
    private int parentId;
    private int grade;
    private int systemId;
    private Date createTime;
    // 模块层级，都好分隔
    private String modulePath;
    // 模块绑定的 host
    private String host;


    ////// 前端展示
    private String frontModulePath;
    // 前端系统名称
    private String frontSystemName;

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

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModulePath() {
        return modulePath;
    }

    public void setModulePath(String modulePath) {
        this.modulePath = modulePath;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getFrontModulePath() {
        return frontModulePath;
    }

    public void setFrontModulePath(String frontModulePath) {
        this.frontModulePath = frontModulePath;
    }

    public String getFrontSystemName() {
        return frontSystemName;
    }

    public void setFrontSystemName(String frontSystemName) {
        this.frontSystemName = frontSystemName;
    }
}
