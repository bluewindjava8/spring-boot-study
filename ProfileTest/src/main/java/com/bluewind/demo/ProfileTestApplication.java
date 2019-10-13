package com.bluewind.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.SimpleCommandLinePropertySource;

@SpringBootApplication
public class ProfileTestApplication {

//	public static void main(String[] args) {
//		ApplicationContext context = SpringApplication.run(ProfileTestApplication.class, args);
//		Environment env = context.getEnvironment();
//		List<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
//		System.out.println("active profiles are " + activeProfiles);
//	}
	
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ProfileTestApplication.class);
//		SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
//		addDefaultProfile(app, source);
		app.run(args);
		System.out.println("---------------------app start------------------");
	}

	/**
	 * If no profile has been configured in command line arguments or environment variables, set by default the "dev" profile.
	 */
	private static void addDefaultProfile(SpringApplication app, SimpleCommandLinePropertySource source) {
		System.out.println("source.containsProperty(\"spring.profiles.active\") = " + source.containsProperty("spring.profiles.active"));
		System.out.println("System.getenv().containsKey(\"SPRING_PROFILES_ACTIVE\") = " + System.getenv().containsKey("SPRING_PROFILES_ACTIVE"));

		if (!source.containsProperty("spring.profiles.active") //This only check whether the application argument contains spring.profiles.active, not including the JVM parameters like -Dspring.profiles.active=prod
				&& !System.getenv().containsKey("SPRING_PROFILES_ACTIVE")) {
			
	
			app.setAdditionalProfiles("dev");
		}
	}

}
