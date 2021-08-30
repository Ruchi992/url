package com.redirection.url.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.redirection.url.repository.UrlRepository;

@RunWith(MockitoJUnitRunner.class)
public class UrlServiceTest {

	@Mock
	private UrlRepository urlRepository;
	
	@InjectMocks
	private UrlService objectUnderTest;
	
	@Before
	public void pre() {
		initMocks(this);
	}
	
	@Test
	public void whenShortUrlIsReceivedNoSearchStringPresent_thenNullIsReturned() {
		
		String shortUrl = "bit.ly";
		String fullUrl = objectUnderTest.getFullUrlFromShortUrl(shortUrl);
		
		assertThat(fullUrl).isNull();
		
	}
	
	@Test
	public void whenShortUrlIsReceived_thenFullUrlIsReturned() {
		
		String shortUrl = "bit.ly";
		String sampleFullUrl = "sampleFullurl";
		
		when(urlRepository.getFullUrlFromShortUrl(Mockito.anyString())).thenReturn(sampleFullUrl);
		
		String fullUrl = objectUnderTest.getFullUrlFromShortUrl(shortUrl);
		
		
		assertThat(fullUrl).isEqualTo(sampleFullUrl);
		
	}
	
	@Test
	public void whenShortUrlIsReceived_thenFullUrlWithSearchStringIsReturned() {
		
		String shortUrl = "bit.ly/searchString";
		String sampleFullUrl = "sampleFullurl";
		String sampleFullUrlWithSearchString = sampleFullUrl+"searchString";
		
		when(urlRepository.getFullUrlFromShortUrl(Mockito.anyString())).thenReturn(sampleFullUrl);
		
		String fullUrl = objectUnderTest.getFullUrlFromShortUrl(shortUrl);
		
		
		assertThat(fullUrl).isEqualTo(sampleFullUrlWithSearchString);
		
	}
}
