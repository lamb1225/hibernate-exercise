<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
                                         "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
<!--     	下列4行設定用於main()方法 -->
<!--         <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property> -->
<!--         <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/JAVA_FRAMEWORK?serverTimezone=Asia/Taipei</property> -->
<!--         <property name="hibernate.connection.username">root</property> -->
<!--         <property name="hibernate.connection.password">123456</property> -->
        
<!--         上面四行等同於下面一行(使⽤JNDI中的DataSource)(用於web環境) -->
        <property name="hibernate.connection.datasource">java:comp/env/jdbc/javaFramework</property>
<!--         要用Session getCurrentSession()，需配合下列的組態設定檔才可使用 -->
        <property name="hibernate.current_session_context_class">thread</property>
        
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="hibernate.show_sql">true</property>
        <property name="hibernate.format_sql">true</property>
        
        <mapping class="web.member.entity.Member" />
        <mapping class="web.emp.entity.Emp" />
        <mapping class="web.emp.entity.Dept" />        
    </session-factory>
</hibernate-configuration>