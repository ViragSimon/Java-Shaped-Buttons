## Table of contents
* [General info](#general-info)
* [Sources](#sources)
* [Technologies](#technologies)
* [How to use](#how-to-use)
* [Setup](#setup)

## General info
This project is a library that helps to change the shape of the button into particluar polygons or make a uniquely designed button

## Sources 
This library was inspired by a University project at King's College London
	
## Technologies
Project is created with:
* JavaFX Library

## How to use
There are two ways to create a button:

### Using the predetermined /  created classes and their corresponding shaped button
- These classes based on the shaped button that can create a shape based on given coordiantes or parameters
- The shape of the button will be set to the created one

### Using ShapedButton Class:
     
1. Given the number of sides of a polygon and the edge's distance from the centre, a symmetric polygon can be created

    * See: HexagonButton, PentagonButton

2. Given the coordiantes of the edges of the ppolygon, a uniques shape can be created and added to the button

    * See: ArrowButton, CrossButton 
     

## Rules to follow when you create a button
- When you give coordinates for a new polygon then you have to make sure that the given polygon is not self-intersecting.
- The number of sides of the polygon always has to 3 or more
- The number of coordiantes of a poolygomn has to be 6 or more
- Rotation of a polygon has to be given in degrees

## Setup
Download the jar file and add it to your project's libraries





