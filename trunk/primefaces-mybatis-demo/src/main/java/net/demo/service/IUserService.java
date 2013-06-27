package net.demo.service;

import java.util.List;

import net.demo.domain.User;


public interface IUserService {
	int insert(User item);
	int update(User item);
	int delete(Long id);
	List<User> search(User item);	
	
}
