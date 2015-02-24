package vn.com.nguacon.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Controller
	static class Routes {
		@RequestMapping({ "/home", "/about" })
		public String index() {
			return "forward:/index.html";
		}
	}

	@Bean
	public ServletContextInitializer servletContextInitializer() {
		return servletContext -> {
			final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
			characterEncodingFilter.setEncoding("UTF-8");
			characterEncodingFilter.setForceEncoding(false);
			servletContext.addFilter("characterEncodingFilter",
					characterEncodingFilter).addMappingForUrlPatterns(
					EnumSet.of(DispatcherType.REQUEST), false, "/*");
		};
	}

//	@Override
//	public void configurePathMatch(final PathMatchConfigurer configurer) {
//		configurer.setUseRegisteredSuffixPatternMatch(true);
//	}
//
//	@Override
//	public void configureContentNegotiation(
//			ContentNegotiationConfigurer configurer) {
//		super.configureContentNegotiation(configurer);
//		configurer.favorParameter(true);
//	}
//
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/webjars/**").addResourceLocations(
//				"classpath:/META-INF/resources/webjars/");
//	}
//
//	@Bean
//	public SpringTemplateEngine templateEngine() {
//		SpringTemplateEngine engine = new SpringTemplateEngine();
//		engine.setTemplateResolver(templateResolver());
//		return engine;
//	}
//
//	@Bean
//	public ClassLoaderTemplateResolver templateResolver() {
//		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//		templateResolver.setTemplateMode("XHTML");
//		templateResolver.setPrefix("static/");
//		templateResolver.setSuffix(".html");
//		templateResolver.setOrder(0);
//		return templateResolver;
//	}
//
//	@Bean
//	public ViewResolver viewResolver() {
//		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//		viewResolver.setTemplateEngine(templateEngine());
//		viewResolver.setCharacterEncoding("UTF-8");
//		viewResolver.setViewNames(new String[] { "*" });
//		viewResolver.setOrder(1);
//		return viewResolver;
//	}
}
