package net.demo.service;

import java.util.List;

import net.demo.domain.User;
import net.demo.mapper.MyBatisConnectionFactory;

import org.apache.ibatis.session.SqlSession;



public class UserService implements IUserService{

	
	public int insert(User item) {
		int result=0;
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		try{
			IUserService service=session.getMapper(IUserService.class);
			
			result=service.insert(item);
			session.commit();
			
		}
		finally{
			session.close();
		}
		return result;
	}

	
	public int update(User item) {
		Integer result=null;
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		try{
			IUserService service=session.getMapper(IUserService.class);
			
			result=service.update(item);
			session.commit();
			
		}
		finally{
			session.close();
		}
		return result;
	}

	
	public int delete(Long userId) {
		Integer result=null;
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		try{
			IUserService service=session.getMapper(IUserService.class);
			
			result=service.delete(userId);
			session.commit();
			
		}
		finally{
			session.close();
		}
		return result;
	}

	
	public List<User> search(User item) {
		List<User> result=null;
		SqlSession session = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		
		try{
			IUserService service=session.getMapper(IUserService.class);
			result=service.search(item);
		}
		finally{
			session.close();
		}
		return result;
	}


}
