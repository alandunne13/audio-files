package com.alandunne.audiofiles.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "files")
@NoArgsConstructor
public class AudioFile {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	private String filename;

	@Lob
	private byte[] content;

	private String contentType;

	public AudioFile(String filename, byte[] content, String contentType) {
		this.filename = filename;
		this.content = content;
		this.contentType = contentType;
	}
}
