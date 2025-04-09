package com.project.sbb.controller;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
	
	private int increaseNum = -1;
	
 @RequestMapping("/sbb")
 //下の関数のリターン値をそのままブラウザーに表示
 //下の関数のリターン値を文字列化して、ブラウザー応答をボディーに入れる
 @ResponseBody
 public String index() {
   return "Hello";
  }
 
 @GetMapping("/test")
 @ResponseBody
 public String showMain() {
	return """
			<h1>こんにちは。</h1>
			<input type="text" placeholder="入力してください。"/>
			""";
 }
 
 @GetMapping("/page1")
 @ResponseBody
 public String showGet() {
	return """
			<form method="POST" action="/page2"/>
				<input type="number" name="age" placeholder="年齢"/>
				<br>
				<input type="submit" value="page2へPOST方式で移動"/>
			</form>
			""";
 }
 
 @PostMapping("/page2")
 @ResponseBody
 public String showPage2Post(@RequestParam(defaultValue = "0") int age) {
	return """
			<h1>年齢：%d</h1>
			<h1>こんにちは。ようこそ、POST方式へ。</h1>
			""".formatted(age);
 }
 
 @GetMapping("/page2")
 @ResponseBody
 public String showPost(@RequestParam(defaultValue = "0") int age) {
	return """
			<h1>年齢：%d</h1>
			<h1>こんにちは。ようこそ、GET方式へ。</h1>
			""".formatted(age);
 }
 
 @GetMapping("/plus")
 @ResponseBody
 public int showPlus(int a, int b) {
	 return a + b;
 }
 
 @GetMapping("/minus")
 @ResponseBody
 public int showMinus(int a, int b) {
	 return a - b;
 }
 
 @GetMapping("/increase")
 @ResponseBody
 public int showIncrease() {
	 increaseNum++;
	 return increaseNum;
 }
 
 @GetMapping("/gugudan1")
 @ResponseBody
 public String showGugudan1(int dan, int limit) {
	 String rs = "";
	 
	 for (int i = 1; i <= limit; i++) {
		rs += "%d * %d = %d <br>".formatted(dan, i, dan * i);
	}	 
	 return rs;
 }
 
 @GetMapping("/gugudan2")
 @ResponseBody
 public String showGugudan2(Integer dan, Integer limit) {
	 if (dan == null) {
		dan = 9;
	}
	 
	 if (limit == null) {
		limit = 9;
	}
	 final Integer finalDan = dan;
	 return IntStream.rangeClosed(1, limit) //1から9まで繰り返し
			 .mapToObj(i -> "%d x %d = %d".formatted(finalDan, i, finalDan * i)) //フォーマット
			 .collect(Collectors.joining("<br>"));
 }
 
}
