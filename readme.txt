About:
	@Author: Liming(Frank) Liu
	@contact: limingl@kth.se
	@purpose of the project:
		In this project I implemented a simple Android Hangman game application.
	@Code source & Copyright:
		I learned part of the structure and code from code example provided by the course: https://github.com/KTH-ID1212/exercise5
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
	@important notice:
		This project is far from completely robust, there lies many problems which could could hinder the running of the application, namely:
		-- IDE problem: I write the code in Eclipse, but clearly Eclipse is not suitable for Android development, Android Studio would be far more convenient. There lies many problems for developing on Eclipse
		-- Android SDK problem: Android SDK/JDK/IDE compiler/Virtual devices versions are not always compatible with each other. 
		   I cannot run latest version of virtual devices on my computer, the compromise is that I use following suite in my project:
		   	Compiler: 1.6
		    JRE lib: 1.8
		    Android SDK version: minimum 24   target 28
		    Virtual Device API version: 19 (4.4.2)
		-- When running emulator, the emulator has a different IP address other than "127.0.0.1", therefore need to manually edit the server address( IPv4 address) when building connection
	
	@how to run: ( on emulator)
		(1) start server
		(2) check local machine's IPv4 address then edit in ConnectionActivity's HOST field
		(3) configure correct compiler, JRE, Android SDK and Virtual Device's version
		(4) clean, refresh to build the project
		(5) start as Android application
		
	@debug: debugging information are shown in LogCat in Eclipse, which means that console will not show any debugging information.
			e.printstacktrace() is not applicable in Android, use Log.e() instead
		                        	
	@Project structure:
		Configuration:
			-project.properties
			-AndroidManifest.xml: major configuration file in Android App, configures:
				permission required
				sdk version
				registry of activities( including default entry point)
				
		Resources:
			-pictures: in drawable
			-layout: stores all the layout file, could be edited in GUI.
			-values: manages the id-value, each id could have different values like languages. different value packages are stored in different value folders
		
		Gen/: auto-generated file
			-R file: A registry used in code to get/define/fill the component on UI. Component could show values in static/dynamic( coding) way
			
		src: 
			server/common packages: same as Hangman Game project
			client:
				-net/ controller: modified in several places, but basically serves the same functions
				-activity: activity classes, each activity could be understood as a different page
	