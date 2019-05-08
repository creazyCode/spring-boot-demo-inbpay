package com.insightchain.dao.repository;

import com.insightchain.dao.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {

}
