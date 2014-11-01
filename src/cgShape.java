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
import java.util.ArrayList;
import java.lang.Math;
public class cgShape extends simpleShape
{

    /**
     * constructor
     */
    public cgShape()
    {
    }

    /**
     * Calculate change in z value for the cube
     * @param subdivisions - How many subdivisions in our cube
     * @return The amount to setp for each triangle
     */
    float GetCubeIncrement(int subdivisions )
    {
    	return (1.0f/(float)subdivisions);
    }
    
    /**
     * 
     * @param top_left -Top Left Vertex
     * @param bottom_left - Bottom Left Vertex
     * @param bottom_right - Bottom Right Vertex 
     * @param top_right - Top Right Vertex
     * @param front - Boolean If true the triangle will be drawn facing the camera
     */
    private void MakeSquare(float top_left,float bottom_left,float bottom_right,float top_right,boolean front)
    {
    	
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
	    	DrawFrontBack(subdivisions, triangle_increment, cur_x);
	    	cur_x = cur_x + triangle_increment;
	    }
	  
	    
	     cur_x = -.5f;
	     cur_y= 0.5f;
	     cur_z = -.5f;
	    
	    
	    //left and right
	    for(int cur_sub_z =0; cur_sub_z < subdivisions;cur_sub_z++)
	    {
	    	DrawLeftRight(subdivisions, triangle_increment, cur_z);
	    	cur_z = cur_z + triangle_increment;
	    }
	    
	     cur_x = -.5f;
	     cur_y= 0.5f;
	     cur_z = -.5f;
	    
	    
	    //top and bot
	    for(int cur_sub_x =0; cur_sub_x < subdivisions;cur_sub_x++)
	    {
	    	 DrawTopBot(subdivisions, triangle_increment, cur_x);
	    	cur_x = cur_x + triangle_increment;
	    }
    }

	/**
	 * Draws the top and bottom of a cube
	 * @param subdivisions
	 * @param triangle_increment - Z axis change per stack
	 * @param cur_x - Current x value
	 */
	private void DrawTopBot(int subdivisions, float triangle_increment,
			float cur_x) {
		float cur_z;
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
					cur_x , -0.5f ,cur_z + triangle_increment,
					cur_x, -0.5f, cur_z

					
					);
			
			
			//Draw bottom right
			this.addTriangle(
					cur_x + triangle_increment,-0.5f,cur_z + triangle_increment,
					cur_x, -0.5f, cur_z,
					cur_x + triangle_increment ,-0.5f, cur_z
			

				
				);
			cur_z = cur_z  + triangle_increment;
		}
	}

	/**
	 * Draws the left and right sides of a cube
	 * @param subdivisions
	 * @param triangle_increment - Z axis change per stack
	 * @param cur_z - Current z value
	 */
	private void DrawLeftRight(int subdivisions, float triangle_increment,
			float cur_z) {
		float cur_y;
		cur_y= 0.5f;
		for(int cur_sub_y = 0; cur_sub_y < subdivisions;cur_sub_y++)
		{
			
			//Draw top left
			this.addTriangle(
					.5f , cur_y, cur_z + triangle_increment,
					.5f , cur_y - triangle_increment,cur_z,
					.5f, cur_y, cur_z
					
					);
			
			
			//Draw bottom right
			this.addTriangle(
					.5f, cur_y, cur_z + triangle_increment,
					.5f, cur_y - triangle_increment, cur_z + triangle_increment,
					.5f,cur_y - triangle_increment,cur_z
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
	}

	/**
	 * Draws the front and back of a cube
	 * @param subdivisions
	 * @param triangle_increment - Z axis change per stack
	 * @param cur_x - Current x value
	 */
	private void DrawFrontBack(int subdivisions, float triangle_increment,
			float cur_x) {
		float cur_y;
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


			//Draw top left
			this.addTriangle(
					cur_x, cur_y, -0.5f,
					cur_x + triangle_increment, cur_y, -0.5f,
					cur_x , cur_y - triangle_increment,-0.5f
		
					);
			
			
			//Draw bottom right
			this.addTriangle(
				cur_x + triangle_increment, cur_y, -0.5f,
				cur_x + triangle_increment , cur_y - triangle_increment, -0.5f,
				cur_x,cur_y - triangle_increment,-0.5f
				
				);
   
			//top 
			cur_y = cur_y - triangle_increment;
		}
	}
    
    //Takes in the radius of the circle and the angle. Of each segment
    private ArrayList<float[]> pointOnCircle(float radius,float angle)
    {
    	ArrayList<float[]> return_val = new ArrayList<float[]>();
    	
        //Loop through 360 degrees starting at zero
        for(double x= 0; x < 360; x += angle )
        {
        	float[] temp_arr = new float[2];
        	double asRadians = Math.toRadians(x);
        	
        	//add array
        	temp_arr[0] = (float) (radius * (Math.cos(asRadians)));
        	temp_arr[1] = (float) (radius * (Math.sin(asRadians)));
        	
        	return_val.add(temp_arr);
        }
    	
    	return return_val;
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
        
        //Degrees between each line in the top and bottom of the cylinder
        float degrees_between = (float) 360 / (float) radialDivisions;
        float increment_z = (float) 1.0/ (float)heightDivisions;
        
        ArrayList<float[]> pointsTop = pointOnCircle(radius,degrees_between);

        //Loop through 360 degrees starting at zero
        for(int x= 0; x < pointsTop.size(); x++ )
        {
        	float[] cur = pointsTop.get(x);
        	float[] next = (x == pointsTop.size() - 1) ? pointsTop.get(0) : pointsTop.get(x + 1);
        	
        	//Top
        	this.addTriangle(0, 0, 0.5f, cur[0],cur[1], .5f,next[0], next[1], .5f);
        	
        	
            this.addTriangle(
            		cur[0],cur[1] ,.5f,   
            		next[0],next[1] , .5f - increment_z,
            		next[0], next[1], .5f  );
        	
        	
        	float cur_z = 0.5f;
        	for(int h = 0; h < heightDivisions ; h++)
        	{

        			//Top
        			this.addTriangle(cur[0], cur[1], cur_z,cur[0], cur[1], cur_z - increment_z  , next[0],next[1], cur_z - increment_z);

            		this.addTriangle(cur[0], cur[1], cur_z,cur[0], cur[1], cur_z ,next[0],next[1], cur_z - increment_z );
            		cur_z = cur_z -increment_z;
        	}
        	//Bottom
          	this.addTriangle(0, 0, -0.5f,next[0], next[1], -.5f,cur[0],cur[1],-.5f);
        	
        }
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

      //Degrees between each line in the top and bottom of the cylinder
       float degrees_between = (float) 360 / (float) radialDivisions;
       
       float increment_z = (float) 1/ (float)heightDivisions;
       float increment_rad = increment_z/(float)2;
       
  
       float cur_rad = 0.5f;
       float cur_z  = -0.5f;
       
       ArrayList<float[]> oldPoints = null;
       ArrayList<float[]> pointsTop;
       ArrayList<float[]> pointsTopFirst = null;
       for(int hdiv = 0; hdiv < heightDivisions;hdiv++)
       {
    	   //Special case used for the bottom of the cone
    	   if(hdiv ==0)
    	   {
    		   pointsTopFirst = pointOnCircle(cur_rad,degrees_between );
    	   }
    	   
    	   //Points for the next slice
    	   pointsTop = pointOnCircle(cur_rad - increment_rad ,degrees_between);
    	   
	       //Loop through 360 degrees starting at zero
	       for(int x= 0; x < pointsTop.size(); x++ )
	       {
		       	float[] cur = pointsTop.get(x);
		       	float[] next = (x == pointsTop.size() - 1) ? pointsTop.get(0) : pointsTop.get(x + 1);
		       	
		       	float[] dependCur;
		       	float[] dependNext;
		       	
		       	if(hdiv != 0)
		       	{
		       		dependCur  = oldPoints.get(x);
		       		dependNext = (x == oldPoints.size() - 1) ? oldPoints.get(0) : oldPoints.get(x + 1); 	
		       	}
		       	else
		       	{

		       		//Special case bottom
		       		dependCur = pointsTopFirst.get(x); 
		       		dependNext =  (x == pointsTopFirst.size() - 1) ? pointsTopFirst.get(0) : pointsTopFirst.get(x + 1);
		       		
		       		//Bottom
		       		this.addTriangle(dependCur[0],dependCur[1],-.5f,0, 0, -0.5f,dependNext[0], dependNext[1], -.5f);
		       	}
		       	
		        makeSquareTriangle(increment_z, cur_z, cur, next,
		        		dependCur, dependNext);
		      //Bottom
	       		this.addTriangle(dependCur[0],dependCur[1],-.5f,0, 0, -0.5f,dependNext[0], dependNext[1], -.5f);
		     
	       }	
	       cur_z = cur_z  + increment_z;
	       oldPoints = pointsTop;
	       cur_rad = cur_rad - increment_rad;
       }
    }
    
    /**
     * Makes a square comprised of triangles
     * @param increment_z - Amount to change the z axis by from the bottom to the top
     * @param cur_z - Current z value
     * @param TopLeft - Float array of the form [xval,yval] for the top left vertacie 
     * @param TopRight
     * @param BottomLeft
     * @param BottomRight
     */
   	private void makeSquareTriangle(float increment_z, float cur_z,
			float[] TopLeft, float[] TopRight, float[] BottomLeft, float[] BottomRight) {
		
		//Use old values for points going up the cone
		this.addTriangle(BottomLeft[0],BottomLeft[1],cur_z,BottomRight[0],BottomRight[1],cur_z,TopLeft[0],TopLeft[1],cur_z + increment_z);
		this.addTriangle(BottomRight[0],BottomRight[1],cur_z,TopRight[0],TopRight[1],cur_z + increment_z,TopLeft[0],TopLeft[1],cur_z + increment_z);
	}

	
	/**
	 * Creates a square comprised of triangles for a sphere
	 * @param old_z - Z value for the lower stack
	 * @param cur_z - Z Value for the upper stack
	 * @param TopLeft - Float array of the form [xval,yval] for the top left vertacie 
	 * @param TopRight
	 * @param BottomLeft
	 * @param BottomRight
	 */
	private void makeSquareTriangleSphere(float old_z, float cur_z,
			float[] TopLeft, float[] TopRight, float[] BottomLeft, float[] BottomRight) {
		
		//Use old values for points going up the cone
		this.addTriangle(BottomLeft[0],BottomLeft[1],cur_z,BottomRight[0],BottomRight[1],cur_z,TopLeft[0],TopLeft[1],old_z);
		this.addTriangle(BottomRight[0],BottomRight[1],cur_z,TopRight[0],TopRight[1],old_z,TopLeft[0],TopLeft[1],old_z);
	}
	
	/**
	 * Uses trigonometry to calculate the current z axis value at a given stack in a sphere
	 * @param cur_stack - The current stack we are at 
	 * @param degrees_between_stacks - The degrees between each stack in the sphere
	 * @return
	 */
	private float get_z(int cur_stack,float degrees_between_stacks)
	{
		return (float) (-0.5 * Math.cos(Math.toRadians(degrees_between_stacks * (float)cur_stack)));
	}
	/**
	 * Uses trigonometry to calculate the current radius value at a given stack in a sphere
	 * @param cur_stack - The current stack we are at 
	 * @param degrees_between_stacks - The degrees between each stack in the sphere
	 * @return
	 */
	private float cur_rad(int cur_stack,float degrees_between_stacks)
	{
		
		return (float) (-0.5 * Math.sin(Math.toRadians(degrees_between_stacks * (float)cur_stack)));
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
        
        //Arraylists that hold the top(new values) and bottom (old values from the previous stack)
        ArrayList<float[]> points_top =  new ArrayList<float[]>();
        ArrayList<float[]> points_bottom = new ArrayList<float[]>();
        
        //Degrees to increment
        float degrees_between_z = (float) 180 / (float) stacks;
        float slice_increase = (float) 360 / (float)slices; 
        
        //Used to calcualte change in z per stack
        float cur_z =   -0.5f;
        float old_z = -0.5f;
        
        //Start at the first stack
        for(int next_stack = 1; next_stack <= stacks;next_stack++ )
        {
        	//Calculate radius at current point on sphere
        	float cur_rad = this.cur_rad(next_stack, degrees_between_z);
        	
		    	//at z = 0.5 or -0.5 we need to manually set the first or final array list of values to zero
		    	if(next_stack  == 1)
		    	{
		    		SetPole(slices, points_bottom);
		    	}
        		else if(next_stack == stacks)
            	{
            		SetPole(slices, points_top);
            	}
        	
        	//If not final stack loop around sphere calculating values
        	if(next_stack != stacks)
        		points_top = pointOnCircle(cur_rad,slice_increase );
        	
        	cur_z =  (float)this.get_z(next_stack,degrees_between_z);
        	
        	//Draw the triangles around the sphere
        	for(int sl = 0 ; sl < slices; sl++)
        	{
        			int next_index = (sl < slices - 1) ? (sl  + 1) : 0;
        			this.makeSquareTriangleSphere(cur_z,old_z, points_top.get(sl), points_top.get(next_index), points_bottom.get(sl), points_bottom.get(next_index));
        	}    

        	//Update old z value becomes current. old points beomce the current points.
        	old_z = cur_z;
        	points_bottom = new ArrayList<float[]>(points_top);
        }
    }

    /**
     * Sets an array list to contain a list of float array initialized to [0,0]
     * @param slices - Number of slices in the pole
     * @param list  - list to populate with values 
     */
	private void SetPole(int slices, ArrayList<float[]> list) {
		list.clear();
		for(int temp = 0; temp < slices;temp++)
		{
			list.add(new float[]{0,0});
		}
	}

}
