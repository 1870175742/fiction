package com.fiction.test;

import java.util.List;

import com.fiction.dao.FictionDao;
import com.fiction.entity.FictionEntity;
public abstract class adminTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FictionDao fe = new FictionDao();
		//System.out.println(ad.editadmin(15,"wan", "333123", "3241@qq.com", "Å®", "1231234223", "2013-3-3"));
		List<FictionEntity> list =fe.getAllById("¶·ÆÆ²Ôñ·",1);
		for(FictionEntity user:list){
			System.out.println(user.getTitle());
			System.out.println(user.getContent());
		}
	
	}

}
