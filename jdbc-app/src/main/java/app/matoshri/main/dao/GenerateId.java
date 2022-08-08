package app.matoshri.main.dao;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class GenerateId {

	private String getPrimaryKey = null;
	private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private Integer primaryKey;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setGetPrimaryKey(String getPrimaryKey) {
		this.getPrimaryKey = getPrimaryKey;
	}
	
	public int getPrimayKey() {
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);
			primaryKey = jdbcTemplate.queryForObject(getPrimaryKey, Integer.class);
			return primaryKey + 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			primaryKey = 100;
		}
		return primaryKey;
	}
	
}
