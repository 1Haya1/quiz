package org.example.quiz.Service;

import org.example.quiz.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<>();




    public ArrayList<Teacher> getTeacher(){
        return teachers;
    }


    public void addTeacher (Teacher teacher){

        teachers.add(teacher);

    }


    public Boolean updateTeacher(int Id , Teacher teacher){

        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == Id){
                teachers.set(i , teacher);
                return true ;
            }

        }
        return false ;

    }




    public Boolean deleteTeacher(int Id){

        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == Id){
                teachers.remove(i);
                return true ;
            }
        }
        return null ;
    }




    public Teacher searchById(int Id){

        for (Teacher teacher : teachers){
            if (teacher.getId().equals(Id)){
                return teacher ;
            }
        }
        return null ;
    }



    public ArrayList<Teacher> getSalary(int salary){

        ArrayList<Teacher> getSalary = new ArrayList<>();

        for (Teacher teacher : teachers){
            if (teacher.getSalary() >= salary){
                getSalary.add(teacher);
            }
        }

        return getSalary;
    }


}
