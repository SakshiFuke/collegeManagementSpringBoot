package com.anudip.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "Batches_Details1")
public class Batches {

	@Id
	private int bid;
	
	@Column(length=20, nullable = true)
	@NotBlank(message = "Batch Name cannot be blank")
	private String bname;
	
	@Column(length=8, nullable = true)
	@NotBlank(message = "Subject cannot be blank")
	private String subject;
	
	@Column(length=10, nullable = true)
	@NotNull(message = "Startdate cannot be blank")
	private String startdate;
	
	@Column(length=10, nullable = true)
	@NotNull(message = "Enddate cannot be blank")
	private String enddate;
	
	@Column(length=10, nullable = true)
	@NotNull(message = "Duration cannot be blank")
	private int duration;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "TracherId",referencedColumnName = "tid")
	@JsonBackReference
	private Teacher teacher;
}
