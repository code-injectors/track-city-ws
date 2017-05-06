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
import code.injectors.track.city.ws.domain.repository.report.ReportRepository;
import code.injectors.track.city.ws.domain.repository.review.ReviewRepository;
import code.injectors.track.city.ws.domain.repository.user.RoleRepository;
import code.injectors.track.city.ws.domain.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
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
        final User nchatzak = new User();
        nchatzak.setEmail("nchatzak@injectors.com");
        nchatzak.setFirstName("Nikolaos");
        nchatzak.setLastName("Chatzakis");
        nchatzak.setRole(clientRole);
        nchatzak.setPassword("tralala");
        userRepository.save(nchatzak);

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
                    reportRepository.save(report);
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
                    reportRepository.save(report);
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
                    reportRepository.save(report);
                });

    }
}
