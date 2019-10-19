package com.tubi.space.track.batch;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tubi.space.track.config.RestConfig;
import com.tubi.space.track.domain.Satellite;

public class RestItemReader implements ItemReader<Satellite> {
	
	@Autowired
	private ;
	
	private String url;
	private final RestTemplate restTemplate;

    private int nextIndex;
    private List<Satellite> data;
    
    RestItemReader(RestTemplate restTemplate, RestConfig config) {
    	
        this.restTemplate = restTemplate;
        nextIndex = 0;
    }
    
	@Override
	public Satellite read() throws Exception {
		if(!isInitialized()) {
			data = fetchDataFromAPI();
		}
		
		Satellite next = null;
		
		if(nextIndex < data.size()) {
			next = data.get(nextIndex);
			nextIndex++;
		}
		
		return next;
	}
 
    private List<Satellite> fetchDataFromAPI() {
		ResponseEntity<Satellite[]> response = restTemplate.getForEntity("", Satellite[].class);
		Satellite[] satelliteData = response.getBody();
		return Arrays.asList(satelliteData);
	}

	private boolean isInitialized() {
        return this.data == null;
    }
	
}
