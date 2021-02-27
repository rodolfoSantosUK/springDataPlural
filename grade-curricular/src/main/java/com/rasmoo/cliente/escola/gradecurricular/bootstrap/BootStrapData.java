package com.rasmoo.cliente.escola.gradecurricular.bootstrap;

import com.rasmoo.cliente.escola.gradecurricular.repository.EstudoJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {


    private final EstudoJpaRepository estudoJpaRepository;

    public BootStrapData(EstudoJpaRepository estudoJpaRepository) {
        this.estudoJpaRepository = estudoJpaRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");
        //estudoJpaRepository.salvarEmbeddedUser();
        //estudoJpaRepository.salvarOneToOneUnidirecionalCredencial();
        //estudoJpaRepository.salvarOneToManyUnidirecionalCredencial();
        //estudoJpaRepository.salvarOneToManyBidirecionalCredencial();
        estudoJpaRepository.salvarJoinTable();
    }
}
