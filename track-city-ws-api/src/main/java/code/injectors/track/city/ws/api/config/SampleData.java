package code.injectors.track.city.ws.api.config;

import code.injectors.track.city.ws.domain.entity.media.Media;
import code.injectors.track.city.ws.domain.entity.media.MediaType;
import code.injectors.track.city.ws.domain.entity.municipality.Municipality;
import code.injectors.track.city.ws.domain.entity.report.Category;
import code.injectors.track.city.ws.domain.entity.report.Report;
import code.injectors.track.city.ws.domain.entity.report.ReportStatus;
import code.injectors.track.city.ws.domain.entity.review.Review;
import code.injectors.track.city.ws.domain.entity.user.Role;
import code.injectors.track.city.ws.domain.entity.user.User;
import code.injectors.track.city.ws.domain.repository.media.MediaRepository;
import code.injectors.track.city.ws.domain.repository.municipality.MunicipalityRepository;
import code.injectors.track.city.ws.domain.repository.report.CategoryRepository;
import code.injectors.track.city.ws.domain.repository.review.ReviewRepository;
import code.injectors.track.city.ws.domain.repository.user.RoleRepository;
import code.injectors.track.city.ws.service.report.ReportService;
import code.injectors.track.city.ws.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

/**
 * @author Chatzakis Nikolaos
 */
@Profile("development")
@Component
public class SampleData implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final MediaRepository mediaRepository;
    private final MunicipalityRepository municipalityRepository;
    private final ReportService reportService;
    private final ReviewRepository reviewRepository;
    private final UserService userService;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SampleData(CategoryRepository categoryRepository, MediaRepository mediaRepository, MunicipalityRepository municipalityRepository, ReportService reportService, ReviewRepository reviewRepository, UserService userService, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.categoryRepository = categoryRepository;
        this.mediaRepository = mediaRepository;
        this.municipalityRepository = municipalityRepository;
        this.reportService = reportService;
        this.reviewRepository = reviewRepository;
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        final String tralala = passwordEncoder.encode("tralala");

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

        // Municipalities
        final Municipality serresMunicipality = new Municipality();
        serresMunicipality.setName("Serres");
        serresMunicipality.setLatitude(41.0849900);
        serresMunicipality.setLongitude(23.5475700);
        municipalityRepository.save(serresMunicipality);
        final Municipality thessalonikiMunicipality = new Municipality();
        thessalonikiMunicipality.setName("Thessaloniki");
        thessalonikiMunicipality.setLatitude(41.0849900);
        thessalonikiMunicipality.setLongitude(23.5475700);
        municipalityRepository.save(thessalonikiMunicipality);
        final Municipality athensMunicipality = new Municipality();
        athensMunicipality.setName("Athens");
        athensMunicipality.setLatitude(41.0849900);
        athensMunicipality.setLongitude(23.5475700);
        municipalityRepository.save(athensMunicipality);

        // Roles
        final Role superUserRole = new Role();
        superUserRole.setName("SUPER_USER");
        superUserRole.setTitle("Super User");
        roleRepository.save(superUserRole);
        final Role municipalityAdminRole = new Role();
        municipalityAdminRole.setName("MUNICIPALITY_ADMIN");
        municipalityAdminRole.setTitle("Municipality Admin");
        roleRepository.save(municipalityAdminRole);
        final Role employeeRole = new Role();
        employeeRole.setName("EMPLOYEE");
        employeeRole.setTitle("Employee");
        roleRepository.save(employeeRole);
        final Role clientRole = new Role();
        clientRole.setName("CLIENT");
        clientRole.setTitle("Client");
        roleRepository.save(clientRole);

        // Users
        final User superUser = new User();
        superUser.setEmail("superuser@example.com");
        superUser.setFirstName("Super");
        superUser.setLastName("Admin");
        superUser.setRole(superUserRole);
        superUser.setPassword(tralala);
        final User createdSuperUser = userService.create(superUser)
                .getOrElseThrow(throwable -> new RuntimeException(throwable));

        final User municipalityAdmin = new User();
        municipalityAdmin.setEmail("municipality@example.com");
        municipalityAdmin.setFirstName("Serres");
        municipalityAdmin.setLastName("Municipality");
        municipalityAdmin.setRole(municipalityAdminRole);
        municipalityAdmin.setPassword(tralala);
        municipalityAdmin.setManager(createdSuperUser);
        final User createdMunicipalityAdmin = userService.create(municipalityAdmin)
                .getOrElseThrow(throwable -> new RuntimeException(throwable));

        final User employee1 = new User();
        employee1.setEmail("employee1@example.com");
        employee1.setFirstName("John");
        employee1.setLastName("Doe");
        employee1.setRole(employeeRole);
        employee1.setPassword(tralala);
        employee1.setManager(createdMunicipalityAdmin);
        final User createdEmployee1 = userService.create(employee1)
                .getOrElseThrow(throwable -> new RuntimeException(throwable));

        final User employee2 = new User();
        employee2.setEmail("employee2@example.com");
        employee2.setFirstName("Foo");
        employee2.setLastName("Bar");
        employee2.setRole(employeeRole);
        employee2.setPassword(tralala);
        employee2.setManager(createdMunicipalityAdmin);
        final User createdEmployee2 = userService.create(employee2)
                .getOrElseThrow(throwable -> new RuntimeException(throwable));

        final User chbakouras = new User();
        chbakouras.setEmail("chbakouras@injectors.com");
        chbakouras.setFirstName("Chrisostomos");
        chbakouras.setLastName("Bakouras");
        chbakouras.setRole(clientRole);
        chbakouras.setPassword(tralala);
        userService.create(chbakouras);
        final User nchatzak = new User();
        nchatzak.setEmail("nchatzak@injectors.com");
        nchatzak.setFirstName("Nikolaos");
        nchatzak.setLastName("Chatzakis");
        nchatzak.setRole(clientRole);
        nchatzak.setPassword(tralala);
        userService.create(nchatzak);

        // Actual data
        IntStream.rangeClosed(1, 20)
                .forEach(value -> {
                    final Media media = new Media();
                    media.setMeta("Blocking car!");
                    media.setName("Blocking car!");
                    media.setType(MediaType.IMAGE);
                    final Media createdMedia = mediaRepository.save(media);

                    final Review review1 = new Review();
                    review1.setUpvote(true);
                    review1.setComment("Έχει δίκιο το παλικάρι! Έλεος πια!");
                    review1.setUser(nchatzak);
                    final Review createdReview1 = reviewRepository.save(review1);

                    final Review review2 = new Review();
                    review2.setUpvote(true);
                    review2.setComment("+1");
                    review2.setUser(nchatzak);
                    final Review createdReview2 = reviewRepository.save(review2);

                    final Report report = new Report();
                    report.setMedia(Collections.singletonList(createdMedia));
                    report.setCategory(blockingCarCategory);
                    report.setCreator(nchatzak);
                    report.setLatitude(41.0849900);
                    report.setLongitude(23.5475700);
                    report.setStatus(ReportStatus.PENDING);
                    report.setDescription("Έχει αποκλειστεί όλη η περιοχή και δεν περνάνε λεωφορεία.");
                    report.setTitle("Ο Φελλός άφησε το αυτοκίνητο του πάνω στην διάβαση πεζών " + value);
                    report.setReviews(Arrays.asList(createdReview1, createdReview2));
                    reportService.create(report);
                });

        IntStream.rangeClosed(1, 20)
                .forEach(value -> {
                    final Media media = new Media();
                    media.setMeta("Wow!");
                    media.setName("...");
                    media.setType(MediaType.IMAGE);
                    final Media createdMedia = mediaRepository.save(media);

                    final Review review = new Review();
                    review.setUpvote(true);
                    review.setComment("Fix it please.");
                    review.setUser(nchatzak);
                    final Review createdReview = reviewRepository.save(review);

                    final Report report = new Report();
                    report.setMedia(Collections.singletonList(createdMedia));
                    report.setCategory(emergencyCategory);
                    report.setCreator(nchatzak);
                    report.setLatitude(41.0849900);
                    report.setLongitude(23.5475700);
                    report.setStatus(ReportStatus.PENDING);
                    report.setDescription("Whatever description.");
                    report.setTitle("Whatever title " + value);
                    report.setReviews(Collections.singletonList(createdReview));
                    reportService.create(report);
                });

        IntStream.rangeClosed(1, 20)
                .forEach(value -> {
                    final Media media = new Media();
                    media.setMeta("Λακούβες 1");
                    media.setName("Λακούβες 1");
                    media.setType(MediaType.IMAGE);
                    final Media createdMedia = mediaRepository.save(media);

                    final Review review = new Review();
                    review.setUpvote(true);
                    review.setComment("Ναι, και γω πού πέρασα πριν ήταν χάλια ο δρόμος. Από τις τελευταίες βροχές έχουν ανοίξει πολλές τρύπες.");
                    review.setUser(nchatzak);
                    final Review createdReview = reviewRepository.save(review);

                    final Report report = new Report();
                    report.setMedia(Collections.singletonList(createdMedia));
                    report.setCategory(roadCategory);
                    report.setCreator(nchatzak);
                    report.setLatitude(41.0849900);
                    report.setLongitude(23.5475700);
                    report.setStatus(ReportStatus.NEW);
                    report.setDescription("Έξω από το σπίτι μου επικρατεί η κατάσταση που φαίνεται στις φωτογραφίες. Παρακαλώ κάντε κάτι, δεν μπορώ να βγω με το αμάξι!");
                    report.setTitle("Λακούβες παντού " + value);
                    report.setReviews(Collections.singletonList(createdReview));
                    reportService.create(report);
                });

    }
}
