package com.example.demo.repository;

import com.example.demo.entity.Account;
import com.example.demo.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query(value = "select * from post where title like %:title%", nativeQuery = true)
    public List<Post> findByTitle(@Param("title") String title);
//
//    Page<Post> findByUserOrderByCreateDateDesc(Account account, Pageable pageable);
//
//    Page<Post> findAllByOrderByCreateDateDesc(Pageable pageable);

    Optional<Post> findById(Long id);
}
