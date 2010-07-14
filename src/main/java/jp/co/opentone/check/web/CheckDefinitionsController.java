package jp.co.opentone.check.web;

import jp.co.opentone.check.entity.CheckDefinition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/checkDefinitions")
public class CheckDefinitionsController {

    /** logger. */
    private static Logger log = LoggerFactory.getLogger(CheckDefinitionsController.class);
    
    public static String getBaseUrl() {
        String name = CheckDefinitionsController.class.getSimpleName();
        return name.substring(0, 1).toLowerCase() + 
                name.substring(1, name.lastIndexOf("Controller"));
    }
    
    public static String createUrl(String path) {
        return String.format("%s/%s", getBaseUrl(), path);
    }
    /**
     * 新しいチェック定義の登録フォームを生成します。
     * @param model 登録フォームを生成するModel情報
     * @return 登録フォームのURL
     */
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newCheckDefinition(Model model) {
        model.addAttribute(new CheckDefinition());
        return createUrl("newForm");
    }
    
    /**
     * idで指定されたチェック定義を更新するフォームを生成します。
     * @param id チェック定義を一意に識別するid
     * @param model 更新フォームを生成するModel情報
     * @return 更新フォームのURL
     */
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editCheckDefinition(@PathVariable Long id, Model model) {
        //TODO
        model.addAttribute(new CheckDefinition());
        return createUrl("editForm");
    }
    
    /**
     * idで指定されたチェック定義を表示します。
     * @param id チェック定義を一意に識別するid
     * @return チェック定義
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CheckDefinition show(@PathVariable Long id) {
        //TODO
        return null;
    }
    
    /**
     * 新しいチェック定義を登録します。
     * @param def 登録対象
     * @return 遷移先
     */
    @RequestMapping(method = RequestMethod.POST)
    public View create(@RequestBody CheckDefinition def) {
        //TODO
        return new RedirectView(createUrl(String.valueOf(def.id)));
    }
    
    /**
     * チェック定義を更新します。
     * @param id 更新対象のid
     * @param def 更新対象
     * @return 遷移先
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public View update(@PathVariable Long id, @RequestBody CheckDefinition def) {
        //TODO
        return new RedirectView(createUrl(String.valueOf(def.id)));
    }
    
    /**
     * チェック定義を削除します。
     * @param id 削除対象のid
     * @return 遷移先
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public View destroy(@PathVariable Long id) {
        //TODO
        return new RedirectView(getBaseUrl());
    }
}
