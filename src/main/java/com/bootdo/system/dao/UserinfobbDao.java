package com.bootdo.system.dao;

import com.bootdo.system.domain.UserinfobbDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-13 15:09:39
 */
@Mapper
public interface UserinfobbDao {

	UserinfobbDO get(Integer id);
	
	List<UserinfobbDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(UserinfobbDO userinfobb);
	
	int update(UserinfobbDO userinfobb);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
