package kevat25.friend.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kevat25.friend.domain.Friend;



@Controller
public class FriendController {

    public static List<Friend> friends = new ArrayList<>();

    @GetMapping("/add")
    public String addFriend (Model model) {
        model.addAttribute("friend", new Friend());
        return "add";
    }

    @PostMapping("/add")
    public String addFriend(Friend friend) {
        friends.add(friend);        
        return "redirect:/friends";
    }

    @GetMapping("/friends")
    public String getFriends(Model model) {
        model.addAttribute("friends", friends);
        return "friends";
    }
    
    
}
