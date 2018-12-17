About:
	@Author: Liming(Frank) Liu
	@contact: limingl@kth.se
	@purpose of the project:
		In this project I developed a three-tier web-based application using framework for all layers.
		Web application framework: Spring Boot + Spring Web MVC + Thymeleaf
		
	@Code source & Copyright:
		I learned part of the structure and code from code example provided by the course: https://github.com/KTH-ID1212/appserv-spring 
		Here is the license of the code example:
			/*
			 * The MIT License
			 *
			 * Copyright 2017 Leif Lindbäck <leifl@kth.se>.
			 *
			 * Permission is hereby granted, free of charge, to any person obtaining a copy
			 * of this software and associated documentation files (the "Software"), to deal
			 * in the Software without restriction, including without limitation the rights
			 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
			 * copies of the Software, and to permit persons to whom the Software is
			 * furnished to do so, subject to the following conditions:
			 *
			 * The above copyright notice and this permission notice shall be included in
			 * all copies or substantial portions of the Software.
			 *
			 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
			 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
			 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
			 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
			 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
			 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
			 * THE SOFTWARE.
			 */
	@Framework structure:
	1. Spring boot:
		dependency file: in pom.xml
		configuration file: in application.properties
		## read the comment in property file, there are 2 optional db types
		## uncomment the first line if want to manually configure the thymeleaf template location
	2. Spring MVC:
		use annotations to auto-configure the server, see the annotations in code
		1 mistake made: the entry point of application Main.class must be in the parent package of other component classes
	3. Thymeleaf:
		configuration: At first I copied Bank.config from the example file but it did't work in this project, so I deleted the configuration class and use default configuration
		--default config: prefix /resources/templates/  suffix .html
		
		Thymeleaf gets template url from ViewController and auto-generate the front page by reading and implementing page element with th:xxx label
		--Thymeleaf hides everything behind the scene, debugging could be devastating
		--don't mess with it unless you have to
	4. Web resources: 
		in resources folder
	5. code structure：
		.model： MVC models
		.dao:use repositories to serve as DAOs
		.controller: the logic controller
		.view: the request handler and related classes
	
	@Suggestion:
		A friendly remind: 
		Spring framework is powerful but at the same time too heavy to be handy, debugging is pure torture
		SO, DON'T MESS WITH IT UNLESS YOU HAVE TO
				 