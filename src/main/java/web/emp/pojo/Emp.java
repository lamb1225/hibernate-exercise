package web.emp.pojo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Emp {
	@Id
	private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Timestamp hireDate;
    private Double sal;
    private Double comm;
    private Integer deptno;
}
