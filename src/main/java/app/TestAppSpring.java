package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import web.member.dao.MemberDao;
import web.member.entity.Member;

public class TestAppSpring {
	public static void main(String[] args) {
		//	建立瓶子，咖啡豆="applicationContext.xml"託管的物件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//	拿取咖啡豆
		MemberDao memberDao = applicationContext.getBean(MemberDao.class);
		
		for(Member member : memberDao.selectAll()) {
			// 瓶子非空的=有咖啡豆，就可以使用
			System.out.println(member.getNickname());
		}
	}
}
