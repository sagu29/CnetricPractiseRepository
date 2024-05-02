package com.ss.webclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@RequestMapping("/student")
public class StudentSystemWebclientApplication {
	
	WebClient webClient;
	
	@PostConstruct
	public void init() {
		webClient= WebClient.builder().baseUrl("http://localhost:8080")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentSystemWebclientApplication.class, args);
	}
	
	@PostMapping("/addStudent")
	public Mono<Student> addStudent(@RequestBody Student student){
		return webClient.post().uri("/student").syncBody(student).retrieve().bodyToMono(Student.class);
	}
	
	@GetMapping("/getAllStudent")
	public Flux<Student> getAllStudents(){
		return webClient.get().uri("/student").retrieve().bodyToFlux(Student.class);
	}
	
	@GetMapping("/studentById/{stId}")
	public Mono<Student> getStudentById(@PathVariable int stId){
		return webClient.get().uri("/student/"+stId).retrieve().bodyToMono(Student.class);
	}
	
	@DeleteMapping("/deletestudentById/{stId}")
	public Mono<String> deletestudentById(@PathVariable int stId){
		return webClient.delete().uri("/student/"+stId).retrieve().bodyToMono(String.class);
	}
	
	@PutMapping("/updateStudent")
	public Mono<Student> updateStudent(@RequestBody Student student){
		return webClient.post().uri("/student").syncBody(student).retrieve().bodyToMono(Student.class);
	}
	
	
	

}
