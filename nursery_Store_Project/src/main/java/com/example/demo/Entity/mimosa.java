package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@ToString
public class mimosa {

	@Id
	String name;
	int price;
	String picurl;
	int quantity;
}
