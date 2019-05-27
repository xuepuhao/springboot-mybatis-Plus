package org.i9.xiaofang.service.repository.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDto extends PageListDto{

    private String phone;

    private String name;

}
