package pl.edu.pwr.psi_project.service;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import pl.edu.pwr.psi_project.model.KomisjaEgzaminacyjna;
import pl.edu.pwr.psi_project.repository.KomisjaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class KomisjaServiceTest {

    @MockBean
    private KomisjaRepository komisjaRepository;

    @MockBean
    private KomisjaService komisjaService;

    @Before
    public void setUp() {
        KomisjaEgzaminacyjna komisja = new KomisjaEgzaminacyjna();
        komisja.setBudynek("A-2");
        komisja.setSala("329");
        komisja.setDate(LocalDate.parse("2019-02-12" ));
        komisja.setTime(LocalTime.parse("12:00"));

        Mockito.when(komisjaRepository.findAllByDate(komisja.getDate()))
                .thenReturn(Optional.of(Arrays.asList(komisja)));
    }

    @Test
    public void whenValidDate_thenKomisjaShouldBeFound() {
        KomisjaEgzaminacyjna newKomisja = new KomisjaEgzaminacyjna();
        newKomisja.setBudynek("C-3");
        newKomisja.setSala("22");
        newKomisja.setDate(LocalDate.parse("2019-02-12"));
        newKomisja.setTime(LocalTime.parse("14:00"));
        Optional<List<KomisjaEgzaminacyjna>> optional = komisjaRepository.findAllByDate(newKomisja.getDate());
        assertEquals(true,optional.isPresent());
    }
    @Test
    public void whenValidDate_thenKomisjaShouldBeFound2() {
        KomisjaEgzaminacyjna newKomisja = new KomisjaEgzaminacyjna();
        newKomisja.setBudynek("C-3");
        newKomisja.setSala("22");
        newKomisja.setDate(LocalDate.parse("2019-02-12"));
        newKomisja.setTime(LocalTime.parse("14:00"));
        KomisjaEgzaminacyjna saved = komisjaService.save(newKomisja);

        assertEquals(saved,null);
    }

}
