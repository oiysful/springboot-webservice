package com.ian.springboot.web;

import com.ian.springboot.config.auth.LoginUser;
import com.ian.springboot.config.auth.dto.SessionUser;
import com.ian.springboot.service.posts.PostsService;
import com.ian.springboot.service.users.UsersService;
import com.ian.springboot.web.dto.PostsResponseDto;
import com.ian.springboot.web.dto.UsersResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final UsersService usersService;
    private final PostsService postsService;
    private UsersResponseDto usersResponseDto;
    private PostsResponseDto postsResponseDto;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {

        if(user != null) {
            model.addAttribute("userName", user.getName());
            return "redirect:/posts";
        }
        return "index";
    }

    @GetMapping("/user/{id}")
    public String user(@PathVariable Long id, Model model) {
        usersResponseDto = usersService.findById(id);
        model.addAttribute("user", usersResponseDto);
        return "users/detail";
    }

    @GetMapping("/posts")
    public String posts(@LoginUser SessionUser user, Model model) {
        usersResponseDto = usersService.findByEmail(user.getEmail());
        model.addAttribute("user", usersResponseDto);
        model.addAttribute("posts", postsService.findAllDesc());
        return "posts/list";
    }

    @GetMapping("/posts/save")
    public String postsSave(@LoginUser SessionUser user, Model model) {
        model.addAttribute("userName", user.getName());
        model.addAttribute("userEmail", user.getEmail());
        return "posts/save";
    }

    @GetMapping("/posts/{id}")
    public String postsDetail(@LoginUser SessionUser user, @PathVariable Long id, Model model) {
        usersResponseDto = usersService.findByEmail(user.getEmail());
        model.addAttribute("user", usersResponseDto);
        postsResponseDto = postsService.findById(id);
        model.addAttribute("author", user.getEmail().equals(postsResponseDto.getEmail()));
        model.addAttribute("post", postsResponseDto);

        return "posts/detail";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        postsResponseDto = postsService.findById(id);
        model.addAttribute("post", postsResponseDto);

        return "posts/update";
    }
}
