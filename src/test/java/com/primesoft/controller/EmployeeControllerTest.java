package com.primesoft.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.primesoft.dto.EmployeeDto;
import com.primesoft.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes = EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    void saveEmployee()throws Exception {

        Mockito.when(employeeService.saveEmployee(Mockito.any(EmployeeDto.class)))
                .thenReturn((getEmployeeDTO()));

        mockMvc.perform(MockMvcRequestBuilders.post("/employee")
                .content(asJsonString(getEmployeeDTO()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("anr@yopmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.empName").value("john"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.createdBy").value("John"));
    }

    public static String asJsonString(final EmployeeDto obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    EmployeeDto getEmployeeDTO(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmail("anr@yopmail.com");
        employeeDto.setEmpName("john");
        employeeDto.setId(UUID.randomUUID());
        employeeDto.setCreatedBy("John");
        return employeeDto;

    }
}