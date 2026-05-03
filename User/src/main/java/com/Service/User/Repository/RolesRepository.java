package com.Service.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Service.User.Entity.RoleTable;


@Repository
public interface RolesRepository extends JpaRepository<RoleTable, Long> {

}
