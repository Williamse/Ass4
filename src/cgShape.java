//
//  cgShape.java
//
//  Class that includes routines for tessellating a number of basic shapes.
//
//  Students are to supply their implementations for the functions in
//  this file using the function "addTriangle()" to do the tessellation.
//

import java.awt.*;
import java.nio.*;
import java.awt.event.*;

import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;

import java.io.*;


public class cgShape extends simpleShape
{
    /**
     * constructor
     */
    public cgShape()
    {
    	System.out.println("Oh god not java again!");
    }

    /**
     * 
     * @param subdivisions - How many subdivisions in our cube
     * @return The amount to setp for each triangle
     */
    float GetCubeIncrement(int subdivisions )
    {
    	return (1.0f/(float)subdivisions);
    }
    
    private float PointBetween(float start, float end, float fraction)
    {
    	return ((1 - fraction) * start) + (fraction * end);
    }
    

    /**
     * makeCube - Create a unit cube, centered at the origin, with a given
     * number of subdivisions in each direction on each face.
     *
     * @param subdivision - number of equal subdivisons to be made in each
     *        direction along each face
     *
     * Can only use calls to addTriangle()
     */
    public void makeCube (int subdivisions)
    {

       if( subdivisions < 1 )
        	subdivisions = 1;
	    float triangle_increment = this.GetCubeIncrement(subdivisions);
	    System.out.println(triangle_increment);
	    
	    //Previous values initialized at the top left of square
	    float cur_x = -.5f;
	    float cur_y= 0.5f;
	    float cur_z = -.5f;
	    
	    
	    
	    
	    
	   //FRONT AND BACK
	    for(int cur_subdivision = 0; cur_subdivision < subdivisions;cur_subdivision++)
	    {
	    	cur_y= 0.5f;
	    	for(int cur_sub_y =0; cur_sub_y < subdivisions;cur_sub_y++)
	    	{
      	    	//Draw top left
		    	this.addTriangle(
		    			cur_x, cur_y, 0.5f,
		    			cur_x , cur_y - triangle_increment,0.5f,
		    			cur_x + triangle_increment, cur_y, 0.5f
		    			);
		    	
		    	//Draw bottom right
		    	this.addTriangle(
		    		cur_x + triangle_increment, cur_y, 0.5f,
		  			cur_x,cur_y - triangle_increment,0.5f,
		    		cur_x + triangle_increment , cur_y - triangle_increment, 0.5f
		    		);

//Back ?		    	
		    	//Draw top left
		    	this.addTriangle(
		    			cur_x, cur_y, -0.5f,
		    			cur_x , cur_y - triangle_increment,-0.5f,
		    			cur_x + triangle_increment, cur_y, -0.5f
		    			);
		    	
		    	
		    	//Draw bottom right
		    	this.addTriangle(
		    		cur_x + triangle_increment, cur_y, -0.5f,
		  			cur_x,cur_y - triangle_increment,-0.5f,
		    		cur_x + triangle_increment , cur_y - triangle_increment, -0.5f
		    		);
		   
		    	//top 
		    	cur_y = cur_y - triangle_increment;
	    	}

	    	
	    //	this.addTriangle(x0, y0, z0, x1, y1, z1, x2, y2, z2);
	    	cur_x = cur_x + triangle_increment;
	    }
	  
	    
	     cur_x = -.5f;
	     cur_y= 0.5f;
	     cur_z = -.5f;
	    
	    
	    //left and right
	    for(int cur_sub_z =0; cur_sub_z < subdivisions;cur_sub_z++)
	    {
	    	cur_y= 0.5f;
	    	for(int cur_sub_y = 0; cur_sub_y < subdivisions;cur_sub_y++)
	 	    {
	    		
		    	//Draw top left
		    	this.addTriangle(
		    			.5f , cur_y, cur_z + triangle_increment,
		    			.5f, cur_y, cur_z,
		    			.5f , cur_y - triangle_increment,cur_z
		    			);
		    	
		    	
		    	//Draw bottom right
		    	this.addTriangle(
		    			.5f, cur_y, cur_z + triangle_increment,
		    			.5f,cur_y - triangle_increment,cur_z,
		    			.5f, cur_y - triangle_increment, cur_z + triangle_increment
		    			
		    			
		    			
		    		);
		    	
		    	
		    	
		    	//Draw top left
		    	this.addTriangle(
		    			-.5f , cur_y, cur_z + triangle_increment,
		    			-.5f, cur_y, cur_z,
		    			-.5f , cur_y - triangle_increment,cur_z
		    			);
		    	
		    	
		    	//Draw bottom right
		    	this.addTriangle(
		    			-.5f,cur_y - triangle_increment,cur_z,
		    			-.5f, cur_y - triangle_increment, cur_z + triangle_increment,
		    			-.5f, cur_y, cur_z + triangle_increment
		    			
		    			
		    		);
		    
		    	
		    	
		    	
		    	cur_y = cur_y - triangle_increment;
	 	    }
	    	
	    	cur_z = cur_z + triangle_increment;
    	
	    }
	    
	     cur_x = -.5f;
	     cur_y= 0.5f;
	     cur_z = -.5f;
	    
	    
	    //top and bot
	    for(int cur_sub_x =0; cur_sub_x < subdivisions;cur_sub_x++)
	    {
	    	 cur_z = -.5f;
	    	for(int cur_sub_z = 0; cur_sub_z < subdivisions;cur_sub_z++)
	 	    {
		    	//Draw top left
		    	this.addTriangle(
		    			cur_x + triangle_increment , 0.5f, cur_z + triangle_increment,
		    			cur_x, 0.5f, cur_z,
		    			cur_x , 0.5f ,cur_z + triangle_increment
		    			
		    			);
		    	
		    	
		    	//Draw bottom right
		    	this.addTriangle(
		    			cur_x + triangle_increment,0.5f,cur_z + triangle_increment,
		    			cur_x + triangle_increment ,0.5f, cur_z ,
		    		cur_x, 0.5f, cur_z

		    		
		    		);
		    	
		    	//Draw top left
		    	this.addTriangle(
		    			cur_x + triangle_increment ,- 0.5f, cur_z + triangle_increment,
		    			cur_x, -0.5f, cur_z,
		    			cur_x , -0.5f ,cur_z + triangle_increment
		    			
		    			);
		    	
		    	
		    	//Draw bottom right
		    	this.addTriangle(
		    			cur_x + triangle_increment,-0.5f,cur_z + triangle_increment,
		    			cur_x + triangle_increment ,-0.5f, cur_z ,
		    		cur_x, -0.5f, cur_z

		    		
		    		);
		    		
		    	cur_z = cur_z  + triangle_increment;
	 	    }
	    	
	    	cur_x = cur_x + triangle_increment;
	    }
	   
	    
	  //  this.addTriangle(.9f, .1f, .1f, .1f, .1f, .1f, 9f, 0, 1);
        
        //this.addTriangle(1,0 ,.5f,.5f, .5f, .5f, 0, 0, .5f);
        //Foreach Subdivision?
        	//Calculate bottom left
        	//Calculate top right
        	//Draw it.
        // YOUR IMPLEMENTATION HERE
    }
    
    /**
     * makeCylinder - Create polygons for a cylinder with unit height, centered
     * at the origin, with separate number of radial subdivisions and height
     * subdivisions.
     *
     * @param radius - Radius of the base of the cylinder
     * @param radialDivision - number of subdivisions on the radial base
     * @param heightDivisions - number of subdivisions along the height
     *
     * Can only use calls to addTriangle()
     */
    public void makeCylinder (float radius, int radialDivisions, int heightDivisions)
    {
        if( radialDivisions < 3 )
            radialDivisions = 3;

        if( heightDivisions < 1 )
            heightDivisions = 1;

        // YOUR IMPLEMENTATION HERE
    }

    /**
     * makeCone - Create polygons for a cone with unit height, centered at the
     * origin, with separate number of radial subdivisions and height
     * subdivisions.
     *
     * @param radius - Radius of the base of the cone
     * @param radialDivision - number of subdivisions on the radial base
     * @param heightDivisions - number of subdivisions along the height
     *
     * Can only use calls to addTriangle()
     */
    public void makeCone (float radius, int radialDivisions, int heightDivisions)
    {
        if( radialDivisions < 3 )
            radialDivisions = 3;

        if( heightDivisions < 1 )
            heightDivisions = 1;

        // YOUR IMPLEMENTATION HERE
    }

    /**
     * makeSphere - Create sphere of a given radius, centered at the origin,
     * using spherical coordinates with separate number of thetha and
     * phi subdivisions.
     *
     * @param radius - Radius of the sphere
     * @param slides - number of subdivisions in the theta direction
     * @param stacks - Number of subdivisions in the phi direction.
     *
     * Can only use calls to addTriangle
     */
    public void makeSphere (float radius, int slices, int stacks)
    {
        if( slices < 3 )
            slices = 3;

        if( stacks < 3 )
            stacks = 3;

        // YOUR IMPLEMENTATION HERE
    }

}
