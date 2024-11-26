package fr.eni.demoSpringBeans.bll;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service("BonjourService")
@Profile("francais")
public class BonjourServiceImpl implements BonjourService {
	
	public String direBonjour() {
		return "Bonjour tout le monde ! ";
	}
}
