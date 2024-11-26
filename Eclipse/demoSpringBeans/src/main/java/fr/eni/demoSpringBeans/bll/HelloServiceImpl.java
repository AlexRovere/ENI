package fr.eni.demoSpringBeans.bll;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("HelloService")
@Profile("anglais")
public class HelloServiceImpl implements BonjourService {
	
	public String direBonjour() {
		return "Hello world !";
	}
}
