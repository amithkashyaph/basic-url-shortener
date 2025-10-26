package com.project.url_shortener.repositories;

import com.project.url_shortener.entities.ShortUrl;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShortUrlRespository extends JpaRepository<ShortUrl, Long> {

    // @Query("select su from ShortUrl su left join fetch su.createdBy where su.isPrivate = false order by su.createdAt desc")
    @Query("select su from ShortUrl su where su.isPrivate = false order by su.createdAt desc")
    @EntityGraph(attributePaths = {"createdBy"})
    List<ShortUrl> findAllPublicUrls();
}
