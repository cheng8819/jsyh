package com.cloud.jsconsumerremittance.feign;

import com.cloud.jsconsumerremittance.pojo.CardNumber;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "js-demo" )
public interface Banking {
    @PutMapping("/add")
    public String add( @RequestBody CardNumber cardNumber);
    @PutMapping("/update")
    public String update( @RequestBody CardNumber cardNumber);
    @GetMapping("/show")
    public CardNumber show( @RequestParam String carenumbername, @RequestParam String carenumbermark);
}
