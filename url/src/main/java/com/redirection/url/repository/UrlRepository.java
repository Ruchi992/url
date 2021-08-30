package com.redirection.url.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.redirection.url.model.UrlInfo;

@Repository
public interface UrlRepository extends JpaRepository<UrlInfo, Integer>{

	@Query(value="select u.full_url from url_info u where u.short_url = :shortUrl", nativeQuery=true)
	String getFullUrlFromShortUrl(@Param("shortUrl") String shortUrl);
}
