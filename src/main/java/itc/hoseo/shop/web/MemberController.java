package itc.hoseo.shop.web;

import itc.hoseo.shop.domain.Member;
import itc.hoseo.shop.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @RequestMapping("/")
    public String index(ModelMap mm, HttpSession session){
        mm.put("members", memberRepository.findAll());
        return "index";
    };

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    };

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(ModelMap mm){
        return "signup";
    };

    @RequestMapping("/save")
    public String save(Member member){
        //memberRepository.save(member);
        return "redirect:/";
    };


    @RequestMapping("/dummyLogin")
    @ResponseBody
    public String login(String id, HttpSession session){
        session.setAttribute("id", id);
        return id;
    };

    @RequestMapping("/getLoginedId")
    @ResponseBody
    public String getLoginedId(HttpSession session){
        String id = (String)session.getAttribute("id");
        return id;
    };

}
