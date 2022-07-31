package in.ambrish.proxy.ms.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import in.ambrish.proxy.ms.dto.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cards/reactive")
public class CardControllerReactive {

    private final WebClient webClient;

    public CardControllerReactive(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("http://127.0.0.1:8082/")
                .build();
    }

    @GetMapping
    public Flux getUsers() {
        List<Integer> userIds = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return Flux.fromIterable(userIds)
                .flatMap(this::getUser);
    }

    public Mono<UserDto> getUser(Integer id) {
        return webClient.get()
                .uri("/core-system")
                .retrieve()
                .bodyToMono(UserDto.class);
    }

}
