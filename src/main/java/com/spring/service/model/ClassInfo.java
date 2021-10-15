package com.spring.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "class_info")
public class ClassInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "day_of_week")
	private Long dayOfWeek;
	
	@Column(name = "period_start")
	private Long periodStart;
	
	@Column(name = "period_end")
	private Long periodEnd;
	
	@Column(name = "link")
	private String link;
	
	@Column(name = "description", length = 1000)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(Long dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public Long getPeriodStart() {
		return periodStart;
	}
	public void setPeriodStart(Long periodStart) {
		this.periodStart = periodStart;
	}
	public Long getPeriodEnd() {
		return periodEnd;
	}
	public void setPeriodEnd(Long periodEnd) {
		this.periodEnd = periodEnd;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
