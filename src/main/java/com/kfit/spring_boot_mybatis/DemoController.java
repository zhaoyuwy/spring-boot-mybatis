package com.kfit.spring_boot_mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;
//http://localhost:8080/likeName?name=zhangsan
    @RequestMapping("/likeName")
    public List<Demo> likeName(String name) {
        /*
         * 第一个参数：第几页;
		 * 第二个参数：每页获取的条数.
		 */
        PageHelper.startPage(1, 20);
        return demoService.likeName(name);
    }
//http://localhost:8080/save
    @RequestMapping("/save")
    public Demo save() {
        Demo demo = new Demo();
        demo.setName("zhangsan");
//        demo.setId(1);
        demoService.save(demo);
        return demo;
    }

}
