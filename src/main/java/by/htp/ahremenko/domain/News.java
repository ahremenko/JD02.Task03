package by.htp.ahremenko.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//import java.text.SimpleDateFormat;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="news") 
public class News {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id") 
	private int id;
	
	@Column(name="title")
	@NotNull(message="is required") 	
	@Size(min=3, max = 100, message="is required (3..100)")	
	private String title;
	
	@Column(name="brief")
	@NotNull(message="is required") 	
	@Size(min=3, max = 500, message="is required (3..500)")
	private String brief;
	
	@NotNull(message="is required") 	
	@Size(min = 3, max = 2048, message = "is required (3..2048)")
	@Column(name="content")
	private String content;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name="create_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "is required (yyyy-MM-dd)")
	private Date created;
	
	@Column(name="rec_state")
	private int active;
	
	public News() {
		this.active = 1;
		this.created = new Date();
	}

	public News(String title, String brief, String content) {
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.created = new Date();
		this.active = 1;
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
	public int hashCode() {
		final int prime = 73;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((brief == null) ? 0 : brief.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + active;
		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		News other = (News) obj;
		
		if (id != other.id) {
			return false;
		}
		
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		
		if (brief == null) {
			if (other.brief != null) {
				return false;
			}
		} else if (!brief.equals(other.brief)) {
			return false;
		}
		if (content == null) {
			if (other.content != null) {
				return false;
			}
		} else if (!content.equals(other.content)) {
			return false;
		}
		if (created == null) {
			if (other.created != null) {
				return false;
			}
		} else if (!created.equals(other.created)) {
			return false;
		}
		if (active != other.active) {
			return false;
		}
		return true;
	}

	
	
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", brief=" + brief + ", active: " + active + ", created:" + created + "]";
	}


} 