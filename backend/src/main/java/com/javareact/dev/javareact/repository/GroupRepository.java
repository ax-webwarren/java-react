package com.javareact.dev.javareact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.dev.javareact.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName(String name);
}