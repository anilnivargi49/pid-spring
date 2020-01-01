package com.pid.main.Util;

import freemarker.cache.StringTemplateLoader;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;

public class TemplateUtil {

	private static Configuration freemarkerConfig;

	static {
		freemarkerConfig = new Configuration(Configuration.VERSION_2_3_28);
		freemarkerConfig.setTagSyntax(Configuration.ANGLE_BRACKET_TAG_SYNTAX);
		freemarkerConfig.setDefaultEncoding("UTF-8");
		freemarkerConfig.setNumberFormat("computer");
		freemarkerConfig.setObjectWrapper(new BeansWrapperBuilder(Configuration.VERSION_2_3_23).build());
		freemarkerConfig.setTemplateLoader(new StringTemplateLoader());
	}

	public static Configuration getFreemarkerConfig() {
		return freemarkerConfig;
	}

	public static void setFreemarkerConfig(Configuration freemarkerConfig) {
		TemplateUtil.freemarkerConfig = freemarkerConfig;
	}
}
