package com.example.demo.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import com.example.demo.entities.Staff;
import com.example.demo.repository.StaffRepository;

@SpringBootTest
@ActiveProfiles("test")
@Sql("/test-data.sql")
public class StaffServiceTest {
	@Mock
    private StaffRepository staffRepository;

    private Staff staff1 = new Staff(1,"canh@gmail.com","canh");
    private Staff staff2 = new Staff(2,"bao@gmail.com","bao");

    @InjectMocks
    private StaffServiceImpl staffServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getStaffById() {
        given(staffRepository.findById(1)).willReturn(Optional.of(staff1));

        Optional<Staff> result = staffServiceImpl.getStaffById(1);

        //assert
        assertThat(result).isEqualTo(staff1);

        //assert
        assertStaffFields(result.get());

        //verify that repository was called
        verify(staffRepository, times(1)).findById(1);
    }

    @Test
    public void getStaffByUsername() {
        given(staffRepository.findStaffByUsername("canh@gmail.com")).willReturn(staff1);

        Staff result = staffServiceImpl.getStaffByUsername("canh@gmail.com");

        assertThat(result).isEqualTo(staff1);

        assertStaffFields(result);

        verify(staffRepository, times(1)).findStaffByUsername("canh@gmail.com");
    }


    private void assertStaffFields(Staff staff) {
        assertThat(staff.getId()).isInstanceOf(Integer.class);
        assertThat(staff.getId()).isEqualTo(1);
        assertThat(staff.getUsername()).isEqualTo("canh@gmail.com");
        assertThat(staff.getName()).isEqualTo("canh");
    }
}
