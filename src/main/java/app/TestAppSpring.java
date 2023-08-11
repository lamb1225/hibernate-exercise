package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import web.member.dao.MemberDao;
import web.member.entity.Member;

public class TestAppSpring {
	public static void main(String[] args) {
		
//		//	建立瓶子，咖啡豆="applicationContext.xml"託管的物件
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		//	拿取咖啡豆
//		MemberDao memberDao = applicationContext.getBean(MemberDao.class);
//		
//		for(Member member : memberDao.selectAll()) {
//			// 瓶子非空的=有咖啡豆，就可以使用
//			System.out.println(member.getNickname());
//		}
		
		
//		// 練習JDBC寫法
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		DataSource dataSource = applicationContext.getBean(DataSource.class);
//		
//		try (
//			Connection conn = dataSource.getConnection();
//			PreparedStatement pstmt = conn.prepareStatement("select * from MEMBER where ID = ?");
//		){
//			pstmt.setInt(1, 2);
//			try(ResultSet rs = pstmt.executeQuery()){
//				if(rs.next()) {
//					System.out.println(rs.getString("NICKNAME"));
//				}	
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		// 測試用IoC容器物件-GenericApplicationContext
		GenericApplicationContext applicationContext = new GenericApplicationContext();
        new XmlBeanDefinitionReader(applicationContext).loadBeanDefinitions("applicationContext.xml");
        applicationContext.refresh();
        
        MemberDao memberDao = applicationContext.getBean(MemberDao.class);
        System.out.println(memberDao.selectById(1).getNickname());
        
        ((ConfigurableApplicationContext) applicationContext).close();
	}
}
