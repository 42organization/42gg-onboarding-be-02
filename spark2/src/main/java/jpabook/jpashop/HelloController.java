package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello") //hello라는 url로 오면 이 컨트롤러가 호출됨
    public String hello(Model model) { //model에 데이터를 실어서 view에 넘길 수 있음
        model.addAttribute("data", "hello!!!!!");
        return "hello";
    }
}
