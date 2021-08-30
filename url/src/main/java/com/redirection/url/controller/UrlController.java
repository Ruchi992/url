package com.redirection.url.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.redirection.url.service.UrlService;
import com.redirection.url.view.UrlView;

@RestController
@CrossOrigin(origins = "http://localhost:8090")
public class UrlController {

	@Autowired
	private UrlService urlService;
	
	@PostMapping("/shortUrl")
	public ResponseEntity<?> redirectToFullUrl(@RequestBody UrlView urlView) throws URISyntaxException
	{
		
		String fullUrl = urlService.getFullUrlFromShortUrl(urlView.getShortUrl());
		
		if(fullUrl == null)
			return ResponseEntity.badRequest().body("Invalid short Url");
		
		return ResponseEntity.ok().body(fullUrl);
	}
}
