package de.tekup.demo.data.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import de.tekup.demo.data.service.WhiteTestService;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;
@Endpoint
public class WhiteTestEndpoint {
	public static final String namespace = "http://www.tekup.de/soap/models/whitetest" ;
	@Autowired
	private WhiteTestService service ;
	
	
	@PayloadRoot(namespace = namespace, localPart = "StudentRequest")
	@ResponsePayload
	public WhiteTestResponse getTests(@RequestPayload StudentRequest studentRequest) {
		return service.whiteTest(studentRequest);
		
	}


}
