package br.com.example.picpay_chanllenge.infrastructure.controller;

import br.com.example.picpay_chanllenge.infrastructure.dto.out.TransferDTO;
import br.com.example.picpay_chanllenge.infrastructure.dto.out.UserDTO;
import br.com.example.picpay_chanllenge.infrastructure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity create(@RequestBody UserDTO user) {
        this.userService.merge(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok().body(userService.getAll());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getAllByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserDTO> getAllById(@PathVariable String id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping("/id/{cpf}")
    public ResponseEntity<UserDTO> getAllByCPF(@PathVariable String cpf) {
        return ResponseEntity.ok(userService.findByCPF(cpf));
    }

    @PatchMapping("/deposit")
    public ResponseEntity deposit(@RequestBody TransferDTO transferDTO) {
        userService.deposit(transferDTO);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/transfer")
    public ResponseEntity transfer(@RequestBody TransferDTO transferDTO) {
        userService.transfer(transferDTO);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/withdraw")
    @ResponseBody
    public ResponseEntity withdraw(@RequestBody TransferDTO transferDTO) {
        userService.withdraw(transferDTO);
        return ResponseEntity.ok().build();
    }

}
