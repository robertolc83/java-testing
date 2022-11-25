package com.robertolc.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {
    //Variables globales
    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;


    /**
     * Descripción: Generamos el metodo setup para incluir las instancias que vamos a utilizar
     * en cada una de las pruebas ya que son redundantes, es decir que se utilizan en todas
     * las pruebas como parte del bloque de preparar el escenario del test
     *
     * @Before : Para ejecutarse antes de cada método Test
     */
    @Before
    public void setup(){
        //Generamos una instancia de paymentGateway mockeado
        paymentGateway = Mockito.mock(PaymentGateway.class);
        //Creamos una instancia de paymentProcessor y le enviamos el objeto mockeado de paymentGateway
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void payment_is_correct() {

        //Invocamos el metodo requestPayment el cual es mockeado para recibir un PaymentResponse OK
        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK));

        //Testeamos el metodo makePayment con assertTrue
        assertTrue(paymentProcessor.makePayment(1000));
    }

    @Test
    public void payment_is_wrong() {

        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR));

        assertFalse(paymentProcessor.makePayment(1000));
    }
}