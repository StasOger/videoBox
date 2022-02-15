package com.videoBox.controllers;

import com.videoBox.model.Post;
import com.videoBox.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class VideoController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/video")
    public String videoGallery(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "video-gallery";
    }

    @GetMapping("/video/add")
    public String videoAdd(Model model) {return "video-add";}

    @PostMapping("/blog/add")
    public String videoAdd(@RequestParam String comment, @RequestParam("video") MultipartFile video, Model model) throws IOException {

        Post post = new Post(comment);
        byte[] bVideo = video.getBytes();

        try (FileOutputStream fos = new FileOutputStream("D:/MUSIC/" + video.getOriginalFilename())) {
            fos.write(bVideo);
        }
        logger.info("video saved" + video.getOriginalFilename());

        post.setVideoPath(video.getOriginalFilename());
        postRepository.save(post);
        return "redirect:/blog";
    }
    private final Logger logger = LoggerFactory.getLogger(VideoController.class);

}
