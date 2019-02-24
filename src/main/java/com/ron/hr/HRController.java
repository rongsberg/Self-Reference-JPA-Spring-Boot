package com.ron.hr;


import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
public class HRController {

    private HRDAO dao;
    HRController(HRDAO dao){
        this.dao=dao;
    }
    @GetMapping("/associate/{id}")
    public Associate lookupAssociate(@PathVariable Long id) {
        return dao.findById(id).orElseThrow(() -> new RuntimeException("Not found: "+id));
    }
}