package com.WebsiteLLC.data;

import com.WebsiteLLC.forms.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface UsersDao extends CrudRepository<Users, Integer>{
}
