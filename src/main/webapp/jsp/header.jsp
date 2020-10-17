<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-md navbar-dark navbar-custom fixed-top">
        <!-- Text Logo - Use this if you don't have a graphic logo -->
        <!-- <a class="navbar-brand logo-text page-scroll" href="index.html">Aria</a> -->

        <!-- Image Logo -->
        <a class="navbar-brand logo-image" href="./"><img src="./img/logo.png" /></a>
        
        <!-- Mobile Menu Toggle Button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-awesome fas fa-bars"></span>
            <span class="navbar-toggler-awesome fas fa-times"></span>
        </button>
        <!-- end of mobile menu toggle button -->

        <div class="collapse navbar-collapse navigation" id="navbarsExampleDefault">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="btn nav-link page-scroll" href="./">HOME <span class="sr-only">(current)</span></a>
                </li>
              
                <li class="nav-item">
                    <a class="btn nav-link">|</a>
                </li>

                <li class="nav-item">
                    <a class="btn btn-outline-reg page-scroll" href="./login">SIGNIN</a>
                </li>

                <li class="nav-item">
                    <a class="btn nav-link page-scroll" href=""><span class="sr-only"></span></a>
                </li>

                <li class="nav-item">
                    <a class="btn btn-solid-reg page-scroll" href="./register">REGISTER</a>
                </li>

            </ul>
        </div>
    </nav> <!-- end of navbar -->
    <!-- end of navbar -->