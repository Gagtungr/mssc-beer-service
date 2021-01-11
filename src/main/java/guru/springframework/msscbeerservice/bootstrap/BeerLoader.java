package guru.springframework.msscbeerservice.bootstrap;

import guru.springframework.msscbeerservice.domain.Beer;
import guru.springframework.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadBeers();

    }

    private void loadBeers() {

        if(beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("GLARUS")
                    .beerStyle("EPA")
                    .quantityToBrew(200)
                    .upc(3434242434L)
                    .price(new BigDecimal("12.95"))
                    .minOnHand(12)
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("BERNARD")
                    .beerStyle("LAGER")
                    .quantityToBrew(100)
                    .upc(12000000L)
                    .price(new BigDecimal("15.95"))
                    .minOnHand(20)
                    .build());

        }

    }
}
