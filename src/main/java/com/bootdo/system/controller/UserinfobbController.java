package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.system.domain.UserinfobbDO;
import com.bootdo.system.service.UserinfobbService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-05-13 15:09:39
 */
 
@Controller
@RequestMapping("/system/userinfobb")
public class UserinfobbController {
	@Autowired
	private UserinfobbService userinfobbService;
	
	@GetMapping()
	@RequiresPermissions("system:userinfobb:userinfobb")
	String Userinfobb(){
	    return "system/userinfobb/userinfobb";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:userinfobb:userinfobb")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<UserinfobbDO> userinfobbList = userinfobbService.list(query);
		int total = userinfobbService.count(query);
		PageUtils pageUtils = new PageUtils(userinfobbList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:userinfobb:add")
	String add(){
	    return "system/userinfobb/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("system:userinfobb:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		UserinfobbDO userinfobb = userinfobbService.get(id);
		model.addAttribute("userinfobb", userinfobb);
	    return "system/userinfobb/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:userinfobb:add")
	public R save( UserinfobbDO userinfobb){
		if(userinfobbService.save(userinfobb)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("system:userinfobb:edit")
	public R update( UserinfobbDO userinfobb){
		userinfobbService.update(userinfobb);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:userinfobb:remove")
	public R remove( Integer id){
		if(userinfobbService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:userinfobb:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		userinfobbService.batchRemove(ids);
		return R.ok();
	}
	
}
