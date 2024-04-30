package com.example.CastroJeepCodes.Controller;
//Api pathways

import com.example.CastroJeepCodes.Model.Jeep;
import com.example.CastroJeepCodes.Service.JeepService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class JeepController {
    private final JeepService jeepService;

    public JeepController(JeepService jeepService) {
        this.jeepService = jeepService;
    }

    @PostMapping("/api/addJeepCode")
    public String postJeepCode(@RequestBody Jeep jeep){
        jeepService.saveDetails(jeep);
        return "Jeep Code: " + jeep + " posted.";
    }

    @GetMapping("/api/getJeepCode/{jeepId}")
    public Jeep getJeepById(@PathVariable int jeepId){
        return jeepService.getJeepById(jeepId);
    }

//    @GetMapping("/api/getJeepsByCodeName/{jeepCodeNames}")
//    public List<Jeep> getJeepsByCode(@PathVariable String jeepCodeNames) {
//        String[] codeNameArray = jeepCodeNames.split(",");
//        List<Jeep> allRoutes = new ArrayList<>();
//
//        for (String codeName : codeNameArray) {
//            List<Jeep> routes = jeepService.getByJeepCode(codeName.trim());
//            allRoutes.addAll(routes);
//        }
//
//        return allRoutes;
//    }

    @GetMapping("/api/getJeepsByCodeName/{jeepCodeNames}")
    public Map<String, List<String>> getJeepsByCode(@PathVariable String jeepCodeNames) {
        List<String> jeepCodes = Arrays.asList(jeepCodeNames.split(","));
        return jeepCodes.stream().collect(Collectors.toMap(
                jeepCode -> jeepCode,
                jeepCode -> jeepService.getByJeepCode(jeepCode).stream()
                        .map(Jeep::getRoute)
                        .collect(Collectors.toList())
        ));
    }

}
