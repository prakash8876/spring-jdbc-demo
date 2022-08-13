package app.matoshri.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.matoshri.main.dao.EmployeeDao;
import app.matoshri.main.dao.GenerateId;
import app.matoshri.main.entity.Employee;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("Application Started ...");
        App.start(args);
        System.out.println("Application Ended ...");
    }

	private static void start(String[] args) {
		String confFile = "config/spring-config.xml";
        ConfigurableApplicationContext context = 
                                new ClassPathXmlApplicationContext(confFile);
        EmployeeDao empDao = (EmployeeDao) context.getBean("employeeDAO");
        GenerateId primaryKey = (GenerateId) context.getBean("generateId");
        
        Employee emp = new Employee();
        emp.setEmpId(primaryKey.getPrimayKey());
        emp.setName("Madhu");
        emp.setSalary(60000);
        emp.setDept("HR");
        empDao.insertEmployee(emp);
        Employee insertedEmp = empDao.getInsertedEmp(emp.getEmpId());
        System.out.println("Employee Inserted: " + insertedEmp);
        context.close();
	}
}
