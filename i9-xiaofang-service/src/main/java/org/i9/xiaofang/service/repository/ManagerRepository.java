package org.i9.xiaofang.service.repository;

import org.i9.xiaofang.service.repository.mapper.ManagerMapper;
import org.i9.xiaofang.service.repository.model.Manager;
import org.i9.xiaofang.service.repository.vo.ManagerSearchDto;
import org.i9.xiaofang.util.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManagerRepository {
	
	@Autowired
	ManagerMapper managerMapper;
	
	public Manager getManagerByName(String username){
		return managerMapper.getManagerByName(username);
	}

	public PageBounds<Manager> selectBylimitPage(ManagerSearchDto managerSearchDto) throws Exception {
		int totalSize = managerMapper.countByExample(managerSearchDto);
		PageBounds<Manager> pageBounds = new PageBounds<Manager>(managerSearchDto.getCurrentPage(), totalSize, managerSearchDto.getPageSize());
		List<Manager> list = managerMapper.selectBylimitPage(managerSearchDto,pageBounds.getOffset(),pageBounds.getPageSize());
		pageBounds.setPageList(list);
		return pageBounds;
	}

    public void updateManagerInfoById(Manager manager) throws Exception{
        managerMapper.updateByPrimaryKeySelective(manager);
    }

    public void insertManagerInfo(Manager manager) throws Exception{
        managerMapper.insert(manager);
    }

    public void delManagerByIds(List<Integer> asList) throws Exception{
        managerMapper.delManagerByIds(asList);
    }
}
