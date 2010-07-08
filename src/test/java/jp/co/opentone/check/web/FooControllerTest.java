package jp.co.opentone.check.web;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/app-config.xml"
})
public class FooControllerTest extends AbstractJUnit4SpringContextTests {
    
    @Resource
    FooController controller;
    @Resource(name="annotationMethodHandler")
    AnnotationMethodHandlerAdapter adapter;

    MockHttpServletRequest request;
    MockHttpServletResponse response;
    Jaxb2Marshaller marshaller;
    
    @Before
    public void setup() {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }
    
    @Test
    public void getFoo() throws Exception {
        request.setRequestURI("/foo/1");
        request.setMethod("GET");
        
        adapter.handle(request, response, controller);
        
        String content = response.getContentAsString();
        assertThat(content, notNullValue());
    }
    
    @Test
    public void getFooNotFound() throws Exception {
        request.setRequestURI("/foo/0");
        request.setMethod("GET");
        
        adapter.handle(request, response, controller);
        
        assertThat(response.getStatus(), is(HttpServletResponse.SC_NOT_FOUND));
    }
}
