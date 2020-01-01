package com.pid.main.dto;

public class TemplateDTO {

	private String templateTitle;
	private String templateContent;

	public TemplateDTO(String templateTitle, String templateContent) {
		this.templateTitle = templateTitle;
		this.templateContent = templateContent;
	}

	public String getTemplateTitle() {
		return templateTitle;
	}

	public void setTemplateTitle(String templateTitle) {
		this.templateTitle = templateTitle;
	}

	public String getTemplateContent() {
		return templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

}
