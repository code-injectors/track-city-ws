package code.injectors.track.city.ws.api;

import code.injectors.track.city.ws.domain.entity.municipality.Municipality;
import code.injectors.track.city.ws.domain.entity.report.Category;
import code.injectors.track.city.ws.domain.entity.user.Role;
import code.injectors.track.city.ws.domain.entity.user.User;
import code.injectors.track.city.ws.domain.repository.system.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Chatzakis Nikolaos
 */
@Profile("development")
@Component
public class SampleData implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final MediaRepository mediaRepository;
    private final MunicipalityRepository municipalityRepository;
    private final ReportRepository reportRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public SampleData(CategoryRepository categoryRepository, MediaRepository mediaRepository, MunicipalityRepository municipalityRepository, ReportRepository reportRepository, ReviewRepository reviewRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.categoryRepository = categoryRepository;
        this.mediaRepository = mediaRepository;
        this.municipalityRepository = municipalityRepository;
        this.reportRepository = reportRepository;
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // Categories
        final Category roadCategory = new Category();
        roadCategory.setName("Road");
        categoryRepository.save(roadCategory);
        final Category blockingCarCategory = new Category();
        blockingCarCategory.setName("Blocking car");
        categoryRepository.save(blockingCarCategory);
        final Category emergencyCategory = new Category();
        emergencyCategory.setName("Emergency");
        categoryRepository.save(emergencyCategory);

        final Municipality serresMunicipality = new Municipality();
        serresMunicipality.setName("Serres");
        municipalityRepository.save(serresMunicipality);
        final Municipality thessalonikiMunicipality = new Municipality();
        thessalonikiMunicipality.setName("Thessaloniki");
        municipalityRepository.save(thessalonikiMunicipality);
        final Municipality athensMunicipality = new Municipality();
        athensMunicipality.setName("Athens");
        municipalityRepository.save(athensMunicipality);

        final Role superUserRole = new Role();
        superUserRole.setName("SUPER_USER");
        roleRepository.save(superUserRole);
        final Role municipalityAdminRole = new Role();
        municipalityAdminRole.setName("MUNICIPALITY_ADMIN");
        roleRepository.save(municipalityAdminRole);
        final Role employeeRole = new Role();
        employeeRole.setName("EMPLOYEE");
        roleRepository.save(employeeRole);
        final Role clientRole = new Role();
        clientRole.setName("CLIENT");
        roleRepository.save(clientRole);

        final User superUser = new User();
        superUser.setEmail("admin@injectors.com");
        superUser.setFirstName("Super");
        superUser.setLastName("Admin");
        superUser.setRole(superUserRole);
        superUser.setPassword("tralala");
        final User createdSuperUser = userRepository.save(superUser);

        final User municipalityAdmin = new User();
        municipalityAdmin.setEmail("municipality.admin@injectors.com");
        municipalityAdmin.setFirstName("Serres");
        municipalityAdmin.setLastName("Municipality");
        municipalityAdmin.setRole(municipalityAdminRole);
        municipalityAdmin.setPassword("tralala");
        municipalityAdmin.setManager(createdSuperUser);
        final User createdMunicipalityAdmin = userRepository.save(municipalityAdmin);

        final User employee1 = new User();
        employee1.setEmail("employee1@injectors.com");
        employee1.setFirstName("Serres");
        employee1.setLastName("Municipality");
        employee1.setRole(employeeRole);
        employee1.setPassword("tralala");
        employee1.setManager(createdMunicipalityAdmin);
        final User createdEmployee1 = userRepository.save(employee1);

        final User employee2 = new User();
        employee2.setEmail("employee1@injectors.com");
        employee2.setFirstName("Serres");
        employee2.setLastName("Municipality");
        employee2.setRole(employeeRole);
        employee2.setPassword("tralala");
        employee2.setManager(createdMunicipalityAdmin);
        final User createdEmployee2 = userRepository.save(employee2);

        final User chbakouras = new User();
        chbakouras.setEmail("chbakouras@injectors.com");
        chbakouras.setFirstName("Chrisostomos");
        chbakouras.setLastName("Bakouras");
        chbakouras.setRole(clientRole);
        chbakouras.setPassword("tralala");
        userRepository.save(chbakouras);


        final User one = userRepository.findOne(createdSuperUser.getId());
    }
}
