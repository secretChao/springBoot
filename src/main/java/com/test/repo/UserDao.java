package com.test.repo;

import org.springframework.data.repository.CrudRepository;

import com.test.vo.User;

public interface UserDao extends CrudRepository<User, String> {

}
