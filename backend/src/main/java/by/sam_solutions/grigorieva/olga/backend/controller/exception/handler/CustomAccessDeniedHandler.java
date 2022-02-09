//package by.sam_solutions.grigorieva.olga.backend.controller.exception.handler;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.access.AccessDeniedHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//
//public class CustomAccessDeniedHandler implements AccessDeniedHandler {
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
//        HashMap<String, String> map = new HashMap<>(2);
//        map.put("uri", request.getRequestURI());
//        map.put("msg", "Authentication failed");
//        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//        response.setCharacterEncoding("utf-8");
//        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String resBody = objectMapper.writeValueAsString(map);
////        PrintWriter printWriter = response.getWriter();
////        printWriter.print(resBody);
////        printWriter.flush();
////        printWriter.close();
//    }
//}
