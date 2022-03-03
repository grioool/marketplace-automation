//package by.sam_solutions.grigorieva.olga.backend.controller.exception.handler;
//
//import by.sam_solutions.grigorieva.olga.backend.config.HibernateConfiguration;
//import by.sam_solutions.grigorieva.olga.backend.service.user.UserService;
//import junit.framework.TestCase;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = HibernateConfiguration.class)
//@AutoConfigureMockMvc(addFilters = false)
//public class BusinessExceptionHandlerTest extends TestCase {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserService userService;
//
//    public void testHandleAuthorizationException() {
//    }
//
//    public void testHandleUserAlreadyExists() {
//
//        this.mockMvc.perform(get("/registration"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.size()", is(userList.size())));
//    }
//
//    public void testHandleEmailAlreadyExists() {
//
//
//        this.mockMvc.perform(get("/registration"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.size()", is(userList.size())));
//    }
//
//    public void testHandleBusinessException() {
//    }
//
//    public void testHandleTokenInvalid() {
//    }
//
//    public void testHandleNotImplementedExceptions() {
//    }
//
//    public void testHandlerInternalExceptions() {
//    }
//
//    public void testHandleBadCredentialsException() {
//    }
//
//    public void testHandleUsernameNotFoundException() {
//
//        this.mockMvc.perform(get("/login"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.size()", is(userList.size())));
//    }
//
//    public void testTestHandleBadCredentialsException() {
//    }
//
//    public void testHandleManyRequestException() {
//    }
//
//    public void testHandleConversionException() {
//    }
//
//    public void testHandleMethodNotValidException() {
//    }
//
//    public void testHandleNullPointerException() {
//    }
//
//    public void testHandleLocalizationException() {
//    }
//
//    public void testHandleDatabaseIntegrityException() {
//    }
//
//    public void testHandleConstraintViolationException() {
//    }
//
//    public void testHandlePSQLException() {
//    }
//
//    public void testHandleIllegalArgumentException() {
//    }
//}