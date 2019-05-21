package com.bootdo.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.UserinfobbDao;
import com.bootdo.system.domain.UserinfobbDO;
import com.bootdo.system.service.UserinfobbService;



@Service
public class UserinfobbServiceImpl implements UserinfobbService {
	@Autowired
	private UserinfobbDao userinfobbDao;
	
	@Override
	public UserinfobbDO get(Integer id){
		return userinfobbDao.get(id);
	}
	
	@Override
	public List<UserinfobbDO> list(Map<String, Object> map){
		return userinfobbDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return userinfobbDao.count(map);
	}
	
	@Override
	public int save(UserinfobbDO userinfobb){
		return userinfobbDao.save(userinfobb);
	}
	
	@Override
	public int update(UserinfobbDO userinfobb){
		return userinfobbDao.update(userinfobb);
	}
	
	@Override
	public int remove(Integer id){
		return userinfobbDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return userinfobbDao.batchRemove(ids);
	}
	
}
