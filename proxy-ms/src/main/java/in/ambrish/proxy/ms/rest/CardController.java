package in.ambrish.proxy.ms.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import in.ambrish.proxy.ms.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards/blocking")
public class CardController {

    private final RestTemplate restTemplate;

    @GetMapping("/quick")
    public UserDto getCardFlex() { // 10
        return new UserDto(1L, "Quick in Memory Card");
    }

    @GetMapping("/from-core-system")
    public List<UserDto> getUserCoreSystem() {
        return IntStream.range(0, 10) //
                .mapToObj((i) ->
                        restTemplate.getForEntity("http://127.0.0.1:8082/core-system", UserDto.class).getBody())
                .collect(Collectors.toList());
    }
}
