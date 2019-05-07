package org.i9.xiaofang.service.repository.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

public class LoginForm implements Serializable {

    /**
	 * 版本号
	 */
	private static final long serialVersionUID = 4255180695536365561L;

	/**
     * 电话
     *//*
    @NotBlank(message = "电话号码不能为空") 
    @Pattern(regexp = "^1[3|4|5|6|7|8][0-9]\\d{8}$", message = "请输入正确的手机号")
    private String phone;*/
    
    @NotBlank(message = "用户名不能为空")
    @Length(min = 5, max = 20, message = "账号在5-20字符之间")
    private String username;
    
    @NotBlank(message = "密码不能为空")
    @Length(min = 5, max = 20, message = "密码在5-20字符之间")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LoginForm() {
		super();
	}

	public LoginForm(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
}

