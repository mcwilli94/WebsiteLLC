package com.WebsiteLLC.data;


import org.springframework.data.repository.CrudRepository;
import com.WebsiteLLC.forms.Clients;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface ClientsDao extends CrudRepository<Clients, Integer> {

}