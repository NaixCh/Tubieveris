package com.tubi.space.track.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tubi.space.track.domain.Debris;

@Controller
public class FrontController {
	
	@Autowired
	DataSource datasource;

	@GetMapping("/getItems")
	@ResponseBody
	public List<Map<String, Object>> getItems() {
		
		JdbcTemplate template = new JdbcTemplate(datasource);
		String SQLQuery = "SELECT * from DEBRIS";
		return template.queryForList(SQLQuery, new DebrisMapper());
    
	}
	
	
	private class DebrisMapper implements RowMapper<Debris> {
        public Debris mapRow(ResultSet rs, int rowNum) throws SQLException {
            Debris debris = new Debris();
            return debris;
        }
    }

	
}
