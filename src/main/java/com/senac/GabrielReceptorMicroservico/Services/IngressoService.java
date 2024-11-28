package com.senac.GabrielReceptorMicroservico.Services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.senac.GabrielReceptorMicroservico.Entities.Ingresso;


@Service
public class IngressoService{
	
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "fila-ingresso")
    private void subscribe(Ingresso ingresso) {
        if (ingresso != null) {
            System.out.println("Ingresso recebido: " + ingresso.getNomeComprador());
        } else {
            System.err.println("Mensagem inválida recebida.");
        }
    }
}

