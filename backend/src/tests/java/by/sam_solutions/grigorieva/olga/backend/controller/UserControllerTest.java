//package by.sam_solutions.grigorieva.olga.backend.controller;
//
//
//import by.sam_solutions.grigorieva.olga.backend.entity.User;
//import by.sam_solutions.grigorieva.olga.backend.service.user.UserService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserService service;
//
//    @Test
//    public void createUser_whenPostMethod() throws Exception {
//
//        User user = new User();
//        user.setPassword("");
//        user.setUsername("");
//        user.setEmail("");
//        user.setNameCompany("");
//        user.setWildBerriesKeys("");
//
//        user.setRoles(List.of());
//        user.setPassword("");
//
//        user.setIsBlocked(false);
//        user.setIsSubscribed(false);
//
//        given(service.create(user)).willReturn(user);
//
//        mockMvc.perform(post("/admin/users")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(JsonUtil.toJson(user)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.name", is(user.getUsername())));
//    }
//}