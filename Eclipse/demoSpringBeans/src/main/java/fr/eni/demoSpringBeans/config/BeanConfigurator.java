package fr.eni.demoSpringBeans.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.eni.demoSpringBeans.bll.BonjourService;
import fr.eni.demoSpringBeans.bll.BonjourServiceImpl;
import fr.eni.demoSpringBeans.bll.HelloServiceImpl;

@Configuration
public class BeanConfigurator {
	
//	@Bean
//	public BonjourService bonjourService(String lang) {
//		if(lang.equals("francais")) {
//			return new BonjourServiceImpl();
//		}
//		return new HelloServiceImpl();
//	}

}
