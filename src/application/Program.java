package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.ProfessorDao;
import model.entities.Department;
import model.entities.Professor;

public class Program {

	public static void main(String[] args) {
		
		/*
		System.out.println("==== Teste 1 - Department entity class ==== \n");
	
		Department obj = new Department(1, "Computer Engeneering");
		System.out.println(obj);
		
		
		System.out.println("==== Teste 2 - Professor entity class ==== \n");
		
		Professor professor = new Professor(21, "Nilton", "nilton@gmail.com", new Date(), 1112224, 3000.0, obj);
		System.out.println(professor);
		*/

		Scanner sc = new Scanner(System.in);
		
		//Chamar a interface (DaoFactory) 
		ProfessorDao professorDao = DaoFactory.createProfessorDao();
		

		System.out.println("=== Teste 3: Professor findById ===== \n");
		
		Professor professor = professorDao.findById(3);
		System.out.println(professor);
		
		
		System.out.println("\n=== Teste 4: professor findByDepartment =====");
		
		Department department = new Department(2, null);
		List<Professor> list = professorDao.findByDepartment(department);
		for (Professor obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 5: professor findAll =====");
		list = professorDao.findAll();
		for (Professor obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== Teste 6: professor insert =====");
		Professor newProfessor = new Professor(null, "George", "geor@gmail.com", new Date(), 112233, 4000.0, department);
		professorDao.insert(newProfessor);
		System.out.println("Inserted! New id = " + newProfessor.getId());

		System.out.println("\n=== Teste 7: professor update =====");
		professor = professorDao.findById(1);
		professor.setName("Martha");
		professorDao.update(professor);
		System.out.println("Update completed");

		System.out.println("\n=== Teste 8: professor delete =====");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		professorDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
}
