package edu.isu.cs.cs2263.hw02;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.robot.Robot;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.robot.ClickRobot;
import org.testfx.robot.MouseRobot;

import javafx.stage.Stage;
import javafx.scene.control.Label;
import org.testfx.framework.junit5.ApplicationTest;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
public class AppTest extends ApplicationTest {
    private App app;

    @BeforeEach
    @Override
    public void start(Stage stage) throws Exception{
        app = new App();
        app.start(stage);
        stage.setScene(app.getScene());
        stage.show();
        stage.toFront();

        Course testCourse = new Course("Intro to Programming","CS", 1181,4);
        app.addCourse(testCourse);

        app.getSelectedDepartment();
        app.showCourseForm();
        app.displayList();
        app.showWelcome();
        app.exit();
    }
    @Test
    void displayButtonHasText(){
        Parent mainNode = app.getScene().getRoot();
        Button displayButton = from(mainNode).lookup(".button").query();
        Assertions.assertEquals("Display (dept.)", displayButton.getText());
    }

    @Test
    void addCourseCorrectly() {
        String name = app.getCourses().get(0).getName();
        String code = app.getCourses().get(0).getCode();
        Integer num = app.getCourses().get(0).getNumber();
        Integer credits = app.getCourses().get(0).getCredits();
        System.out.println(app.getCourses().get(0).toString());
        assertAll(()->assertEquals(name, "Intro to Programming"),
                ()->assertEquals(code, "CS"),
                ()->assertEquals(num,1181),
                ()->assertEquals(credits,4));

    }
    @Test
    void courseViewAddTest(){
        clickOn("#newCourse");
        clickOn("tfName").type(KeyCode.T);
        clickOn("#btnAddCourse");
        assertNotNull(app.getCourses());
        Vector courses = app.getCourses();
        assertTrue(courses.size()>1);
    }
    @Test
    void courseViewErrorSuccess(){
        clickOn("#newCourse");
        clickOn("#btnAddCourse");
        assertEquals("[]",app.getCourses().toString());

    }
    @Test
    void courseViewResetTest(){
        clickOn("#newCourse");
        clickOn("tfName").type(KeyCode.T);
        clickOn("#btnAddCourse");
        assertEquals("[]",app.getCourses().toString());

    }
    @Test
    void courseViewNoNullString(){
        Course tCourseA = new Course("","",0,0);
        Course tCourseB = new Course(null,null,0,0);

        app.addCourse(tCourseA);
        app.addCourse(tCourseB);
        Vector courses = app.getCourses();
        assertTrue(courses.size()==1);
    }
    @Test
    void exitTest(){
        clickOn("#exit");
    }
}
