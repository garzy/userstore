package com.tangorabox.userstore.repository;

import com.tangorabox.userstore.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
