package jpa;


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Carte {
	
	private Long id;
	private String libelle;
	//@Column(name = "date_butoir")
	private Date dateButoir;
	private String user;
	private int timeNeeded;
	private Set<Tag> tags = new HashSet<Tag>();
	private String lieu;
	private String url;
	private String noteExplicative;
	private String section;
	@Column(name = "table")
	private Table table;
	
	public String toString() {
		return libelle;
	}
	

	public Carte() {
		
	}
	
	public Carte(String libelle, Date dateButoir, String user, int timeNeeded, HashSet<Tag> tags, String lieu) {
		this.setLibelle(libelle);
		this.setDateButoir(dateButoir);
		this.setUser(user);
		this.setTimeNeeded(timeNeeded);
		this.setTags(tags);
		this.setLieu(lieu);
		this.setNoteExplicative("");
	}
	public Carte(String libelle, Date dateButoir, String user, int timeNeeded, HashSet<Tag> tags, String lieu, String noteExplicative) {
		this.setLibelle(libelle);
		this.setDateButoir(dateButoir);
		this.setUser(user);
		this.setTimeNeeded(timeNeeded);
		this.setTags(tags);
		this.setLieu(lieu);
		this.setNoteExplicative(noteExplicative);
	}
	@Id
    @GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDateButoir() {
		return dateButoir;
	}

	public void setDateButoir(Date dateButoir) {
		//this.dateButoir = Date.valueOf(dateButoir);
		this.dateButoir = dateButoir;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getTimeNeeded() {
		return timeNeeded;
	}

	public void setTimeNeeded(int timeNeeded) {
		this.timeNeeded = timeNeeded;
	}

	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="carte_id")
	public Set<Tag> getTags() {
		return tags;
	}
	
	

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNoteExplicative() {
		return noteExplicative;
	}

	public void setNoteExplicative(String noteExplicative) {
		this.noteExplicative = noteExplicative;
	}

	@ManyToOne
	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

}
