package com.example.demonwspring.controller;


import com.example.demonwspring.model.Employee;
import com.example.demonwspring.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
            //private EmployeeService employeeService;
    //display list of employees
    @GetMapping("/")
    public String viewIndex(){
        //model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "main";

    }
    @Autowired
    //private EmployeeService employeeService;
    //display list of employees
    @GetMapping("/main")
    public String viewI(){
        //model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "main";

    }

    @Autowired
    private EmployeeService employeeService;
    //display list of employees
    @GetMapping("/index")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "index";

    }

@GetMapping("/InsertNewEmployeeForm")
    public String InsertNewEmployeeForm(Model model){
        //create mdoel attribute to bind form data
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";

    }
    @PostMapping("/InsertEmployee")
    public String InsertEmployee(@ModelAttribute("employee") Employee employee){
        //save employee to databse
        employeeService.saveEmployee(employee);
        return "redirect:/index";
    }


    @GetMapping("/showEmployeeUpdate/{id}")
    public String showEmployeeUpdate(@PathVariable (value = "id") long id, Model model){
        //get employee from the service

        Employee employee=employeeService.getEmployeeById(id);

        //set employee as a model attribute to pre-populate the form
        model.addAttribute("employee",employee);
        return "update_employee";
    }
     @GetMapping("/deleteEmployeeDetails/{id}")
    public String deleteEmployeeDetails(@PathVariable(value = "id") long id){
          //call delete  employee method
             this.employeeService.deleteEmployeeById(id);
             return "redirect:/index";
     }

}
