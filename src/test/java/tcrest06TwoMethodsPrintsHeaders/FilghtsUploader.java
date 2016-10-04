package tcrest06TwoMethodsPrintsHeaders;

import org.springframework.core.io.FileSystemResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;



import org.junit.Before;
import org.junit.Test;


//from http://www.aerospike.com/blog/build-restful-web-service-with-spring-boot/


public class FilghtsUploader {

private static final String TEST_FILE = "random-file.txt";

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void upload() {
		RestTemplate template = new RestTemplate();
		MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
		parts.add("name", TEST_FILE);
		parts.add("file", new FileSystemResource(TEST_FILE));
		String response = template.postForObject("http://localhost:8080/tcrest06TwoMethodsPrintsHeaders/post/a/file",
		parts, String.class);
		System.out.println(response);
	}
}
