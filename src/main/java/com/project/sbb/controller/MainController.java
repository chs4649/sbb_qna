package com.project.sbb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
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
}
