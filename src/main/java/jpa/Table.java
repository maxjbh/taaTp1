package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Table {
	
	private Long id;
	private String projectName;
	private List<Carte> fiches = new ArrayList<Carte>();
	
	public Table() {
		
	}

	@OneToMany(mappedBy = "table",cascade = CascadeType.ALL )
	public List<Carte> getFiches() {
		return fiches;
	}

	public void setFiches(List<Carte> fiches) {
		this.fiches = fiches;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Id
    @GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
