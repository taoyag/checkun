package jp.co.opentone.check.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.View;

@Controller
@RequestMapping("/foo")
public class FooController {
    /** logger. */
    private static Logger log = LoggerFactory.getLogger(FooController.class);

    @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
    public View handle(
            @RequestBody Foo foo,
            @PathVariable Long id) throws IOException {
        log.info("foo={}, id={}", foo.name, id);
        return new StatusOK();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Foo getFoo(@PathVariable Long id) throws Exception {
        if (id == 0L) {
            throw new NoDataFoundException(String.valueOf(id));
        }
        return new Foo("hooo");
    }
    
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoDataFoundException.class)
    public void handleNotFoundException(NoDataFoundException e, 
                HttpServletRequest request, 
                HttpServletResponse response) {
        log.warn("not found...", e);
    }
    
    static class StatusOK implements View {

        @Override
        public String getContentType() {
            return null;
        }

        @Override
        public void render(Map<String, ?> model, 
                HttpServletRequest request,
                HttpServletResponse response) throws Exception {
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
