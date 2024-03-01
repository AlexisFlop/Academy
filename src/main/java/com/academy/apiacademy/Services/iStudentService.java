package com.academy.apiacademy.Services;


import java.util.List;

import com.academy.apiacademy.Models.Student;

public interface iStudentService extends iCRUD<Student, Integer>{

    List<Student> orderStudentsDescByAge();
    
}
