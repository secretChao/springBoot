package com.test.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.repo.UserDao;
import com.test.vo.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public User find(String id) throws Exception {
		Optional<User> user = userDao.findById(id);
		if (!user.isPresent()) {
			throw new Exception("查無資料");
		}
		return user.get();
	}

	public Iterable<User> findAll() throws Exception {
		Iterable<User> users = userDao.findAll();
		if(!users.iterator().hasNext()) {
			throw new Exception("查無資料");
		}
		return users;
	}

	public void insert(User user) throws Exception {
		if (userDao.existsById(user.getId())) {
			throw new Exception("資料已存在");
		}
		userDao.save(user);
	}

	public void update(User user) throws Exception {
		if (!userDao.existsById(user.getId())) {
			throw new Exception("查無資料");
		}
		userDao.save(user);
	}

	public void delete(String id) throws Exception {
		if (!userDao.existsById(id)) {
			throw new Exception("查無資料");
		}
		userDao.deleteById(id);
	}

}
