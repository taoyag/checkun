package jp.co.opentone.check.web;

import jp.co.opentone.check.entity.CheckDefinition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/def")
public class CheckDefinitionController {

    /** logger. */
    private static Logger log = LoggerFactory.getLogger(CheckDefinitionController.class);
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CheckDefinition get(@PathVariable Long id) {
        //TODO
        return null;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public View save(@RequestBody CheckDefinition def) {
        //TODO
        return new RedirectView(String.format("/def/%s", def.id));
    }
}
