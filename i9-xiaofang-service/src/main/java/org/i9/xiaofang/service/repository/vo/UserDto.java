package org.i9.xiaofang.service.repository.vo;

import lombok.Data;

@Data
public class UserDto extends PageListDto{

    private String phone;

    private String name;
}
