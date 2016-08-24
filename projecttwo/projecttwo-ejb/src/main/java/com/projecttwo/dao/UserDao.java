package com.projecttwo.dao;

import javax.ejb.Local;

import com.projecttwo.User;
import com.projecttwo.dao.common.Dao;

@Local
public interface UserDao extends Dao<User> {

	User findByUsername(String username);

}
