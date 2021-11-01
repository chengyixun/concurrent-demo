package com.example.concurrentlearn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.example.concurrentlearn")
@EnableAspectJAutoProxy
public class AppConfig {

}
