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
	public List<Debris> getItems() {
		JdbcTemplate template = new JdbcTemplate(datasource);
		String SQLQuery = "SELECT * from DEBRIS";
		return template.query(SQLQuery, new DebrisMapper());
	}
	
	
	private class DebrisMapper implements RowMapper<Debris> {
        public Debris mapRow(ResultSet rs, int rowNum) throws SQLException {
            Debris debris = new Debris();
            debris.setObjectId(rs.getString("OBJECT_ID"));
            debris.setObjectName(rs.getString("OBJECT_NAME"));
            debris.setRaOfAscNode(rs.getString("RA_OF_ASC_NODE"));
            debris.setMeanMotion(rs.getString("MEAN_MOTION"));
            debris.setType(rs.getString("TYPE"));
            debris.setSize(rs.getString("SIZE"));
            debris.setScale(rs.getString("SCALE"));
            return debris;
        }
    }
	
}
