package com.example.mbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mbs.entity.Payment;
import com.example.mbs.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/getPay")
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @PostMapping("/postPay")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.savePayment(payment));
    }

    @PutMapping("/updatePay/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable int id, @RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.updatePayment(id, payment));
    }

    @DeleteMapping("/deletePay/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable int id) {
        paymentService.deletePayment(id);
        return ResponseEntity.ok("Payment deleted successfully");
    }

    @GetMapping("/getPay/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable int id) {
        return ResponseEntity.ok(paymentService.getPaymentById(id));
    }

    @GetMapping("/pagePay")
     public Page<Payment> getPaymentsByPage(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "5")int size) {
      return paymentService.getPaymentsByPage(page, size);
    }
    
    @GetMapping("/Paysort")
    public List<Payment> sortByPayment(){
        return paymentService.sortByPayment();
    }
}
