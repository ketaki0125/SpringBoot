package com.infy.Demo;

import dto.ExamsDTO;
import dto.SubjectDTO;
import exception.InfyException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import repository.AccountRepository;
import service.SubjectService;
import service.SubjectServiceImpl;

@SpringBootTest
class DemoApplicationTests {

	@Mock
	AccountRepository repo;

	@InjectMocks
	SubjectService subjser= new SubjectServiceImpl();

	@Test
	public void subjectValidTest() throws InfyException {
		SubjectDTO subdto=new SubjectDTO();
		ExamsDTO examdto=new ExamsDTO();

		subdto.setSubjectId(1237);
		subdto.setSubjectName("English");
		subdto.setSubjectScore(78);
	examdto.setExamId(1004);
	examdto.setExamDate(2021-08-05);
	subdto.setExamsDTO(examdto);

	Mockito.when(repo.getSubject(1237).thenReturn(subdto));

	}

}
