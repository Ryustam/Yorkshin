package com.example.yorkshin.repository;

import com.example.yorkshin.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 첫번째 인자 Entity
 * Id 값의 타입 (래퍼턴스타입)
 */
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
