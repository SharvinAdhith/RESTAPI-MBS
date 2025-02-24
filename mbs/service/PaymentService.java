package com.example.mbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.mbs.entity.Payment;
import com.example.mbs.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(int id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment updatePayment(int id, Payment payment) {
        payment.setId(id);
        return paymentRepository.save(payment);
    }

    public void deletePayment(int id) {
        paymentRepository.deleteById(id);
    }
     public Page<Payment> getPaymentsByPage(int page, int size){
        Pageable pageable=PageRequest.of(page, size);
        return paymentRepository.findAll(pageable);
    }

    public List<Payment> sortByPayment(){
        return paymentRepository.findAll(Sort.by("amount").descending());
    }
}
