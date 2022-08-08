package app.matoshri.main.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import app.matoshri.main.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private String insertQuery = null;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

	public void setInsertQuery(String insertQuery) {
		this.insertQuery = insertQuery;
	}

	@Override
	public void insertEmployee(Employee emp) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		// add new object
		Object[] inputs = new Object[] {emp.getEmpId(), emp.getName(), emp.getSalary(), emp.getDept()};
		jdbcTemplate.update(insertQuery, inputs);
	}

}
