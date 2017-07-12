/*package com.nisum.test.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
public class TilesConfiguration  {

	   @Bean
	    public TilesConfigurer tilesConfigurer() {
	        final TilesConfigurer configurer = new TilesConfigurer();
	        configurer.setDefinitions(new String[] { "WEB-INF/tiles/tiles.xml" });
	        configurer.setCheckRefresh(true);
	        return configurer;
	    }

	    
	   @Bean
		public UrlBasedViewResolver viewResolverTiles() {
			UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
			viewResolver.setViewClass(TilesView.class);
			viewResolver.setOrder(1);
			return viewResolver;
		}

		@Bean
		public TilesViewResolver tilesViewResolver() {
			TilesViewResolver viewResolver = new TilesViewResolver();
			viewResolver.setOrder(2);
			return viewResolver;
		}

	   

	    
}
*/