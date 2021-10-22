package rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/courses")
public class CoursesRegistrationActions {

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getCourse(@PathVariable("id") final int id){
       if(id==1)
        return ResponseEntity.ok("{ id:1, name:'Spring boot Microservices' }");
       else
           return ResponseEntity.notFound().build();
    }
}
