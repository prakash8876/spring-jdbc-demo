package app.matoshri.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import app.matoshri.main.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private String insertQuery = null;
    private String getInsertedEmp = null;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

	public void setInsertQuery(String insertQuery) {
		this.insertQuery = insertQuery;
	}

	@Override
	public void insertEmployee(Employee emp) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] inputs = new Object[] {emp.getEmpId(), emp.getName(), emp.getSalary(), emp.getDept()};
		jdbcTemplate.update(insertQuery, inputs);
	}

	@Override
	public Employee getInsertedEmp(Integer empId) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		Employee emp = jdbcTemplate.queryForObject(getInsertedEmp, new Object[] {empId},
				new RowMapper<Employee>() {

					@Override
					public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
						Employee emp = new Employee();
						emp.setEmpId(rs.getInt("EMPID"));
						emp.setName(rs.getString("NAME"));
						emp.setSalary(rs.getInt("SALARY"));
						emp.setDept(rs.getString("DEPT"));
						return emp;
					}
				});
		return emp;
	}

}
