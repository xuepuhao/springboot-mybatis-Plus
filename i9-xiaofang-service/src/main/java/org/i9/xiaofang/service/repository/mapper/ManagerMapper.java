package org.i9.xiaofang.service.repository.mapper;

import org.apache.ibatis.annotations.Param;
import org.i9.xiaofang.service.repository.model.Manager;
import org.i9.xiaofang.service.repository.model.ManagerExample;
import org.i9.xiaofang.service.repository.vo.ManagerSearchDto;

import java.util.List;

public interface ManagerMapper {
    int countByExample(@Param("example") ManagerSearchDto managerSearchDto);

    int deleteByExample(ManagerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Manager record);

    int insertSelective(Manager record);

    List<Manager> selectByExample(ManagerExample example);

    Manager selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Manager record, @Param("example") ManagerExample example);

    int updateByExample(@Param("record") Manager record, @Param("example") ManagerExample example);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);

    Manager getManagerByName(String username);

    List<Manager> selectBylimitPage(@Param("example") ManagerSearchDto managerSearchDto,@Param("offset") int offset, @Param("limit") int pageSize);

    void delManagerByIds(@Param("asList") List<Integer> asList);
}