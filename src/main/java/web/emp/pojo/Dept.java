package web.emp.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Dept {
	@Id
	private Integer deptno;
	private String dname;
	private String loc;
	// 單向1對N (Dempt -> Emp)
//	@OneToMany
//	@JoinColumn(name = "DEPTNO", referencedColumnName = "DEPTNO")
//	private List<Emp> emps;

	// 雙向1對N (Dempt -> Emp)
	@OneToMany(mappedBy = "dept")
	private List<Emp> emps;

}
