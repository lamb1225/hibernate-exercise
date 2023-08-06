package web.emp.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Dept {
	@Id
	private Integer deptno;
	private String dname;
	private String loc;

}
