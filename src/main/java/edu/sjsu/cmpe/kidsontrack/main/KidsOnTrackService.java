package edu.sjsu.cmpe.kidsontrack.main;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

import edu.sjsu.cmpe.kidsontrack.config.KidsOnTrackServiceConfiguration;
import edu.sjsu.cmpe.kidsontrack.controller.usermgnt.LoginController;

public class KidsOnTrackService extends Service<KidsOnTrackServiceConfiguration> {

    public static void main(String[] args) throws Exception {
	new KidsOnTrackService().run(args);
    }
//.........

    public void initialize(Bootstrap<KidsOnTrackServiceConfiguration> bootstrap) {
	bootstrap.setName("kidsontrack-service");
    }

  
    public void run(KidsOnTrackServiceConfiguration configuration,
	    Environment environment) throws Exception {
	/** Root API */
	environment.addResource(LoginController.class);

    }
}