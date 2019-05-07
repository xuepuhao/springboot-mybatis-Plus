package org.i9.xiaofang.service.repository.vo;

import java.util.Date;

/**
 * 后台管理员Dto
* @ClassName: ManagerSearchDto
* @author xph
* @date 2018年11月8日
 */
public class ManagerSearchDto extends PageListDto{
	private String username;

    private String password;

    private String name;

    private Date createtime;
    
    private String orderByClause;
    
    private String startTime;
    
    private String endTime;
    
    private String phone;
    
	public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

}
