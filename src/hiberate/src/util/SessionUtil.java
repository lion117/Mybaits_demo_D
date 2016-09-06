package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {

	//����һ��SessionFactory�������������������ݵ����ӳ�
	private static SessionFactory sessionFactory;
	
	static{
		//���hibernate.cfg.xml�Ƿ���srcĿ¼�£�����Բ���·�������������ļ����Ʊ�����hibernate.cfg.xml������
		Configuration cfg = new Configuration();//���������ļ�
		sessionFactory = cfg.configure().buildSessionFactory();
	}

	//��ȡsession �������������һ�����ӡ�
	public static Session getSession(){
		return sessionFactory.openSession();
	}
}
