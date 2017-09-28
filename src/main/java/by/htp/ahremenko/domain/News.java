package by.htp.ahremenko.domain;

import java.util.Date;

//import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="news") 
public class News {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id") 
	private int id;
	
	@Column(name="title") 
	@NotNull(message="is required")
	private String title;
	
	@Column(name="brief")
	@NotNull(message="is required")
	@Size(min=3, message="is required")
	private String brief;
	
	@Column(name="content")
	private String content;
	
	@Column(name="create_date")
	private Date created;
	
	@Column(name="rec_state")
	private int active;
		
	public News() {
	}

	public News(String title, String brief, String content) {
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.created = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", brief=" + brief + ", active: " + active + ", created:" + created + "]";
	}

} 