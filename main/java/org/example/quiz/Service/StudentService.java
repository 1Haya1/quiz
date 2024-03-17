package org.example.quiz.Service;

import org.example.quiz.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class StudentService {


    ArrayList<Student> students = new ArrayList<>();




    public ArrayList<Student> getStudent(){
        return students ;
    }



    public void addStudent(Student student1){
        students.add(student1);
    }


    public Boolean updateStudent(int Id , Student student){

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == Id){
                students.set(i , student);
                return true ;
            }

        }
        return false ;
    }



    public Boolean deleteStudent(int Id){

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == Id){
                students.remove(i);
                return true ;
            }
        }
        return null ;
    }




    public Student searchByName(String SName){

        for (Student student : students){
            if (student.getName().equalsIgnoreCase(SName)){
                return student;
            }

        }
        return null ;
    }



    public ArrayList<Student> AllStudent(String major){

        ArrayList<Student> AllStudentM = new ArrayList<>();

        for (Student student : students){
            if (student.getMajor().equalsIgnoreCase(major)){
                AllStudentM.add(student);
            }
        }

        return AllStudentM ;

    }



}
