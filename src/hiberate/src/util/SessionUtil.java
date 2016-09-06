package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {

	//定义一个SessionFactory，这个可以先想成是数据的连接池
	private static SessionFactory sessionFactory;
	
	static{
		//如果hibernate.cfg.xml是放在src目录下，这可以不用路径，但是配置文件名称必须以hibernate.cfg.xml命名。
		Configuration cfg = new Configuration();//加载配置文件
		sessionFactory = cfg.configure().buildSessionFactory();
	}

	//获取session ，可以先想成是一个连接。
	public static Session getSession(){
		return sessionFactory.openSession();
	}
}
