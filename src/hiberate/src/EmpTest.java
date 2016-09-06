import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionUtil;

import entity.Emp;

/**
 *该类主要用hibernate实现对t_emp表的增、删、查、改
 *
 */
public class EmpTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		insertEmp();
		selectAll();
	}
	
	/**
	 * 往数据数据库中插入数据，特别注意哦，对于增、删、改 是需要事务支持的
	 */
	public static void insertEmp(){
		//获取数据库连接
		Session session = SessionUtil.getSession();
		//开启事物
		Transaction ts = session.beginTransaction();
		Emp emp = new Emp();
		emp.setId(3);
		emp.setName("大明");
		emp.setSalary(new BigDecimal(10000));
		emp.setAge(25);
		//向数据库中插入一条数据 
		session.save(emp);
		//提交事物
		ts.commit();
		session.close();
	}
	
	
	/**
	 * 对数据库删除一条数据，该操作需要通过一个对象，且该对象必须设置主键
	 * 如果该对象不存在，则会抛出异常。
	 */
	public static void deleteEmp(){
		//获取数据库连接
		Session session = SessionUtil.getSession();
		//开启事物
		Transaction ts = session.beginTransaction();
		Emp emp = new Emp();
		//通过主键删除数据
		emp.setId(2);
		//向数据库中删除一条数据 
		session.delete(emp); //该对象必须设置主键，否则删除无效
		//提交事物
		ts.commit();
		session.close();
	}
	
	/**
	 * 更新一条数据，我们这里的例子以一个实体对象为单位更新
	 */
	public static void updateEmp(){
		//获取数据库连接
		Session session = SessionUtil.getSession();
		//开启事物
		Transaction ts = session.beginTransaction();
		
		Emp emp = new Emp(); 
		emp.setId(3);
		emp.setName("张三");
		emp.setAge(22);
		emp.setSalary(new BigDecimal("10000.25"));
		
		//更新一条数据
		session.update(emp); //这里都每个字段都要填哦，不然会抛出异常的
		
		//提交事物
		ts.commit();
		session.close();
	}
	/**
	 * 查询一个表中的所有数据
	 */
	public static void selectAll(){
		//获取数据库连接
		Session session = SessionUtil.getSession();
		//开启事物
		Transaction ts = session.beginTransaction();

		//注意这里使用的hsql,是hiberate给出的sql，我们只需需要对实体对象进行操作。
		String hsql = "from Emp";  
		//获取一个hsql查询对象，hiberate会根据你写的hsql语句转化为sql语句。
		Query query = session.createQuery(hsql);
		List<Emp> emps = query.list();

	/*	//我们也可以使用我们熟悉的sql语句来编写
		String sql = "select * from t_emp";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		//把查询到的结果对象我们映射的实体对象
	    sqlQuery.addEntity(Emp.class);
		 List<Emp> emps = sqlQuery.list();*/
	 
		for (Emp emp : emps) {
			System.out.println(emp);
		}
	}
	
}
