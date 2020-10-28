package youngjae.study.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import youngjae.study.domain.Article;
import youngjae.study.repository.ArticleRepository;
import youngjae.study.service.PageN;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    PageN page;

    @GetMapping("")
    public String getArticleList(Model model) {
//        List<Article> articleList = articleRepository.findAll();
//        model.addAttribute("articleList", articleList);
//        articleList.forEach(System.out::println);

        model.addAttribute("articleList", articleRepository.findAll(PageRequest.of(page.getPageNumber()-1,5)));
        model.addAttribute("pageNumber", page.getPageNumber());

        return "main";
    }

    @GetMapping("next/")
    public String nextPage( Model model) {

//        articleRepository.findAll(PageRequest.of(pageNumber-1,5));
        page.nextPageNumber();
//        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articleList", articleRepository.findAll(PageRequest.of(page.getPageNumber()-1,5)));
//        articleList.forEach(System.out::println);
        model.addAttribute("pageNumber", page.getPageNumber());
        return "main";
    }
    @GetMapping("prev/")
    public String prevPage( Model model) {
//        List<Article> articleList = articleRepository.findAll();
//        articleList.forEach(System.out::println);

        page.prevPageNumber();

        if(page.getPageNumber() != 1){

        model.addAttribute("pageNumber",page.getPageNumber());

        }

        model.addAttribute("articleList", articleRepository.findAll(PageRequest.of(page.getPageNumber()-1,5)));

        //페이지가 0이 될떄 를 작성
        return "main";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}







