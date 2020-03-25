package main.java.main;

import main.java.dao.StudentDao;
import main.java.entity.Student;

public class Main {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();
        Student student = studentDao.findById(9l);
        student.setName("Karen Sousa");
        studentDao.update(student);
    }
}


//    MyEntity e = new MyEntity();
//    MyEntity e2 = em.merge(e);
//    e2.setAtributo(novoValor);