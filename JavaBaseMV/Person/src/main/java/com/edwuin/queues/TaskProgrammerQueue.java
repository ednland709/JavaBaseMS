package com.edwuin.queues;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.edwuin.model.Person;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class TaskProgrammerQueue {
	private final static String QUEUE_NAME = "TaskProgrammer";
	
	public void CreateUserTask(Person person) throws IOException, TimeoutException
	{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		try (Connection connection = factory.newConnection();
		     Channel channel = connection.createChannel()) {
			
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			
			
			String message = "Hello World!";
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println(" [x] Sent '" + message + "'");
		}
	}
}
