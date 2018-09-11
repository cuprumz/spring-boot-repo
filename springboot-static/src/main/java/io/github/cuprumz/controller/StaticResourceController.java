package io.github.cuprumz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author cuprumz
 * @date 2018/09/11
 */
@Controller
public class StaticResourceController {

    @RequestMapping("/customize/**")
    public void getHTML(HttpServletRequest request, HttpServletResponse response) {
        String uri = request.getRequestURI();
        String[] arr = uri.split("customize/");
        String resourceName = "index.html";

        if (arr.length > 1) {
            resourceName = arr[1];
        }
        String url = StaticResourceController.class.getResource("/").getPath() + "html/" + resourceName;

        try {
            FileReader reader = new FileReader(new File(url));
            BufferedReader br = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            response.getOutputStream().write(sb.toString().getBytes());
            response.flushBuffer();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
