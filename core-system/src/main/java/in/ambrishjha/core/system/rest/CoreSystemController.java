package in.ambrishjha.core.system.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ambrishjha.core.system.dto.UserDto;
import in.ambrishjha.core.system.dto.Slowness;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/core-system")
public class CoreSystemController {

    public Long slowness = 0L;

    @GetMapping("/slowness")
    public Long getSlowness() {
    	log.trace("Slowness {}", slowness);
        return slowness;
    }

    @PostMapping("/slowness/{value}")
    public Long setSlowness(@PathVariable("value") Long intSlowness) {
        log.trace("Slowness {}", slowness);
       
        this.slowness =intSlowness;
        return this.slowness;
    }

    @GetMapping
    public UserDto getUser() throws InterruptedException {
        if (slowness > 0)
            Thread.sleep(slowness);
        return new UserDto();
    }

}
