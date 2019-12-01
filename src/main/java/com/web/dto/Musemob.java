package com.web.dto;

import lombok.Data;

@Data
public class Musemob {
	private int musemobid;
	private int championpostid;
	private int championpoint;
	private int challengerpostid;
	private int challengerpoint;
	private String creationdate;
	
	private InstBoard championpost;
	private InstBoard challengerpost;
}
