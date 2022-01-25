package com.inspire12.practice.lab;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;

@ExtendWith({ RestDocumentationExtension.class, SpringExtension.class })
@SpringBootTest(classes = Inspire12LabApplication.class)
public class SpringRestDocsIntegrationTest {
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup(WebApplicationContext webApplicationContext,
                      RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .build();
    }

//    @Test
//    public void whenGetFooById_thenSuccessful() throws Exception {
//        ConstraintDescriptions desc = new ConstraintDescriptions(Foo.class);
//        this.mockMvc.perform(get("/foo/{id}", 1))
//                .andExpect(status().isOk())
//                .andDo(document("getAFoo", preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        pathParameters(parameterWithName("id").description("id of foo to be searched")),
//                        responseFields(fieldWithPath("id")
//                                        .description("The id of the foo" +
//                                                collectionToDelimitedString(desc.descriptionsForProperty("id"), ". ")),
//                                fieldWithPath("title").description("The title of the foo"),
//                                fieldWithPath("body").description("The body of the foo"))));
//    }
}