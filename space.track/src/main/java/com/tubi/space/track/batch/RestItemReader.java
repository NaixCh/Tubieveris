package com.tubi.space.track.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.tubi.space.track.config.RestConfig;
import com.tubi.space.track.domain.Satellite;

public class RestItemReader implements ItemReader<Satellite> {
	
	private RestConfig config;
	private RestTemplate restTemplate;

    private int nextIndex;
    private JSONArray data;
    
    public RestItemReader(RestConfig config) {
    	this.restTemplate = new RestTemplate(); 
    	this.config = config;
        nextIndex = 0;
    }
    
	@Override
	public Satellite read() throws Exception {
		if(isNotInitialized()) {
			data = fetchDataFromAPI();
		}
		
		Satellite next = null;
		
		if(nextIndex < data.length()) {
			next = mapToSatellite(data.getJSONObject(nextIndex));
			nextIndex++;
		}
		
		return next;
	}
 
    private Satellite mapToSatellite(JSONObject jsonObject) {
		Satellite data = new Satellite();
		try {
			data.setOBJECT_ID(jsonObject.getString("OBJECT_ID"));
			data.setOBJECT_NAME(jsonObject.getString("OBJECT_NAME"));
			data.setRA_OF_ASC_NODE(jsonObject.getString("RA_OF_ASC_NODE"));
			data.setMEAN_MOTION(jsonObject.getString("MEAN_MOTION"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return data;
	}

	private JSONArray fetchDataFromAPI() {
    	String login = config.getBaseUrl() + config.getAuthPath();
    	ResponseEntity<String> response;
    	String rawResponse = null;
    	JSONArray jsonData = null;
    	
		try {
			response = restTemplate.postForEntity(login, 
					new HttpEntity<String>(getParametersAsJson().toString(), getJsonHeaders()), String.class);
			rawResponse = response.getBody();
			jsonData = new JSONArray(rawResponse);
		} catch (RestClientException | JSONException e) {
			e.printStackTrace();
		}
    	
		return jsonData;
	}

	private boolean isNotInitialized() {
        return this.data == null;
    }
	
	private HttpHeaders getJsonHeaders() {
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    return headers;
	}
	
	private JSONObject getParametersAsJson() throws JSONException {
		JSONObject json = new JSONObject();
		json.put("identity", config.getUserName());
		json.put("password", config.getPassword());
		json.put("query", config.getBaseUrl() + config.getQuery());
		return json;		
	}
}
