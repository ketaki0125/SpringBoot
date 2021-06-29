package dapi;

import dto.SubjectDTO;
import exception.InfyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import service.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/infysubject")
@Validated
@ComponentScan
public class SubjectAPI {
    @Autowired
    private SubjectService service;

    @Autowired
    private Environment env;

    @GetMapping("/subjects") //, produces= MediaType.TEXT_XML_VALUE)
    public ResponseEntity<List<SubjectDTO>> getAllSubjects() throws InfyException {
        List<SubjectDTO> subList = service.getAllSubjects();
        return new ResponseEntity<>(subList, HttpStatus.OK);
    }

    @GetMapping(value = "/subjects/{subjectId}")
    public ResponseEntity<SubjectDTO> getSubject(@PathVariable long subjectId) throws InfyException {
        SubjectDTO subject = service.getSubject(subjectId);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }
    @PostMapping(value = "/subjects")
    public ResponseEntity<String> addCustomer( @RequestBody SubjectDTO sub) throws InfyException {
        long subjectId = service.addSubject(sub);
        String successMessage = env.getProperty("API.INSERT_SUCCESS") + subjectId;
        return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }
    @PutMapping(value = "/subjects/{subjectId}")
    public ResponseEntity<String> updateCustomer(@PathVariable long subjectId, @RequestBody SubjectDTO sub)
            throws InfyException {
        service.updateSubject(subjectId, sub.getSubjectName(), sub.getSubjectScore());
        String successMessage = env.getProperty("API.UPDATE_SUCCESS");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }
    @DeleteMapping(value = "/subjects/{subjectId}")
    public ResponseEntity<String> deleteSubject(@PathVariable long subjectId) throws InfyException {
        service.deleteSubject(subjectId);
        String successMessage = env.getProperty("API.DELETE_SUCCESS");
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

}
