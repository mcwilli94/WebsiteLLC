package com.WebsiteLLC.data;


import com.WebsiteLLC.forms.Administrator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface AdministratorDao extends CrudRepository<Administrator, Integer> {

}
