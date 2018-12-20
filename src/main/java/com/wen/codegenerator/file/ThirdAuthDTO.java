package com.wen.codegenerator.file;

/**
*
*
* @author
* @date 2018-11-16 10:25:23
*/
public class ThirdAuthDTO {
    // PK
    private String id;
    // appid
    private String appid;
    // 第三方名称
    private String name;
    // 密码
    private String secret_key;
    // 第三方类型(0表示第三方物业管理应用，1表示第三方数据应用)
    private Integer type;
    // 删除标志(0-逻辑未删除，1-逻辑已删除)
    private Boolean deletec;
    // 备注 
    private String remark;
    // 创建时间，时间的格式为：20171208101009，默认值为：0；数据产生时，创建时间=修改时间
    private Long create_time;
    // 更新时间，时间的格式为：20171208101009，默认值为：0；数据产生时，创建时间=修改时间
    private Long update_time;

    public String getId() {
    return id;
    }

    public void setId(String id) {
    this.id = id;
    }

    public String getAppid() {
    return appid;
    }

    public void setAppid(String appid) {
    this.appid = appid;
    }

    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }

    public String getSecret_key() {
    return secret_key;
    }

    public void setSecret_key(String secret_key) {
    this.secret_key = secret_key;
    }

    public Integer getType() {
    return type;
    }

    public void setType(Integer type) {
    this.type = type;
    }

    public Boolean getDeletec() {
    return deletec;
    }

    public void setDeletec(Boolean deletec) {
    this.deletec = deletec;
    }

    public String getRemark() {
    return remark;
    }

    public void setRemark(String remark) {
    this.remark = remark;
    }

    public Long getCreate_time() {
    return create_time;
    }

    public void setCreate_time(Long create_time) {
    this.create_time = create_time;
    }

    public Long getUpdate_time() {
    return update_time;
    }

    public void setUpdate_time(Long update_time) {
    this.update_time = update_time;
    }


}
