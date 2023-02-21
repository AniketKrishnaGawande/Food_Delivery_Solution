package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="hotels")
@NoArgsConstructor 
@AllArgsConstructor 
@Getter 
@Setter
public class hotelier extends BaseEntity{
	@Column(length = 20)
	private String hName;
	
	@Column(length = 20)
	private String hAddress;
	
	private int rating;
	
	@OneToMany()
	private List<hotel_menu> menus=new ArrayList<>();
	
	// menu relation pending

}
