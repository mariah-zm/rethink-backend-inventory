package com.rethink.inventory.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ApiIgnore
@RestController
public class RedirectionController {

        @RequestMapping("/")
        public void redirect(HttpServletResponse response) throws IOException {
            response.sendRedirect("/swagger-ui/");
        }

}
