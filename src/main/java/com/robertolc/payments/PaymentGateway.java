package com.robertolc.payments;

/**
 * Descripción: Interface que va a simular una pasarela de pago
 */
public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest paymentRequest);
}
