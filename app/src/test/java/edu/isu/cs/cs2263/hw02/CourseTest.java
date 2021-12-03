package edu.isu.cs.cs2263.hw02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
//import org.mockito.junit.jupiter.MockitoExtension;

//@ExtendWith(MockitoExtension.class)
public class CourseTest {
    @Test void CourseHasAName(){
        Course classUnderTest = new Course();
        String name = "OO Programming";
        classUnderTest.setName(name);
        assertNotNull(classUnderTest.getName());
    }
    @Test void CourseHasANumber(){
        Course classUnderTest = new Course();
        assertNotNull(classUnderTest.getNumber());
    }
    @Test void CourseHasACode(){
        Course classUnderTest = new Course();
        String code = "2263";
        classUnderTest.setCode(code);
        assertNotNull(classUnderTest.getCode());
    }
    @Test void CourseHasACredits(){
        Course classUnderTest = new Course();
        assertNotNull(classUnderTest.getCredits());
    }
    @Test void CourseHasAtoString(){
        Course classUnderTest = new Course();
        assertNotNull(classUnderTest.toString());
    }

}
