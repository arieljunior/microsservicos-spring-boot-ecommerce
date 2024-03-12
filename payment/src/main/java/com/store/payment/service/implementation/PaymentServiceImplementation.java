package com.store.payment.service.implementation;

import com.store.payment.domain.Payment;
import com.store.payment.repository.PaymentRepository;
import com.store.payment.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImplementation extends GenericServiceImplementation<Payment, Long, PaymentRepository> implements PaymentService {

    public PaymentServiceImplementation(PaymentRepository repository){
        super(repository);
    }

    public void processPayment(String content, String email, String subject){
        //logic to process payment received by the queue...
    }
}
