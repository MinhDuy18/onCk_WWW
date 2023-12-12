package vn.edu.iuh.fit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.entites.Candidate;
import vn.edu.iuh.fit.entites.Experience;
import vn.edu.iuh.fit.entites.Role;
import vn.edu.iuh.fit.reponsitory.CandidateReponsitoty;
import vn.edu.iuh.fit.reponsitory.ExperienceReponsitory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OnCkApplication {
	@Autowired
	private CandidateReponsitoty candidateReponsitoty;
	@Autowired
	private ExperienceReponsitory experienceReponsitory;

	@Bean
	CommandLineRunner insertCandidate() {
		return args -> {
			Candidate can1 = new Candidate(1,"Nguyen Minh Duy","0793427848","dyybine.dev@gmail.com",null);
			Candidate can2 = new Candidate(2,"Chanh Tung Duong","0793427848","dyybine.dev@gmail.com",null);
			Experience exp1 = new Experience(1, LocalDate.of(2023,5,10),LocalDate.of(2023,10,20),"Dev Fesher","DyyCompany", Role.MANAGER,can1);
			Experience exp2 = new Experience(2, LocalDate.of(2023,5,10),LocalDate.of(2023,10,20),"Dev Fesher","DyyCompany", Role.MANAGER,can2);

			List<Candidate> cans = new ArrayList();
			cans.add(can1);
			cans.add(can2);

			for (Candidate can: cans
				 ) {
				System.out.println(can);
				candidateReponsitoty.save(can);
			}

			List<Experience> list =  new ArrayList();
			list.add(exp1);
			list.add(exp2);



			for (Experience exp: list
			) {
				System.out.println(exp);
			experienceReponsitory.save(exp);
			}

		};
	}

	public static void main(String[] args) {

		SpringApplication.run(OnCkApplication.class, args);


	}






}
