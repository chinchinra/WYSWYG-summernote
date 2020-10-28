package youngjae.study.domain;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Article {
	@Id @GeneratedValue
	private Long id;


	@Column
	private String author;

	@Column
	private String title;
	
	@Column(length= 100000000)
	private String content;

	@Column
	private LocalDateTime registerDate;
	
	@Column
	private LocalDateTime updateDate;

	public void update(String title , String author , String content , LocalDateTime updateDate){

		this.content = content;
		this.author = author;
		this.title = title;
		this.updateDate = updateDate;

	}
}



