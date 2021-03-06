package org.delhivery.controllers;

import org.delhivery.resources.Employee;
import org.delhivery.resources.greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class sampleController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/getEmployee")
    public Employee getEmployee(@RequestParam(value="id") int id,
                                @RequestParam(value="name") String name,
                                @RequestParam(value="role") String role){
        return new Employee(id, name, role);

    }
}
