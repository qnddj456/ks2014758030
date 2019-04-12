package ac.kr.web.domain;


import ac.kr.web.repository.BasicRepository;
import ac.kr.web.repository.LocationRepository;
import ac.kr.web.repository.ProfileRepository;
import ac.kr.web.repository.WorkRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class TestCreateRead {

    @Autowired
    private BasicRepository basicRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private WorkRepository workRepository;

    private Basic savedBasic;
    private Location savedLocation;
    private Profile savedProfile;
    private Work savedWork;

    @Before
    public void init() {
        savedBasic = basicRepository.save(Basic.builder()
                .name("홍길동")
                .label("웹 프로그래머")
                .email("홍길동@메일주소.도메인")
                .phone("000-1234-5678")
                .build());

        savedLocation = locationRepository.save(Location.builder()
                .address("부산광역시 00구 00번길 000")
                .postCode("12345")
                .build());

        savedProfile = profileRepository.save(Profile.builder()
                .netWork("Twitter")
                .userName("홍길동")
                .url("http://www.twitter.com/홍길동")
                .build());

        savedWork = workRepository.save(Work.builder()
                .company("(주)홍길동")
                .position("개발자")
                .webSite("http://www.company.domain")
                .startDate(LocalDate.of(2019, 01, 01))
                .endDate(LocalDate.of(2019,01,02))
                .summary("...요약")
                .build());
    }

    @Test
    public void testReadBasic() {
        Basic readBasic = basicRepository
                .findById(savedBasic.getName())
                .orElse(null);

        assertThat(readBasic.getName()).isEqualTo(savedBasic.getName());
        assertThat(readBasic.getEmail()).isEqualTo(savedBasic.getEmail());
        assertThat(readBasic.getLabel()).isEqualTo(savedBasic.getLabel());
        assertThat(readBasic.getPhone()).isEqualTo(savedBasic.getPhone());
    }

    @Test
    public void testReadLocation() {
        Location readLocation = locationRepository
                .findById(savedLocation.getAddress())
                .orElse(null);

        assertThat(readLocation.getAddress()).isEqualTo(savedLocation.getAddress());
        assertThat(readLocation.getPostCode()).isEqualTo(savedLocation.getPostCode());
    }

    @Test
    public void testReadProfile() {
        Profile readProfile = profileRepository
                .findById(savedProfile.getUserName())
                .orElse(null);

        assertThat(readProfile.getNetWork()).isEqualTo(savedProfile.getNetWork());
        assertThat(readProfile.getUserName()).isEqualTo(savedProfile.getUserName());
        assertThat(readProfile.getUrl()).isEqualTo(savedProfile.getUrl());
    }

    @Test
    public void testReadWork() {
        Work readWork = workRepository
                .findById(savedWork.getCompany())
                .orElse(null);

        assertThat(readWork.getCompany()).isEqualTo(savedWork.getCompany());
        assertThat(readWork.getPosition()).isEqualTo(savedWork.getPosition());
        assertThat(readWork.getWebSite()).isEqualTo(savedWork.getWebSite());
        assertThat(readWork.getStartDate()).isEqualTo(savedWork.getStartDate());
        assertThat(readWork.getEndDate()).isEqualTo(savedWork.getEndDate());
        assertThat(readWork.getSummary()).isEqualTo(savedWork.getSummary());
    }




}
