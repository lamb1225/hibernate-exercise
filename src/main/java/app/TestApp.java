package app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import core.util.HibernateUtil;
import web.member.pojo.Member;

public class TestApp {
	public static void main(String[] args) {
//		Member member = new Member();
//		member.setUsername("使用者名稱");
//		member.setPassword("密碼");
//		member.setNickname("暱稱");
//		
		// 新增測試
		TestApp app = new TestApp();
//		app.insert(member);
//		System.out.println(member.getId());

		// 刪除測試
//		System.out.println(app.deleteById(3));

		// 修改測試
//		Member member = new Member();
//		member.setId(1);
//		member.setPass(false);
//		member.setRoleId(2);
//		System.out.println(app.updateById(member));
		
		// 單筆查詢測試
//		System.out.println(app.selectById(2).getNickname());
		
		//多筆查詢測試
		app.selectAll().forEach(member -> System.out.println(member.getNickname()));
		// 上面一行等於下列寫法
		for(Member member : app.selectAll()){
			System.out.println(member.getNickname());
		}
	
	}

	// 新增
	public Integer insert(Member member) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			session.persist(member);
			transaction.commit();
			return member.getId();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	// 刪除
	public int deleteById(Integer id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			Member member = session.get(Member.class, id);
			session.remove(member);
			transaction.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return -1;
		}
	}

	// 修改
	public int updateById(Member newMember) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			Member oldMember = session.get(Member.class, newMember.getId());
			final Boolean pass = newMember.getPass();
			if (pass != null) {
				oldMember.setPass(pass);
			}
			final Integer roleId = newMember.getRoleId();
			if (roleId != null) {
				oldMember.setRoleId(roleId);
			}
			transaction.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return -1;
		}
	}

	// 單筆查詢
	public Member selectById(Integer id) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			Member member = session.get(Member.class, id);
			transaction.commit();
			return member;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}
	
	// 多筆查詢
	public List<Member> selectAll() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			Query<Member> query = session.createQuery("SELECT new web.member.pojo.Member(username, nickname) FROM Member", Member.class);
			List<Member> list = query.getResultList();
			transaction.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}
}
